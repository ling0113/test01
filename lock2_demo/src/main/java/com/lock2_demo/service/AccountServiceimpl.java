package com.lock2_demo.service;



import com.lock2_demo.dao.AccountDao;
import com.lock2_demo.entity.Account;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public enum Result {
        SUCCESS,
        DEPOSIT_NOT_ENOUGH,
        FAILED,
    }

    /**
     *  转账操作  悲观锁
     * @param fromId 扣款账户
     * @param toId  收款账户
     * @param value 金额
     * @Description:  死锁解决方案 根据主键的大小来加锁  从而确定锁的顺序 用锁顺序解决死锁
     * @return
     */
    //@Transactional(isolation = Isolation.READ_COMMITTED)
    public Result transferPessimistic(int fromId, int toId, BigDecimal value) {
        Account from, to;
        try {
            //先锁住id 大的,避免死锁
            if (fromId>toId){
                //from = accountDao.selectByIdForUpdate(fromId);
                //to = accountDao.selectByIdForUpdate(toId);
            }else {
                //from = accountDao.selectByIdForUpdate(fromId);
                //to = accountDao.selectByIdForUpdate(toId);
            }
        }catch (Exception e){
            log.info(e.getMessage());
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.FAILED;
        }

        return null;
    }


}
