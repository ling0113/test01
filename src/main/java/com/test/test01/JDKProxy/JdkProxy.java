package com.test.test01.JDKProxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: com.test.test01.JDKProxy.JdkProxy
 * @Description: jdk动态代理
 * @Author: lgrong
 * @CreateDate: 2019/8/29 13:49
 * @Version: 1.0
 */
public class JdkProxy implements InvocationHandler {
    private Object tarjet;
    public JdkProxy(Object tarjet){
        this.tarjet=tarjet;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始动态代理");
        Object invoke = method.invoke(tarjet, args);
        System.out.println("结束动态代理");
        return invoke;
    }


}
