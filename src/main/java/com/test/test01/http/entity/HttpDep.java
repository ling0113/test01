package com.test.test01.http.entity;

import java.util.List;
import lombok.Data;

@Data
public class HttpDep {

    private int errcode;

    private String errmsg;

    private List<Department> department;
}