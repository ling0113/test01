package com.test.test01.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.test01.http.entity.Department;
import com.test.test01.http.entity.HttpDep;
import com.test.test01.http.entity.HttpUser;
import com.test.test01.http.entity.UserList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: com.test.test01.http.Httptest
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/3/9 17:07
 * @Version: 1.0
 */
public class Httptest3 {
    //名雕企业id
    private String corpId;

    //易装宝应用id
    private String corpsecret;

    public static void main(String[] args) throws Exception {
        //获取token
        String accessToken = getAccessToken();
        System.out.println(accessToken);
        //读取顶级部门id
        //int departmentId = getDepartment(accessToken);
        //查询全部人员
        //getUserList(accessToken,departmentId);
        //查询所有部门
        /*List<Department> departmentList = getDepartments(accessToken, "1001001292");
        System.out.println(departmentList);*/

        long startTime = System.currentTimeMillis(); //获取开始时间
        getUserList(accessToken,1001000009);
        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间：" + (endTime - startTime) + "ms"); //输出程序运行时间


    }
    private static void getUserList(String accessToken,int departmentId) {
        HashMap<String, Object> paramMap = new HashMap<>();
/*
        accessToken = "3czx4Oyye2WKd9udD5ijHtV2nikTISKWukcPMZ-BnqKAUKJ3KuQJ4qUUukFTccxjaD3Be1Fbm-MjdJQHLkeUS2YyyQIcVaHv9WoKyhKiQYOktzmAVMpiMnO2y8f8VAjuN7slEfgoyh7rn3Gg0fpefpsKm6-WDFNC4z47SzHvRIGwd9NKaxZmeK-k5WMZz1Obst6QxP5GJ2TIBGjZ09n8Nw";
*/
        paramMap.put("access_token", accessToken);
        paramMap.put("department_id", departmentId);
        paramMap.put("fetch_child", 1);
        HttpResponse execute = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/user/list")
            .form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .execute();
        JSONObject json = JSONObject.parseObject(execute.body());
        Object errcode = json.get("errcode");
        if (!errcode.equals(0) ) {
            Object message = json.get("errmsg");
            System.out.println(errcode + "   " + message.toString());
        }

        HttpUser httpUser = JSON.toJavaObject(json, HttpUser.class);
        List<UserList> userlist = httpUser.getUserlist();
        List<UserList> collect = new ArrayList<>();
        collect = userlist.stream().filter(u -> u.getStatus() == 1).collect(Collectors.toList());
        System.out.println(collect);


    }

    /**
     *读取所有部门
     * @param accessToken
     * @param id 部门id。获取指定部门及其下的子部门。 如果不填，默认获取全量组织架构
     * @return
     */
    private static List<Department>  getDepartments(String accessToken,String id) {
        HashMap<String, Object> paramMap = new HashMap<>();
        //accessToken = "3czx4Oyye2WKd9udD5ijHtV2nikTISKWukcPMZ-BnqKAUKJ3KuQJ4qUUukFTccxjaD3Be1Fbm"
         //   + "-MjdJQHLkeUS2YyyQIcVaHv9WoKyhKiQYOktzmAVMpiMnO2y8f8VAjuN7slEfgoyh7rn3Gg0fpefpsKm6-WDFNC4z47SzHvRIGwd9NKaxZmeK"
          //  + "-k5WMZz1Obst6QxP5GJ2TIBGjZ09n8Nw";
        paramMap.put("access_token", accessToken);
        if (id!=null){
            paramMap.put("id", id);
        }
        HttpResponse execute = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
            .form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .execute();
        String body = execute.body();
        JSONObject json = JSONObject.parseObject(body);
        Object errcode = json.get("errcode");
        if (!errcode.equals(0) ) {
            Object message = json.get("errmsg");
            System.out.println(errcode + "   " + message.toString());
        }

        HttpDep httpDep = JSON.toJavaObject(json,HttpDep.class);
        List<Department> departmentList = httpDep.getDepartment();
        return departmentList;
    }


    /**
     * 读取顶级部门id
     * @param accessToken
     * @return
     */
    private static int getDepartment(String accessToken) {
        HashMap<String, Object> paramMap = new HashMap<>();
        //accessToken = "3czx4Oyye2WKd9udD5ijHtV2nikTISKWukcPMZ-BnqKAUKJ3KuQJ4qUUukFTccxjaD3Be1Fbm"
        //   + "-MjdJQHLkeUS2YyyQIcVaHv9WoKyhKiQYOktzmAVMpiMnO2y8f8VAjuN7slEfgoyh7rn3Gg0fpefpsKm6-WDFNC4z47SzHvRIGwd9NKaxZmeK"
        //  + "-k5WMZz1Obst6QxP5GJ2TIBGjZ09n8Nw";
        paramMap.put("access_token", accessToken);
        HttpResponse execute = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
            .form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .execute();
        String body = execute.body();
        JSONObject json = JSONObject.parseObject(body);
        Object errcode = json.get("errcode");
        if (!errcode.equals(0) ) {
            Object message = json.get("errmsg");
            System.out.println(errcode + "   " + message.toString());
        }

        HttpDep httpDep = JSON.toJavaObject(json,HttpDep.class);
        List<Department> department = httpDep.getDepartment();
        int departmentId = 0;
        for (Department d : department) {
            if (d.getParentid()==0) {
                departmentId = d.getId();
                System.out.println("aaabbb  "+ departmentId);
            }
        }
        return departmentId;
    }


    private static String getAccessToken() {
        HashMap<String, Object> paramMap = new HashMap<>();
        //名雕企业id
        paramMap.put("corpid", "wx48d2c9de5e80017e");
        //易装宝应用id
        paramMap.put("corpsecret", "W1jY3b5Yp2UmqV1r0itKG7wImszUws4Sg3bPOUr8QXw");
        String body = HttpRequest.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
            .form(paramMap)//表单内容
            .timeout(20000)//超时，毫秒
            .execute().body();
        JSONObject json = JSONObject.parseObject(body);
        Object errcode = json.get("errcode");
        if (!errcode.equals(0) ) {
            Object message = json.get("errmsg");
            System.out.println(errcode + "   " + message.toString());
        }
        String accessToken = json.get("access_token").toString();
        System.out.println(accessToken);
        return accessToken;
    }

}
