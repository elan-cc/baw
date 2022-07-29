package com.ruoyi.web.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by luguoli on 2015/12/21.
 */
public class MyDateUtils {

    /**
     * String(yyyy-MM-dd HH:mm:ss) 转 Date
     *
     * @param time
     * @return
     * @throws ParseException
     */
    // String date = "2010/05/04 12:34:23";
    public static Date StringToDate(String time) throws ParseException {

        Date date = new Date();
        // 注意format的格式要与日期String的格式相匹配
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = dateFormat.parse(time);
            System.out.println(date.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * Date转为String(yyyy-MM-dd HH:mm:ss)
     *
     * @param time
     * @return
     */
    public static String DateToString(Date time) {
        String dateStr = "";
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        try {
            dateStr = dateFormat.format(time);
            System.out.println(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }
    /**
     * String(yyyy-MM-dd HH:mm:ss)转10位时间戳
     * @param time
     * @return
     */
    public static Integer StringToTimestamp(String time){

        int times = 0;
        try {
            times = (int) ((Timestamp.valueOf(time).getTime())/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(times==0){
            System.out.println("String转10位时间戳失败");
        }
        return times;

    }
    /**
     * 10位int型的时间戳转换为String(yyyy-MM-dd HH:mm:ss)
     * @param time
     * @return
     */
    public static String timestampToString(Integer time, String format){
        //int转long时，先进行转型再进行计算，否则会是计算结束后在转型
        long temp = (long)time*1000;
        Timestamp ts = new Timestamp(temp);
        String tsStr = "";
        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            //方法一
            tsStr = dateFormat.format(ts);
            System.out.println(tsStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tsStr;
    }
    /**
     * 10位时间戳转Date
     * @param time
     * @return
     */
    public static Date TimestampToDate(Integer time){
        long temp = (long)time*1000;
        Timestamp ts = new Timestamp(temp);
        Date date = new Date();
        try {
            date = ts;
            //System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
    /**
     * Date类型转换为10位时间戳
     * @param time
     * @return
     */
    public static Integer DateToTimestamp(Date time){
        Timestamp ts = new Timestamp(time.getTime());

        return (int) ((ts.getTime())/1000);
    }

    //计算两个时间相隔天数
    public static long getDatePoor(long endDate, long nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate - nowDate;
        // 计算差多少天
        long day = diff / nd;
        return day;
    }

    //获取10位时间戳
    public static String getTimeStamp10()
    {
        return getTimeStamp10(0);
    }

    //获取10位时间戳
    public static String getTimeStamp10(long diff)
    {
        long timeStampSec = System.currentTimeMillis()/1000 + diff;
        return String.format(Locale.ENGLISH, "%010d", timeStampSec);
    }


}
