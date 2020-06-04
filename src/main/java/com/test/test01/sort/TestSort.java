package com.test.test01.sort;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestSort {

    private List<Users> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list.add(new Users("张三", "1987-05-23 12:34:07"));
        list.add(new Users("李四", "1977-05-23 05:04:07"));
        list.add(new Users("王五", "1987-05-23 09:34:07"));
    }

    @Test
    @DisplayName("测试排序")
    void test() {
        // (1)顺序排列
        list.sort(Comparator.comparing(Users::getBirthday));
        // (2)倒序排列
        Collections.reverse(list);
        // (3)输出list
        log.info("排序后：" + list);
    }

    public static void main(String[] args) {
        List<Users> list = new ArrayList<>();

        list.add(new Users("张三", "1987-05-23 12:34:07"));
        list.add(new Users("李四", "1977-05-23 05:04:07"));
        list.add(new Users("王五", "1987-05-23 09:34:07"));
        long startTime = System.currentTimeMillis(); //获取开始时间
        // (1)顺序排列 43
        list.sort(Comparator.comparing(Users::getBirthday));
        // (2)倒序排列 67
        //Collections.reverse(list);
        //stearm 倒序  84
       //List<Users> collect = list.stream().sorted(comparing(Users::getBirthday).reversed()).collect(Collectors.toList());
       //52
        //List<Users> collect2 = list.stream().sorted(comparing(Users::getBirthday)).collect(Collectors.toList());

        // (3)输出list
        //log.info("排序后：" + list);
        //删除元素
        //list.removeIf(s->"张三".equals(s.getName()));

        //System.out.println(list);
        //System.out.println(collect);
        //System.out.println(collect2);



        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");


    }
}