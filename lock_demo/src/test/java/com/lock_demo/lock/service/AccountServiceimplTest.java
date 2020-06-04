package com.lock_demo.lock.service;

import static org.junit.jupiter.api.Assertions.*;

import com.lock_demo.lock.dao.AccountDao;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: com.lock_demo.lock.service.AccountServiceimplTest
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/13 18:42
 * @Version: 1.0
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class AccountServiceimplTest {

    // 并发数
    private static final int COUNT = 500;

    @Resource
    AccountDao accountDao;

    @Resource
    AccountServiceimpl accountServiceimpl;


}