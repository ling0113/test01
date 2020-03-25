package com.test.test01.init;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @ClassName: com.test.test01.init.Son
 * @Description:  类的实例化 实例初始化
 * @Author: lgrong
 * @CreateDate: 2019/9/2 16:47
 * @Version: 1.0
 */
public class Son {



    private int i = test();
    private static  int j = methed();

    //静态代码块
    static {
        System.out.println("(6)");
    }
    //无参 构造器
    Son(){
        System.out.println("(7)");
    }
    //有参构造器
    public Son(int i) {
        this.i = i;
        System.out.println(i);
    }
    //非静态代码块
    {
        System.out.println("(8)");
    }
    public int test(){
        System.out.println("(9)");
        return 1;
    }

    //静态方法
    public static int methed(){
        System.out.println("(10)");
        return 2;
    }

    public static void main(String[] args) {
        Son son = new Son(1);
    }

    //静态方法  静态代码块  类普通方法  非静态代码块  构造器





}
