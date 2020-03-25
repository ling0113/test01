package com.test.test01.proxydemo2;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * @ClassName: com.test.test01.proxydemo2.ThreadState
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/28 10:35
 * @Version: 1.0
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaiting").start();
        new Thread(new Waiting(),"Waiting").start();
        //使用两个bilocked线程,一个获取锁成功,另一个被阻塞
        new Thread(new Blocked(),"Blocked-11111").start();
        new Thread(new Blocked(),"Blocked-2222").start();
    }

    //该线程不断进行睡眠
    static class TimeWaiting implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(100);
            }
        }
    }

    //该线程在waiting.class实例上等待
    static class Waiting implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (Waiting.class){
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //该线程在blocked.class实例上加锁后,不会释放锁
    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }
}
