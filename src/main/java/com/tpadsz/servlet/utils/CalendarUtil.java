package com.tpadsz.servlet.utils;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hongjian.chen on 2017/9/29.
 */
public class CalendarUtil {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Calendar c = Calendar.getInstance();

    @Test
    public void showTime() throws ParseException {
//        addDay(1);
        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
        System.out.println(str);
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-M-d H:m:s");
            Date date = dateFormat.parse("2013-6-1 13:24:16");
            System.out.println("dateFormat=" + dateFormat.format(new Date()));
            calendar.setTime(date);
            str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
            System.out.println("calendar.get()=" + str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar = Calendar.getInstance();
        calendar.set(2013, 1, 2, 17, 35, 44);
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println("calendar.set()=" + str);
        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")).format(calendar.getTime());
        System.out.println("currentDate=" + str);
        int year = calendar.get(Calendar.YEAR);
        System.out.println("year is = " + String.valueOf(year));

        // 显示月份 (从0开始, 实际显示要加一)
        int month = calendar.get(Calendar.MONTH);
        System.out.println("month is = " + (month + 1));

        // 本周几
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("week is = " + week);

        // 今年的第 N 天
        int DAY_OF_YEAR = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("DAY_OF_YEAR is = " + DAY_OF_YEAR);

        // 本月第 N 天
        int DAY_OF_MONTH = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("DAY_OF_MONTH = " + String.valueOf(DAY_OF_MONTH));

        // 3小时以后
        calendar.add(Calendar.HOUR_OF_DAY, 3);
        int HOUR_OF_DAY = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println("HOUR_OF_DAY + 3 = " + HOUR_OF_DAY + ",modifyDate = " + calendar.getTime());
        // 1天以前
        calendar.add(Calendar.DATE, 1);
        int temp = calendar.get(Calendar.DATE);
        System.out.println("DAY + 1 = " + temp + ",modifyDate = " + calendar.getTime());
        // 当前分钟数
        int MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE = " + MINUTE);

        // 15 分钟以后
        calendar.add(Calendar.MINUTE, 15);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE + 15 = " + MINUTE + ",modifyDate = " + calendar.getTime());

        // 30分钟前
        calendar.add(Calendar.MINUTE, -30);
        MINUTE = calendar.get(Calendar.MINUTE);
        System.out.println("MINUTE - 30 = " + MINUTE + ",modifyDate = " + calendar.getTime());

        // 格式化显示
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 重置 Calendar 显示当前时间
        calendar.setTime(new Date());
        str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS")).format(calendar.getTime());
        System.out.println(str);

        // 创建一个 Calendar 用于比较时间
        Calendar calendarNew = Calendar.getInstance();

        // 设定为 5 小时以前，后者大，显示 -1
        calendarNew.add(Calendar.HOUR, -5);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 设定7小时以后，前者大，显示 1
        calendarNew.add(Calendar.HOUR, +7);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));

        // 退回 2 小时，时间相同，显示 0
        calendarNew.add(Calendar.HOUR, -2);
        System.out.println("时间比较：" + calendarNew.compareTo(calendar));
    }

    @Test
    public void addDay() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Calendar calendar = Calendar.getInstance();
//        System.out.println("currentTime=" + format.format(new Date()));
//        calendar.add(Calendar.DATE, -1);
//        System.out.println("day -1 =" + format.format(calendar.getTime()));
        System.out.println(pastMinute());
    }

    public static String pastMinute() {
        c.add(Calendar.MINUTE, 30);//30分钟后的时间
        System.out.println("30分钟后的时间:" + format.format(c.getTime()));
        Calendar nowTime2 = Calendar.getInstance();
        nowTime2.add(Calendar.MINUTE, -30);//30分钟前的时间
        System.out.println("30分钟前的时间:" + format.format(nowTime2.getTime()));
        return format.format(nowTime2.getTime());
    }

    public static String pastWeek() {
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        System.out.println("过去一周：" + day);
        return day;
    }

    public static String pastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月：" + mon);
        return mon;
    }

    public static String pastYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();

        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        System.out.println("过去一年：" + year);
        return year;
    }
}
