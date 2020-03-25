package com.test.test01.proxydemo;

/**
 * @ClassName: com.test.test01.proxydemo.master
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/8/30 19:25
 * @Version: 1.0
 */
public class master {

    public static void main(String[] args) {
        ManToolsFactory factory = new AaFactory();
        ling ling = new ling(factory);
        ling.saleManTools("10");

    }

}
