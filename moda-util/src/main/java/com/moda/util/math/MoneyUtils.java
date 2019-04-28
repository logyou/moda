package com.moda.util.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import com.moda.util.converter.ConvertUtils;

/**
 * 货币处理
 *
 * @author lyh
 * @version 1.2 2016-06-16
 */
public class MoneyUtils {

    /**
     * 转换为【￥0.00】格式
     *
     * @param money
     * @return
     */
    public static String toCnMoney(Object money) {
        money = ConvertUtils.getBigDecimal(String.valueOf(money));
        DecimalFormat df = new DecimalFormat("￥0.00");
        return df.format(money);
    }

    /**
     * 保留2位小数
     *
     * @param money
     * @return Decimal
     */
    public static BigDecimal roundMoney(Object money) {
        BigDecimal old = ConvertUtils.getBigDecimal(String.valueOf(money));
        return old.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 保留scale位小数
     *
     * @param money
     * @param scale 小数位数
     * @return
     */
    public static BigDecimal roundMoney(Object money, int scale) {
        BigDecimal old = ConvertUtils.getBigDecimal(String.valueOf(money));
        return old.setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 保留scale为小数
     *
     * @param money        金额
     * @param scale        小数位数
     * @param roundingMode 模式
     * @return BigDecimal
     */
    public static BigDecimal roundMoney(Object money, int scale, RoundingMode roundingMode) {
        BigDecimal old = ConvertUtils.getBigDecimal(String.valueOf(money));
        return old.setScale(scale, roundingMode);
    }

    /**
     * 元->分 ，1元->100分
     *
     * @param amt 以元为单位的金额
     * @return
     */
    public static int yuanToFen(BigDecimal amt) {
        return amt.multiply(BigDecimal.valueOf(100)).intValue();
    }

    /**
     * 分->元 ，100分->1元
     *
     * @param fen 以分为单位的金额
     * @return
     */
    public static BigDecimal fenToYuan(int fen) {
        return new BigDecimal(fen).divide(new BigDecimal(100));
    }

    /**
     * 四舍五入处理金额，当金额小于1时，保留2位小数；当金额大于1时，直接取整，不保留小数
     *
     * @param money 金额
     * @return
     */
    public static BigDecimal roundHumanMoney(Object money) {
        BigDecimal old = ConvertUtils.getBigDecimal(String.valueOf(money));
        return old.compareTo(BigDecimal.ONE) < 0 ? roundMoney(old, 2) : roundMoney(old, 0);
    }

    /**
     * 格式化实数，实现3位一瞥,保留scale位小数,如果位数不够，则添0站位
     * @param oldvalue
     * @param scale
     * @return
     */
    public static String getFormat(Object oldvalue, int scale) {
        if (oldvalue == null) {
            return "";
        }
        String newStr = "";
        String formatStr = ",##0";
        if (scale > 0) {
            formatStr += ".";
            for (int i = 0; i < scale; i++) {
                formatStr += "0";
            }
        }
        try {
            NumberFormat nf = new DecimalFormat(formatStr);
            newStr = nf.format(oldvalue);
        } catch (Exception e) {
            newStr = String.valueOf(oldvalue);
        }
        return newStr;
    }

}
