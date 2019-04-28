/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.util.math;

import java.math.BigDecimal;

/**
 * 计算函数                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年5月20日</li>
 *
 */
public class MathUtils {

    /**
     * 数值 val1 与 val2 比较: 相等为0, 大于为1 ，小于为-1
     * @param val1
     * @param val2
     * @return
     */
    public static int compare(double val1, double val2) {
        return compare(new BigDecimal(val1), new BigDecimal(val2));
    }

    /**
     * 数值 val1 与 val2 比较: 相等为0, 大于为1 ，小于为-1
     * @param val1
     * @param val2
     * @return
     */
    public static int compare(BigDecimal val1, BigDecimal val2) {
        if (null == val1) {
            if (null == val2) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (null == val2) {
                return 1;
            } else {
                return val1.compareTo(val2);
            }
        }
    }

    /**
     * val 与 0 比较: 相等为0, 大于为1 ，小于为-1
     * @param val
     * @return
     */
    public static int compareZero(BigDecimal val) {
        return compare(val, new BigDecimal(0));
    }

    /**
     * 相加
     * @param val1
     * @param val2
     * @return
     */
    public static BigDecimal add(BigDecimal val1, BigDecimal val2) {
        if (null == val1) {
            if (null == val2) {
                return null;
            } else {
                return val2;
            }
        } else {
            if (null == val2) {
                return val1;
            } else {
                return val1.add(val2);
            }
        }
    }

    /**
     * 相减 val1 - val2
     * @param val1
     * @param val2
     */
    public static BigDecimal subtract(BigDecimal val1, BigDecimal val2) {
        if (null == val1) {
            return null;
        } else {
            if (null == val2) {
                return val1;
            } else {
                return val1.subtract(val2);
            }
        }
    }

    /**
     * 相乘 val1 * val2
     * @param val1
     * @param val2
     * @return
     */
    public static BigDecimal multiply(BigDecimal val1, BigDecimal val2) {
        if (null == val1) {
            return null;
        } else {
            if (null == val2) {
                return null;
            } else {
                return val1.multiply(val2);
            }
        }
    }

    /**
     * 相除 val1 / val2
     * @param val1
     * @param val2
     * @return
     */
    public static BigDecimal divide(BigDecimal val1, BigDecimal val2) {
        if (null == val1) {
            return null;
        } else {
            if (null == val2 || compareZero(val2) == 0) {
                return null;
            } else {
                return val1.divide(val2);
            }
        }
    }

}
