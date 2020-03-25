package com.test.test01.springboot02.controller;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: com.test.test01.springboot02.controller.MemberController
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/9/5 14:23
 * @Version: 1.0
 */
@RestController   /*表示所有方法返回json格式*/
@EnableAutoConfiguration  /*自动配置.扫包范围:当前类中 */
public class MemberController {
    /*
    springcloud 依赖于springboot实现微服务  ### springboot默认集成springmvc组件
    springcloud使用springmvc编写微服务http接口 (http+json)
    */
    @RequestMapping("/meindex")
    private String meIndex(){
        return "测试";
    }




}
