package com.chenyacheng.commonuilib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 *
 * @author chenyacheng
 * @date 2019/03/04
 */
public class DateUtils {

    /**
     * 传入字符串，以形式yyyy-MM-dd返回日期格式
     *
     * @param string 字符串日期
     * @return 日期格式
     */
    public static Date stringToDateYyyyMmDd(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 将时间戳转换为时间字符串
     *
     * @param timeStamp 时间戳
     * @return 时间字符串
     */
    public static String timeStampToString(Long timeStamp) {
        Date date = new Date(timeStamp);
        return dateToStringYyyyMmDd(date);
    }

    /**
     * 传入日期格式，以形式yyyy-MM-dd返回字符串
     *
     * @param date 日期
     * @return 日期的字符串
     */
    public static String dateToStringYyyyMmDd(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * 将时间戳转换为时间字符串
     *
     * @param timeStamp 时间戳
     * @return 时间字符串
     */
    public static String timeStampToStringHhMmSs(Long timeStamp) {
        Date date = new Date(timeStamp);
        return dateToStringYyyyMmDdHhMmSs(date);
    }

    /**
     * 传入日期格式，以形式yyyy-MM-dd HH:mm:ss返回字符串
     *
     * @param date 日期
     * @return 日期的字符串
     */
    private static String dateToStringYyyyMmDdHhMmSs(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sdf.format(date);
    }
}
