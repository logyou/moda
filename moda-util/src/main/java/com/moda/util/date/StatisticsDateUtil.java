/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.util.date;

import java.util.Date;

import com.moda.util.lang.StringUtils;

/**
 * 计算统计日期                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年10月19日</li>
 *
 */
public class StatisticsDateUtil {

    /**
     * 取默认时间，即为空时，统计昨天的数据，即昨天14点到今天14点的数据
     * @param dt
     * @return
     */
    public static Date getDefaultDate(Date dt) {
        if (null == dt) {
            dt = new Date();
            dt = DateUtils.addDays(dt, -1);
        }
        return dt;
    }

    /**
     * 格式日期为"yyyy-MM-dd"的字符串
     * @param dt
     * @return
     */
    public static String getFormatDate(Date dt) {
        return DateUtils.formatDate(dt, "yyyy-MM-dd");
    }

    /**
     * 取开始日期： 开始时间为当天的14点开始算
     * @param dt
     * @return
     */
    public static Date getStartDt(Date dt) {
        String sdt = getFormatDate(dt);
        Date startDt = DateUtils.parseDate(sdt + " 14:00:00");
        return startDt;
    }

    /**
     * 取开始日期： 开始时间为当天的0点开始算
     * @param dt
     * @return
     */
    public static Date getStartDt2(Date dt) {
        String sdt = getFormatDate(dt);
        Date startDt = DateUtils.parseDate(sdt + " 00:00:00");
        return startDt;
    }

    /**
     * 取结束日期：结束时间为次日的13:59:59
     * @param dt
     * @return
     */
    public static Date getEndDt(Date dt) {
        Date endDt = DateUtils.addDays(dt, 1);
        String sdt = getFormatDate(endDt);
        endDt = DateUtils.parseDate(sdt + " 13:59:59");
        return endDt;
    }

    /**
     * 取结束日期：结束时间为当天的23:59:59
     * @param dt
     * @return
     */
    public static Date getEndDt2(Date dt) {
        String sdt = getFormatDate(dt);
        Date endDt = DateUtils.parseDate(sdt + " 23:59:59");
        return endDt;
    }

    /**
     * 取默认年月，即为空时，统计昨天所在月份的数据，即所在月份1号14点到今天14点的数据
     * @param ym 年月，格式yyyy-MM，如2018-10
     * @return
     */
    public static String getDefaultMonth(String ym) {
        if (StringUtils.isBlank(ym)) {
            Date dt = new Date();
            dt = DateUtils.addDays(dt, -1);
            ym = DateUtils.formatDate(dt, "yyyy-MM");
        }
        return ym;
    }

    /**
     * 取开始日期： 开始时间为当月1号的14点开始算
     * @param ym 年月，格式yyyy-MM，如2018-10
     * @return
     */
    public static Date getYMStartDt(String ym) {
        Date startDt = DateUtils.parseDate(ym + "-01 14:00:00");
        return startDt;
    }

    /**
     * 取结束日期：结束时间为次月1日的13:59:59
     * @param ym 年月，格式yyyy-MM，如2018-10
     * @return
     */
    public static Date getYMEndDt(String ym) {
        Date endDt = DateUtils.parseDate(ym + "-01 13:59:59");
        endDt = DateUtils.addMonths(endDt, 1);
        return endDt;
    }

    /**
     * 月结开始日期： 开始时间为当月1号的0点开始算
     * @param ym 年月，格式yyyy-MM，如2018-10
     * @return
     */
    public static Date getYMStartDt2(String ym) {
        Date startDt = DateUtils.parseDate(ym + "-01 00:00:00");
        return startDt;
    }

    /**
     * 月结结束日期：结束时间为月底最后一天的23:59:59
     * @param ym 年月，格式yyyy-MM，如2018-10
     * @return
     */
    public static Date getYMEndDt2(String ym) {
        Date endDt = DateUtils.parseDate(ym + "-01 23:59:59");
        endDt = DateUtils.getLastDayOfMonth(endDt);//当月的最后一天
        endDt = DateUtils.parseDate(DateUtils.formatDate(endDt, "yyyy-MM-dd") + " 23:59:59");
        return endDt;
    }
}
