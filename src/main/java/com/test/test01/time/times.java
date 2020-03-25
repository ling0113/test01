package com.test.test01.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName: com.test.test01.time.times
 * @Description:
 * @Author: lgrong
 * @CreateDate: 2019/12/24 15:33
 * @Version: 1.0
 */
public class times {

    public static void main(String[] args) {
        //某月第一天
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        //设置年份
        //cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH,-1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,00);
        cal.set(Calendar.SECOND,00);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        Date startTime = cal.getTime();

        //某月最后一天
        Calendar cal2 = Calendar.getInstance();
        //设置年份
        //cal2.set(Calendar.YEAR,year);
        //设置月份
        cal2.set(Calendar.MONTH,-1);
        cal2.set(Calendar.HOUR_OF_DAY,23);
        cal2.set(Calendar.MINUTE,59);
        cal2.set(Calendar.SECOND,59);
        //获取某月最大天数
        int lastDay = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal2.set(Calendar.DAY_OF_MONTH, lastDay);
        Date endTime = cal2.getTime();



        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new Date());
        int month = cal3.get(Calendar.MONTH)+1;
        for (int i = 0; i < month; i++) {
            cal3.set(Calendar.MONTH,i);
            Date time = cal3.getTime();
            System.out.println(time);
        }
        System.out.println(month);
    }

}
