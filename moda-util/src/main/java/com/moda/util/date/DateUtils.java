package com.moda.util.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 *
 * @author lyh
 * @version 2014-4-15
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
            "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getNowDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getNowDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        if (date == null) {
            return null;
        }
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
     * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 获取过去的天数
     *
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时
     *
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟
     *
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     *
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 获取两个日期之间相隔的天数，精确到：时、分、秒、毫秒
     *
     * @param before
     * @param after
     * @return
     */
    public static double diffDay1(Date before, Date after) {
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60 * 60 * 24f);
    }

    /**
     * 获取两个日期之间相隔的天数，忽略：时、分、秒、毫秒
     *
     * @param before
     * @param after
     * @return
     */
    public static double diffDay2(Date before, Date after) {
        before = parseDate(formatDate(before, "yyyy-MM-dd"));
        after = parseDate(formatDate(after, "yyyy-MM-dd"));
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60 * 60 * 24f);
    }

    /**
     * 获取两个日期之间的小时数，精确到：分、秒、毫秒
     *
     * @param before
     * @param after
     * @return
     */
    public static double diffHour1(Date before, Date after) {
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60 * 60f);
    }

    /**
     * 获取两个日期之间的小时数，忽略：分、秒、毫秒
     *
     * @param before
     * @param after
     * @return
     */
    public static double diffHour2(Date before, Date after) {
        before = parseDate(formatDate(before, "yyyy-MM-dd HH:00:00"));
        after = parseDate(formatDate(after, "yyyy-MM-dd HH:00:00"));
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60 * 60f);
    }

    /**
     * 获取两个日期之间的分钟数，精确到：秒、毫秒
     *
     * @return
     */
    public static double diffMinutes1(Date before, Date after) {
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60f);
    }

    /**
     * 获取两个日期之间的分钟数，忽略：秒、毫秒
     *
     * @return
     */
    public static double diffMinutes2(Date before, Date after) {
        before = parseDate(formatDate(before, "yyyy-MM-dd HH:mm:00"));
        after = parseDate(formatDate(after, "yyyy-MM-dd HH:mm:00"));
        long t = after.getTime() - before.getTime();
        return t / (1000 * 60f);
    }

    /**
     * 获取两个日期之间的秒数，精确到：秒、毫秒
     *
     * @return
     */
    public static double diffSecond1(Date before, Date after) {
        long t = after.getTime() - before.getTime();
        return t / 1000f;
    }

    /**
     * 获取两个日期之间相隔的月数，忽略：天、时、分、秒、毫秒
     *
     * @param before
     * @param after
     * @return
     */
    public static int diffMonth1(Date before, Date after) {
        Calendar beforeCalendar = Calendar.getInstance();
        beforeCalendar.setTime(before);
        Calendar afterCalendar = Calendar.getInstance();
        afterCalendar.setTime(after);
        int diff = (afterCalendar.get(Calendar.YEAR) - beforeCalendar.get(Calendar.YEAR)) * 12 + (afterCalendar.get(Calendar.MONTH) - beforeCalendar.get(Calendar.MONTH));
        return diff;
    }

    /**
     * 判断两个日期是否在同一天
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDay(Date d1, Date d2) {
        return formatDate(d1, "yyyy-MM-dd").equals(formatDate(d2, "yyyy-MM-dd"));
    }

    /**
     * 获取某年的第一天
     *
     * @param year
     * @return
     */
    public static Date getFirstDayOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, 0, 1);
        return c.getTime();
    }

    /**
     * 获取某年的最后一天
     *
     * @param year
     * @return
     */
    public static Date getLastDayOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, 11, 31);
        return c.getTime();
    }

    /**
     * 获取某月的第一天
     *
     * @param year
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(year, month - 1, 1);
        return c.getTime();
    }

    /**
     * 获取某月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar temp = Calendar.getInstance();
        temp.setTime(date);

        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(temp.get(Calendar.YEAR), temp.get(Calendar.MONTH), 1);
        return c.getTime();
    }

    /**
     * 获取某月的最后一天
     *
     * @param year
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return c.getTime();
    }

    /**
     * 获取某月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar temp = Calendar.getInstance();
        temp.setTime(date);

        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, temp.get(Calendar.YEAR));
        c.set(Calendar.MONTH, temp.get(Calendar.MONTH));
        c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
        return c.getTime();
    }

    /**
     * 获取当前日期 毫秒
     *
     * @return
     */
    public static long getTimeInMillis() {
        Calendar now = Calendar.getInstance();
        return now.getTimeInMillis();
    }

    /**
     * 获取当前日期 秒
     *
     * @return
     */
    public static long getTimeInSeconds() {
        return getTimeInMillis() / 1000L;
    }

    /**
     * 获取某月最大天数
     *
     * @param year
     * @param month
     * @return
     */
    public static int getMaxDay(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        return c.getActualMaximum(Calendar.DATE);
    }

    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        System.out.println(formatDateTime(parseDate("2015-09")));
        System.out.println(formatDateTime(parseDate("2016-11")));
        System.out.println(diffMonth1(parseDate("2015-09"), parseDate("2016-11")));
    }

    /**
     * 返回星期几，1-7，如：1-星期一、2-星期二...7-星期日
     *
     * @param date 日期
     * @return
     */
    public static int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int wk = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return wk == 0 ? 7 : wk;
    }
}
