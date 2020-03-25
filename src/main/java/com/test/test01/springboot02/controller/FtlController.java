package com.test.test01.springboot02.controller;

import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: com.test.test01.springboot02.controller.FtlController
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/9/6 18:53
 * @Version: 1.0
 */
@Controller
public class FtlController {
    @RequestMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("name","美丽的天使...");
        return "index";
    }
}
