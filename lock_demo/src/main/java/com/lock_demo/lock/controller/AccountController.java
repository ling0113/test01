package com.lock_demo.lock.controller;

import com.lock_demo.lock.entity.Account;
import com.lock_demo.lock.service.AccountService;
import com.lock_demo.lock.service.AccountServiceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: com.lock_demo.lock.controller.AccountController
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/6 9:56
 * @Version: 1.0
 */
@RestController
@RequestMapping("/Account")
public class AccountController {
    @Autowired
    public AccountService accountService;

    /**
     * 查询分类列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Account> getAll() {
        return accountService.getAll();
    }


}
