package com.test.test01.init;

/**
 * @ClassName: com.test.test01.init.Son
 * @Description:  类的实例化 实例初始化
 * @Author: lgrong
 * @CreateDate: 2019/9/2 16:47
 * @Version: 1.0
 */
public class Son2 {
    private int i = test();
    private static  int j = methed();

    //静态代码块
    static {
        System.out.println("(6)");
    }
    //构造器
    Son2(){
        System.out.println("(7)");
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
        System.out.println("----------------");
        Son2 son2 = new Son2();
        System.out.println("----------------");
        Father father = new Father();
    }






}
