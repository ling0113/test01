package com.lock2_demo.dao;

import com.lock2_demo.entity.Account;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface AccountDao extends Mapper<Account> {

    List<Account> selectAlls();


}