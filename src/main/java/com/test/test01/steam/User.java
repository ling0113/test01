package com.test.test01.steam;

import lombok.Data;

@Data
public class User {

    private Long id;       //主键id
    private String name;   //姓名
    private Integer age;   //年龄
    private String school; //学校
   public User(Long id, String name, Integer age, String school) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.school = school;
   }
}