package com.test.test01.JDKProxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: com.test.test01.JDKProxy.test01
 * @Description: 动态代理
 * @Author: lgrong
 * @CreateDate: 2019/8/29 14:24
 * @Version: 1.0
 */
public class test01 {

    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();
        JdkProxy jdkProxy = new JdkProxy(xiaoMing);
        Hose hose= (Hose) Proxy.newProxyInstance(xiaoMing.getClass().getClassLoader(), xiaoMing.getClass().getInterfaces(), jdkProxy);
        hose.mai();
    }

}
