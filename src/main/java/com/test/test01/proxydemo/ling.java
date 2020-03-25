package com.test.test01.proxydemo;

/**
 * @ClassName: com.test.test01.proxydemo.ling
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/8/30 15:20
 * @Version: 1.0
 */
//代理对象,包含真实的对象,为真实的对象的服务进行增强,和真实的对象实现同一个接口
public class ling implements ManToolsFactory {

    //被包含的真实对象
    public ManToolsFactory factory;

    public ling(ManToolsFactory factory){
        super();
        this.factory = factory;
    }

    @Override
    public void saleManTools(String size) {
        dosomeThingEnd();
        factory.saleManTools(size);
        dosomeThingBefore();

    }


    //增强的方法
    //售前服务
    private void dosomeThingEnd(){
        System.out.println("增强的方法:售前服务");
    }


    //售前服务
    private void dosomeThingBefore(){
        System.out.println("增强的方法:售后服务");
    }
}
