/**
  * Copyright 2020 bejson.com 
  */
package com.test.test01.http.entity;
import java.util.List;
import lombok.Data;

@Data
public class HttpUser {

    private int errcode;
    private String errmsg;
    private List<UserList> userlist;


}