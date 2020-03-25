package com.test.test01.time;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
 
public class Test {
 
    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2012-05-02";
        Date date = df.parse(str);
        Map<String, String> map = getFirstday_Lastday_Month(date);
        System.out.println("当月第一天：" + getFirstDay());
        System.out.println("当月最后一天：" + getLastDay());
        
        System.out.println("一个月前第一天：" + map.get("first"));
        System.out.println("一个月前最后一天：" + map.get("last"));
    }


 
    /**
     * 某一个月第一天和最后一天
     * @param date
     * @return
     */
    private static Map<String, String> getFirstday_Lastday_Month(Date date) {
        System.out.println(date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        //上个月第一天
        Calendar instance = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) instance;
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        gcLast.set(Calendar.HOUR,00);
        gcLast.set(Calendar.MINUTE,00);
        gcLast.set(Calendar.SECOND,00);
        Date time = gcLast.getTime();
        System.out.println(time);


        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        day_first = str.toString();
 
        //上个月最后一天
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);        //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        calendar.add(Calendar.HOUR,23);
        calendar.add(Calendar.MINUTE,59);
        calendar.add(Calendar.SECOND,59);
        Date time1 = calendar.getTime();
        System.out.println(time1);


        String day_last = df.format(time1);
        StringBuffer endStr = new StringBuffer().append(day_last).append(" 23:59:59");
        day_last = endStr.toString();
 
        Map<String, String> map = new HashMap<String, String>();
        map.put("first", day_first);
        map.put("last", day_last);
        return map;
    }
 
    /**
     * 当月第一天
     * @return
     */
    private static String getFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();
 
    }
    
    /**
     * 当月最后一天
     * @return
     */
    private static String getLastDay() {
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       Calendar calendar = Calendar.getInstance();
       Date theDate = calendar.getTime();
       String s = df.format(theDate);
       calendar.add(Calendar.MONTH, 1);//加一个月
       calendar.set(Calendar.DATE, 1); //设置为该月第一天
       calendar.add(Calendar.DATE, -1); //再减一天即为上个月最后一天
       String day_last = df.format(calendar.getTime());
       StringBuffer endStr = new StringBuffer().append(day_last);
       day_last = endStr.toString();
       StringBuffer str = new StringBuffer().append(day_last);
       return str.toString();
 
    }
 
}