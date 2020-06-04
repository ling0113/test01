package com.lock_demo.lock.service;


import com.lock_demo.lock.exception.RetryException;
import com.lock_demo.lock.dao.AccountDao;
import com.lock_demo.lock.entity.Account;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiPredicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @ClassName: com.test.test01.lock.AccountService
 * @Description: mybatis  实现悲观锁和乐观锁
 * @Author: lgrong
 * @CreateDate: 2020/4/29 15:45
 * @Version: 1.0
 */
@Slf4j
@Service
public class AccountServiceimpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountDao.selectAlls();
        return accounts;
    }

    //比较两个值大小
    private BiPredicate<BigDecimal, BigDecimal> isDepositEnough = (deposit, value) -> deposit.compareTo(value) > 0;

    /*public static void main(String[] args) {
        AccountServiceimpl accountServiceimpl = new AccountServiceimpl();
        boolean test = accountServiceimpl.isDepositEnough.test(new BigDecimal(500), new BigDecimal(200));//true
        System.out.println(test);
    }*/

    public enum Result {
        SUCCESS,
        DEPOSIT_NOT_ENOUGH,
        FAILED,
    }

    /**
     * 转账操作  悲观锁
     *
     * @param fromId 扣款账户
     * @param toId 收款账户
     * @param value 金额
     * @Description: 死锁解决方案 根据主键的大小来加锁  从而确定锁的顺序 用锁顺序解决死锁
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Result transferPessimistic(int fromId, int toId, BigDecimal value) {
        Account from, to;
        try {
            //先锁住id 大的,避免死锁
            if (fromId > toId) {
                from = accountDao.selectByIdForUpdate(fromId);
                to = accountDao.selectByIdForUpdate(toId);
            } else {
                from = accountDao.selectByIdForUpdate(fromId);
                to = accountDao.selectByIdForUpdate(toId);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.FAILED;
        }
        //钱不足
        if (!isDepositEnough.test(from.getDeposit(), value)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info(String.format("Account %d is not enough.", fromId));
            return Result.DEPOSIT_NOT_ENOUGH;
        }
        //扣款账户扣钱
        from.setDeposit(from.getDeposit().subtract(value));
        //收款账户加钱
        to.setDeposit(to.getDeposit().add(value));
        //
        accountDao.updateDeposit(from);
        accountDao.updateDeposit(to);
        return Result.SUCCESS;
    }

    /**
     * 乐观锁 用版本号限制
     * @param fromId
     * @param toId
     * @param value
     * @return
     */
    public Result transferOptimistic(int fromId, int toId, BigDecimal value) {
        Account from = accountDao.selectById(fromId);
        Account to = accountDao.selectById(toId);
        //钱不足
        if (!isDepositEnough.test(from.getDeposit(), value)) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.DEPOSIT_NOT_ENOUGH;
        }
        from.setDeposit(from.getDeposit().subtract(value));
        to.setDeposit(to.getDeposit().add(value));

        int r1,r2;
        if (from.getId()>to.getId()){
            r1 = accountDao.updateDepositWithVersion(from);
            r2 = accountDao.updateDepositWithVersion(to);
        }else {
            r1 = accountDao.updateDepositWithVersion(to);
            r2 = accountDao.updateDepositWithVersion(from);
        }
        if (r1 < 1 || r2 < 1) {
            // 失败，抛出重试异常，执行重试
            throw new RetryException("Transfer failed, retry.");
        } else {
            return Result.SUCCESS;
        }
    }


}
