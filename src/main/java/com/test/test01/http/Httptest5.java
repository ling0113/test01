package com.test.test01.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.test01.http.entity.OfferBebVo;

/**
 * @ClassName: com.test.test01.http.Httptest5
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/5/12 14:03
 * @Version: 1.0
 */
public class Httptest5 {

    public static void main(String[] args) {
        OfferBebVo offerBebVo = new OfferBebVo();
        offerBebVo.setAppointmentType("1");
        offerBebVo.setLabelName("测试");
        offerBebVo.setPhone("123456");
        offerBebVo.setSize("20");
        offerBebVo.setUsername("小米");

        String s = JSON.toJSONString(offerBebVo);

        String body = HttpRequest.post("http://crm.mingdiao.com.cn/homeDecoration/getBebData")
            .timeout(20000)//超时，毫秒
            .header("Content-Type","application/json")
            .charset("UTF-8")
            .body(s)
            .execute()
            .body();
        JSONObject json = JSONObject.parseObject(body);
        System.out.println(json);
        JSONObject header = JSONObject.parseObject(String.valueOf(json.get("header")));
        Object status = header.get("status");
        if (!status.equals(HttpStatus.HTTP_OK) ) {
            Object message = header.get("msg");
        }
    }

}
