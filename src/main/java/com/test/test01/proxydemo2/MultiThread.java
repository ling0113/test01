package com.test.test01.proxydemo2;

import com.test.test01.proxydemo.ManToolsFactory;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @ClassName: com.test.test01.proxydemo2.MultiThread
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/23 11:33
 * @Version: 1.0
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取Java线程管理Mxbean
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = bean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]:"+threadInfo.getThreadName());
        }
        //[6]:Monitor Ctrl-Break
        //[5]:Attach Listener
        //[4]:Signal Dispatcher  //分发处理发送给jvm信号的线程
        //[3]:Finalizer
        //[2]:Reference Handler
        //[1]:main
    }

}
