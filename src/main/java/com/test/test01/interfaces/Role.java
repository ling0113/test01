package com.test.test01.interfaces;


import lombok.Data;

@Data
public class Role implements a {
    private Integer id = 1;
    //角色标识
    private String name;
    //角色名称
    private String nameZh;

    @Override
    public String getA() {
        return "role";
    }
}