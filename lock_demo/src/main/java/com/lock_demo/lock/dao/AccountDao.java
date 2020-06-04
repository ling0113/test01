package com.lock_demo.lock.dao;


import com.lock_demo.lock.entity.Account;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface AccountDao extends Mapper<Account> {

    Account selectByIdForUpdate(int fromId);

    List<Account> selectAlls();

    void updateDeposit(Account from);

    Account selectById(int fromId);

    int updateDepositWithVersion(Account from);
}