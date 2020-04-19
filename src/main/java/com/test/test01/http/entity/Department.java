package com.test.test01.http.entity;

import lombok.Data;
import org.apiguardian.api.API;

@Data
public class Department {

    //部门id
    private int id;
    //部门名称
    private String name;
    //英文名称
    private String name_en;
    //父部门id。根部门为1
    private int parentid;
    //在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
    private int order;
}