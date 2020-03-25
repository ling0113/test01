package com.test.test01.time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: com.test.test01.time.a
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/12/25 16:52
 * @Version: 1.0
 */
public class a {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int month = cal.get(Calendar.MONTH)+1;
        for (int i = 0; i < month; i++) {
            cal.set(Calendar.MONTH,i);
            Date time = cal.getTime();
            TimeVo firstLastTime = getFirstLastTime(time);
            System.out.println(firstLastTime.getFirstTime()+","+firstLastTime.getLastTime());


        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.set(Calendar.MONTH,0);
        Date time2 = cal2.getTime();
        TimeVo firstLastTime = getFirstLastTime(time2);
        //System.out.println(firstLastTime);
        String reStr = sdf.format(time2);

        //System.out.println(reStr);



        //TimeVo firstLastTime = getFirstLastTime(time2);
        //System.out.println(firstLastTime);

    }


    private static TimeVo getFirstLastTime(Date date) {
        //System.out.println(date);

        //某月第一天
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //System.out.println(cal.getTime());
        //设置月份
        //cal.set(Calendar.MONTH,0);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,00);
        cal.set(Calendar.SECOND,00);
        //System.out.println(cal.getTime());
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        Date firstTime = cal.getTime();

        //某月最后一天
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);

        //设置月份
        //cal2.set(Calendar.MONTH,-1);
        cal2.set(Calendar.HOUR_OF_DAY,23);
        cal2.set(Calendar.MINUTE,59);
        cal2.set(Calendar.SECOND,59);
        //获取某月最大天数
        int lastDay = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal2.set(Calendar.DAY_OF_MONTH, lastDay);
        Date lastTime = cal2.getTime();
        TimeVo timeVo = new TimeVo();
        timeVo.setFirstTime(firstTime);
        timeVo.setLastTime(lastTime);


        return timeVo;
    }

}
