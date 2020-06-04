package com.test.test01.http;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.test01.http.entity.OfferAsdVo;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: com.test.test01.http.Httptest4
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/4/27 17:47
 * @Version: 1.0
 */
public class Httptest4 {

    public static void main(String[] args) {

        //爱仕达报价接口
        Map<String, Object> map = new HashMap<>();

/*        map.put("a", 2);
        map.put("b", 1);
        LiveIp liveIp = new LiveIp();
        liveIp.setHls("1");
        liveIp.setShls("1");
        liveIp.setRtmp("1");
        liveIp.setStatus("1");
        liveIp.setMessage("1");
        liveIp.setRtmp_length(1);*/

        OfferAsdVo vo = new OfferAsdVo();
        vo.setAppointmentType("2");
        vo.setLabelName("装修报价");
        vo.setPhone("13800000002");
        vo.setSize("60");
        vo.setUsername("张测试");
        vo.setStyle("测试风格");
        String s = JSON.toJSONString(vo);

        JSONObject json3 = new JSONObject();
        json3.put("appointmentType", "2");
        json3.put("labelName", "装修报价.");
        json3.put("phone", "13800000001.");
        json3.put("size", "60");
        json3.put("username", "张测试");
        json3.put("style", "测试风格");

        Map<String, Object> paramMap = BeanUtil.beanToMap(vo);
        System.out.println(paramMap);
        String body = HttpRequest.post("http://crm.mingdiao.com.cn/homeDecoration/getHomeDecorationData")
            //.form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .header("Content-Type",
                "application/json")
            .charset("UTF-8")
           .body(s)
            .execute().body();

        JSONObject json = JSONObject.parseObject(body);
        System.out.println(json);
        Object errcode = json.get("header");
        JSONObject json2 = JSONObject.parseObject(String.valueOf(errcode));
        System.out.println(json2);
        Object status = json2.get("status");
        if (!status.equals(0)) {
            Object message = json2.get("msg");
            System.out.println(errcode + "   " + message.toString());
        }
    }
}
