package com.test.test01.init;

/**
 * @ClassName: com.test.test01.init.Father
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/9/2 16:54
 * @Version: 1.0
 */
public class Father {

    private int i = test();
    private static  int j = methed();
    static {
        System.out.println("(1)");
    }
    Father(){
        System.out.println("(2)");
    }
    {
        System.out.println("(3)");
    }
    public int test(){
        System.out.println("(4)");
        return 1;
    }
    public static int methed(){
        System.out.println("(5)");
        return 2;
    }



    //静态方法代码块  静态代码块

}
