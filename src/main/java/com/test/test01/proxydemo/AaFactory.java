package com.test.test01.proxydemo;

/**
 * @ClassName: com.test.test01.proxydemo.AaFactory
 * @Description: 静态代理
 * @Author: lgrong
 * @CreateDate: 2019/8/30 17:38
 * @Version: 1.0
 */
//真正提供服务的类
public class AaFactory implements ManToolsFactory {

    @Override
    public void saleManTools(String size) {
        System.out.println("真正提供服务的类"+size);
    }
}
