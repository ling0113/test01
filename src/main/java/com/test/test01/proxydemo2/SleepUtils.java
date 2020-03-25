package com.test.test01.proxydemo2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: com.test.test01.proxydemo2.SleepUtils
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/10/28 10:45
 * @Version: 1.0
 */
public class SleepUtils {

    public static final void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
