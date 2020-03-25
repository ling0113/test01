package com.test.test01.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
        // (1)顺序排列
        list.sort(Comparator.comparing(Users::getBirthday));
        // (2)倒序排列
        //Collections.reverse(list);
        // (3)输出list
        log.info("排序后：" + list);

    }
}