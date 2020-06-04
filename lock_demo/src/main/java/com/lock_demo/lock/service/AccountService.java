package com.lock_demo.lock.service;

import com.lock_demo.lock.entity.Account;
import java.util.List;

/**
 * @ClassName: com.lock_demo.lock.service.AccountService
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/6 9:58
 * @Version: 1.0
 */
public interface AccountService {

    List<Account> getAll();


}
