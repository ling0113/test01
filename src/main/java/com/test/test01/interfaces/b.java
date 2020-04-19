package com.test.test01.interfaces;

import java.util.List;

/**
 * @ClassName: com.test.test01.interfaces.b
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2020/4/11 17:34
 * @Version: 1.0
 */
public class b {
    public a selAll() {
        Role role = new Role();
        return role;
    }

    public static void main(String[] args) {
        b b = new b();
        a a = b.selAll();
        System.out.println(a);

    }

}
