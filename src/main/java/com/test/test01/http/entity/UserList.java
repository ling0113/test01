/**
  * Copyright 2020 bejson.com 
  */
package com.test.test01.http.entity;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * Auto-generated: 2020-04-17 16:9:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class UserList {

    private String userid;
    private String name;
    private List<String> department;
    private List<String> order;
    private String position;
    private String mobile;
    private String gender;
    private String email;
    private List<Integer> is_leader_in_dept;
    private String avatar;
    private String thumb_avatar;
    private String telephone;
    private String alias;
    private int status;
    private String address;
    private int hide_mobile;
    private String english_name;
    private String open_userid;
    private int main_department;
    private String qr_code;
    private String external_position;

}