package com.test.test01.http;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/**
 * @ClassName: com.test.test01.http.Httptest
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/3/9 17:07
 * @Version: 1.0
 */
public class Httptest {

    public static void main(String[] args) throws Exception {
        /*
         # 魔看获取令牌参数
            client_id = R0hJSktMTUMjk=
            client_secret = 965ECcNdoYW25Zg0s9nTRjKpdJrguYlSN0Rlqr6S
        */
        //请求列表页
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
        System.out.println("accessToken  "+accessToken);

        /****************************请求2***********************/

        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap.put("page", "1");
        paramMap.put("limit", "10");
        //paramMap.put("filter", "序列号值  模糊查询相机");
        //paramMap.put("filter_cameras", "批量摄像机序列号		以逗号分隔的设备序列号字符串如（138424375821,138424375822)");
        //paramMap.put("is_online", "Y或N		查询在线或不在线的设备（Y：在线，N：不在线），查询全部设备时不传递");
        HttpResponse execute2 = HttpRequest
            .get("https://api.morecanai.com/client/v1/camera")
            .header(Header.ACCEPT, "application/json")
            .header("Authorization", "Bearer " + accessToken)
            .form(paramMap2)
            .execute();

        String body = execute2.body();
        JSONObject json2 =JSONObject.parseObject(body);
        int status2 = execute2.getStatus();

        if (status2 != HttpStatus.HTTP_OK) {
            Object message = json2.get("message");
            System.out.println(status2 + "bbbb" + message.toString());
        }

        //查询详情
        HttpResponse execute3 = HttpRequest
            .get("https://api.morecanai.com/client/v1/camera/92518416448659/show")
            .header(Header.ACCEPT, "application/json")
            .header("Authorization", "Bearer " + accessToken)
            .execute();
        //JSONObject json3 = new JSONObject(execute3.body());
        //MoreCanaiShow moreCanaiShow = JSON.parseObject(String.valueOf(json3), MoreCanaiShow.class);
        JSONObject userJson = JSONObject.parseObject(execute3.body());
        MoreCanaiShow user = JSON.toJavaObject(userJson,MoreCanaiShow.class);
        System.out.println("aa  "+user);

        HashMap<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("camer_serial_numbers", "92512710669342");
        HttpResponse execute4 = HttpRequest
            .post("https://api.morecanai.com/client/v1/camera/streaming-address")
            .header(Header.ACCEPT, "application/json")
            .header("Authorization", "Bearer " + accessToken)
            .form(paramMap4)
            .execute();
        String body4 = execute4.body();
        JSONObject json4 =JSONObject.parseObject(body4);
        int status4 = execute4.getStatus();
        if (status4 != HttpStatus.HTTP_OK) {
            Object message = json4.get("message");
            System.out.println(status4 + "bbbb" + message.toString());
        }


    }

}
