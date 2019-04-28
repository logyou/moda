package com.moda.util.rand;

import java.util.Random;

/**
 * @author lyh
 * @description 随机字符串
 * @date 2015-10-28
 */
public class RandomUtils {

    /**
     * 获取{length}位随机数字（0-9）
     *
     * @return
     */
    public static String getRandom(int length) {
        String chars = "0123456789";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 获取{length}位随机数字和字母（0-9、a-z）
     *
     * @return
     */
    public static String getRandom2(int length) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 获取{length}位随机数，由数字、大写字母、小写字母组成（0-9、a-z、A-Z）
     *
     * @return
     */
    public static String getRandom3(int length) {
        String chars = "01234567890123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        for (int i = 0; i < length; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    /**
     * 生成指定范围内的数字
     *
     * @param min 最小值（包含）
     * @param max 最大值（包含）
     * @return
     */
    public static int nextInt(int min, int max) {
        Random rd = new Random();
        return rd.nextInt(max - min + 1) + min;
    }

    /**
     * 生成指定范围内的浮点数
     *
     * @param min 最小值（包含）
     * @param max 最大值（不包含）
     * @return
     */
    public static double nextDouble(double min, double max) {
        return Math.random() * (max - min) + min;
    }
}
