package com.test.test01.http;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @ClassName: com.test.test01.http.Httptest2
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/3/11 11:33
 * @Version: 1.0
 */
public class Httptest2 {

    public static void main(String[] args) {

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("client_id", "R0hJSktMTUMjk=");
        paramMap.put("client_secret", "965ECcNdoYW25Zg0s9nTRjKpdJrguYlSN0Rlqr6S");
        HttpResponse execute = HttpRequest
            .post("https://api.morecanai.com/client/v1/obtain-access-token")
            .header(Header.ACCEPT, "application/json")
            .form(paramMap)
            .execute();

        int status = execute.getStatus();
        JSONObject json = JSONObject.parseObject(execute.body());
        if (status != HttpStatus.HTTP_OK) {
            Object message = json.get("message");
            System.out.println(status + "   " + message.toString());
        }
        String accessToken = json.get("access_token").toString();




        //开启直播
        HashMap<String, Object> paramMap1 = new HashMap<>();
        //paramMap1.put("camer_serial_numbers", "92518416448659");
        paramMap1.put("action", "start_streaming");
        HttpResponse execute1 = HttpRequest
            .post("https://api.morecanai.com/client/v1/camera/92518416448659/camera-message")
            .header(Header.ACCEPT, "application/json")
            .header("Authorization", "Bearer "+accessToken)
            .form(paramMap1)
            .execute();
        String body1 = execute1.body();
        JSONObject json1 =JSONObject.parseObject(body1);
        int status1 = execute1.getStatus();
        if (status1 != HttpStatus.HTTP_OK) {
            Object message = json1.get("message");
            System.out.println(status1 + "开启直播" + message.toString());
        }
        System.out.println(body1);



        //直播地址
        HashMap<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("camer_serial_numbers", "92518416448659");
        HttpResponse execute4 = HttpRequest
            .post("https://api.morecanai.com/client/v1/camera/streaming-address")
            .header(Header.ACCEPT, "application/json")
            .header("Authorization", "Bearer "+accessToken)
            .form(paramMap4)
            .execute();
        String body4 = execute4.body();
        System.out.println(body4);
        JSONObject json4 =JSONObject.parseObject(body4);
        System.out.println(json4);
        int status4 = execute4.getStatus();
        if (status4 != HttpStatus.HTTP_OK) {
            Object message = json4.get("message");
            System.out.println(status4 + "直播地址" + message.toString());
        }
        LiveIp user = JSON.toJavaObject(json4,LiveIp.class);

        System.out.println(user);
        LiveIp javaObject = null;

        for (Entry<String, Object> entry : json4.entrySet()) {

            JSONObject json5 =JSONObject.parseObject(entry.getValue().toString());
            LiveIp user2 = JSON.toJavaObject(json5,LiveIp.class);

            System.out.println(user2);
        }



    }

}
