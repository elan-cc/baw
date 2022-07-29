package com.ruoyi.web.controller.wx.utils;

import com.ruoyi.common.utils.DateUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ruoyi
 * @date 2022年03月16日9:19
 */
public class Utils {

    /**
     * 纬度正则
     * @param bot
     * @return
     */
    public static boolean positiveInteger(String bot) {
        boolean flag = false;
        try {
            String regex = "^([0-8]?\\d{1}\\.\\d{0,6}|90\\.0{0,6}|[0-8]?\\d{1}|90)$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bot);
            if (m.find()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 经度正则
     * @param bot
     * @return
     */
    public static boolean positives(String bot) {
        boolean flag = false;
        try {
            String regex = "^(((\\d|[1-9]\\d|1[1-7]\\d|0)\\.\\d{0,6})|(\\d|[1-9]\\d|1[1-7]\\d|0{1,3})|180\\.0{0,4}|180)$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(bot);
            if (m.find()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 车厢型号config_code的正则
     * @param code
     * @return
     */
    public static boolean configCode(String code) {
        boolean flag = false;
        try {
            String regex = "^[\\u4e00-\\u9fa5]{0,}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(code);
            if (m.find()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * 手机号码：正则
     * @param telephone
     * @return
     */
    public static boolean telephone(String telephone) {
        boolean flag = false;
        try {
            String regex = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(telephone);
            if (m.find()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static String getMD5(String md5) {
        String strInfoDigest = "";
        MessageDigest ms;
        try {
            ms = MessageDigest.getInstance("MD5");
            ms.update(md5.getBytes());
            byte[] bs = ms.digest();
            strInfoDigest = byteToHex(bs);
        } catch (NoSuchAlgorithmException e) {

            System.out.println("\u975E\u6CD5\u6458\u8981\u7b97\u6CD5");
        }

        return strInfoDigest.toUpperCase();
    }

    public static String byteToHex(byte[] bs) {
        String s = "";
        String strTemp = "";
        for (int i = 0; i < bs.length; i++) {
            strTemp = Integer.toHexString(bs[i] & 255);
            if (strTemp.length() == 1) {
                s = (new StringBuilder(String.valueOf(s))).append("0").append(strTemp).toString();
            }
            else {
                s = (new StringBuilder(String.valueOf(s))).append(strTemp).toString();
            }
        }
        return s.toUpperCase();
    }
    
    /**
     * 计算订单剩余支付时间，过期时间为 2小时
     * @param date 订单创建时间
     * @return
     */
    public static String calculatingTime(Date date){
        // 订单过期时间
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.HOUR, +2);
        // 过期时间与当前时间相差时间
        long l = instance.getTime().getTime() - new Date().getTime();
        // System.out.println(l);
        if (l > 0 ){
            long diffHours = l / (60 * 60 * 1000) % 24;
            long diffMinutes = l / (60 * 1000) % 60;
            long diffSeconds = l / 1000 % 60;
            /*String hours = "0" + diffHours;
            String minutes = String.valueOf(diffMinutes);
            String seconds = String.valueOf(diffSeconds);;
            if (diffMinutes < 10){
                minutes = "0" + diffMinutes;
            }
            if (diffSeconds < 10){
                seconds = "0" + diffSeconds;
            }
            String time = hours + ":" +  minutes + ":" + seconds;*/
            String result = String.format("%s小时%s分钟", diffHours,diffMinutes);
            return result;
        }
        return null;
    }
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2022-06-01 13:02:00";
        Date date = sdf.parse(time);
        calculatingTime(date);
    }
}
