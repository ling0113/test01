package com.test.test01.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;


/**
 * @ClassName: com.test.test01.http.Http
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/4/28 15:17
 * @Version: 1.0
 */
public class Http6 {

    public static void main(String[] args) {
     /*   String body = HttpRequest.post("http://crm.mingdiao.com.cn/homeDecoration/getHomeDecorationData")
            //.form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .header("Content-Type",
                "application/json")
            .charset("UTF-8")
            .body(String.valueOf(json3))
            .execute().body();*/

        JSONObject json = JSONUtil.createObj();

        String body = HttpUtil.createPost("http://crm.mingdiao.com.cn/homeDecoration/getHomeDecorationData").body(String.valueOf(json)).execute().body();
        System.out.println(body);
    }
}
