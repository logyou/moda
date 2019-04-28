package com.moda.util.file;

import java.text.DecimalFormat;

/**
 * 文件大小处理工具
 *
 * @author lyh
 * @create 2019-01-02 18:21
 **/
public class FileSizeUtils {
    private final static long JZ = 1024;
    private final static long B = 1;
    private final static long KB = B * JZ;
    private final static long MB = KB * JZ;
    private final static long GB = MB * JZ;
    private final static long TB = GB * JZ;
    private final static long PB = TB * JZ;

    /**
     * 把文件大小格式化为易于阅读的字符串
     *
     * @param size 大小
     * @return 格式化后的字符串
     */
    public static String formatSize(long size) {
        if (size < 0) {
            return "";
        }

        String pattern;
        long type;

        if (size < KB) {
            type = B;
            pattern = "# B";
        } else if (size < MB) {
            type = KB;
            pattern = getPattern(size, type, "KB");
        } else if (size < GB) {
            type = MB;
            pattern = getPattern(size, type, "MB");
        } else if (size < TB) {
            type = GB;
            pattern = getPattern(size, type, "GB");
        } else if (size < PB) {
            type = TB;
            pattern = getPattern(size, type, "TB");
        } else {
            type = B;
            pattern = "# B";
        }

        return new DecimalFormat(pattern).format(size * 1D / type);
    }

    private static String getPattern(Long size, Long type, String unit) {
        if (size < 10 * type) {
            return "#.## " + unit;
        } else if (size < 100 * type) {
            return "#.# " + unit;
        } else {
            return "# " + unit;
        }
    }
}
