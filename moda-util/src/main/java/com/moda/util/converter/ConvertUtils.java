package com.moda.util.converter;

import com.moda.util.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 转换工具类
 *
 * @author lyh
 * @version 2018-08-31
 */
public class ConvertUtils {
    /**
     * 判断字符串是否为空
     */
    static Map<String, Object> map = new HashMap<>();

    public static Map<String, Object> getMap() {
        return map;
    }

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if (object.equals("")) {
            return (true);
        }
        if (object.equals("null")) {
            return (true);
        }
        return (false);
    }

    public static String decode(String strIn, String sourceCode, String targetCode) {
        String temp = code2code(strIn, sourceCode, targetCode);
        return temp;
    }

    public static String StrToUTF(String strIn) {
        strIn = "";
        try {
            strIn = new String(strIn.getBytes("ISO-8859-1"), "GBK");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return strIn;

    }

    private static String code2code(String strIn, String sourceCode, String targetCode) {
        String strOut = null;
        if (strIn == null || (strIn.trim()).equals(""))
            return strIn;
        try {
            byte[] b = strIn.getBytes(sourceCode);
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + "  ");
            }
            strOut = new String(b, targetCode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return strOut;
    }

    public static int getInt(String s, int defval) {
        if (s == null || s == "") {
            return (defval);
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static int getInt(String s) {
        if (s == null || s == "") {
            return 0;
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getInt(String s, Integer df) {
        if (s == null || s == "") {
            return df;
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static Integer getInteger(String s) {
        if (isEmpty(s)) {
            return 0;
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static Integer getInteger(Object s) {
        if (isEmpty(s)) {
            return 0;
        }
        return getInteger(s.toString());
    }

    public static Integer getInteger(Object s, Integer df) {
        if (isEmpty(s)) {
            return df;
        }
        return getInteger(s.toString(), df);
    }

    public static Integer getInteger(String s, Integer df) {
        if (isEmpty(s)) {
            return df;
        }
        try {
            return Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return df;
        }
    }

    public static Long getLong(String s) {
        if (isEmpty(s)) {
            return 0L;
        }
        try {
            return Long.valueOf(s);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    public static Long getLong(Object s) {
        if (isEmpty(s)) {
            return 0L;
        }
        return getLong(s.toString());
    }

    public static Long getLong(Object s, Long df) {
        if (isEmpty(s)) {
            return df;
        }
        return getLong(s.toString(), df);
    }

    public static Long getLong(String s, Long df) {
        if (isEmpty(s)) {
            return df;
        }
        try {
            return Long.valueOf(s);
        } catch (NumberFormatException e) {
            return df;
        }
    }

    public static Integer[] getInts(String[] s) {
        Integer[] integer = new Integer[s.length];

        for (int i = 0; i < s.length; i++) {
            integer[i] = Integer.parseInt(s[i]);
        }
        return integer;

    }

    public static Double getDouble(Object s) {
        if (isEmpty(s)) {
            return 0.0;
        }
        return getDouble(s.toString());
    }

    public static Double getDouble(String s) {
        if (isEmpty(s)) {
            return 0.0;
        }
        try {
            return (Double.parseDouble(s));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public static Double getDouble(Object s, Double defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return getDouble(s.toString(), defval);
    }

    public static Double getDouble(String s, Double defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        try {
            return (Double.parseDouble(s));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static Float getFloat(Object s) {
        if (isEmpty(s)) {
            return 0f;
        }
        return getFloat(s.toString());
    }

    public static Float getFloat(String s) {
        if (isEmpty(s)) {
            return 0f;
        }
        try {
            return (Float.parseFloat(s));
        } catch (NumberFormatException e) {
            return 0f;
        }
    }

    public static Float getFloat(Object s, Float defval) {
        if (isEmpty(s)) {
            return defval;
        }
        return getFloat(s.toString(), defval);
    }

    public static Float getFloat(String s, Float defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        try {
            return (Float.parseFloat(s));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static Short getShort(String s) {
        if (StringUtils.isNotEmpty(s)) {
            return (Short.parseShort(s));
        }
        return null;
    }

    public static int getInt(Object object, int defval) {
        if (isEmpty(object)) {
            return (defval);
        }
        try {
            return (Integer.parseInt(object.toString()));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static int getInt(BigDecimal s, int defval) {
        if (s == null) {
            return (defval);
        }
        return s.intValue();
    }

    public static Integer[] getIntegerArry(String[] object) {
        int len = object.length;
        Integer[] result = new Integer[len];
        try {
            for (int i = 0; i < len; i++) {
                result[i] = new Integer(object[i].trim());
            }
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getString(String s) {
        return (getString(s, ""));
    }

    public static String getString(Object object) {
        if (isEmpty(object)) {
            return "";
        }
        return (object.toString().trim());
    }

    public static String getString(int i) {
        return (String.valueOf(i));
    }

    public static String getString(float i) {
        return (String.valueOf(i));
    }

    public static String getString(String s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.trim());
    }

    public static String getString(Object s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.toString().trim());
    }

    public static long stringToLong(String str) {
        Long test = new Long(0);
        try {
            test = Long.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test.longValue();
    }

    /**
     * 获取本机IP
     */
    public static String getIp() {
        String ip = null;
        try {
            InetAddress address = InetAddress.getLocalHost();
            ip = address.getHostAddress();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 判断一个类是否为基本数据类型。
     *
     * @param clazz 要判断的类。
     * @return true 表示为基本数据类型。
     */
    @SuppressWarnings("rawtypes")
    public static boolean isBaseDataType(Class clazz) throws Exception {
        return (clazz.equals(String.class) || clazz.equals(Integer.class) || clazz.equals(Byte.class) || clazz.equals(Long.class) || clazz.equals(Double.class) || clazz.equals(Float.class) || clazz.equals(Character.class) || clazz.equals(Short.class) || clazz.equals(BigDecimal.class)
                || clazz.equals(BigInteger.class) || clazz.equals(Boolean.class) || clazz.equals(Date.class) || clazz.isPrimitive());
    }

    /**
     * @param request IP
     * @return IP Address
     */
    public static String getIpAddrByRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * @return 本机IP
     * @throws SocketException
     */
    public static String getRealIp() throws SocketException {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":")) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        }
        return localip;

    }

    /**
     * java去除字符串中的空格、回车、换行符、制表符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;

    }

    /**
     * 判断元素是否在数组内
     *
     * @param substring
     * @param source
     * @return
     */
    public static boolean isIn(String substring, String[] source) {
        if (source == null || source.length == 0) {
            return false;
        }
        for (int i = 0; i < source.length; i++) {
            String aSource = source[i];
            if (aSource.equals(substring)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取Map对象
     */
    public static Map<Object, Object> getHashMap() {
        return new HashMap<Object, Object>();
    }

    /**
     * SET转换MAP
     *
     * @param str
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<Object, Object> SetToMap(Set<Object> setobj) {
        Map<Object, Object> map = getHashMap();
        for (Iterator<Object> iterator = setobj.iterator(); iterator.hasNext(); ) {
            Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) iterator.next();
            map.put(entry.getKey().toString(), entry.getValue() == null ? "" : entry.getValue().toString().trim());
        }
        return map;

    }

    public static boolean isInnerIP(String ipAddress) {
        boolean isInnerIp = false;
        long ipNum = getIpNum(ipAddress);
        /**
         * 私有IP：A类 10.0.0.0-10.255.255.255 B类 172.16.0.0-172.31.255.255 C类
         * 192.168.0.0-192.168.255.255 当然，还有127这个网段是环回地址
         **/
        long aBegin = getIpNum("10.0.0.0");
        long aEnd = getIpNum("10.255.255.255");
        long bBegin = getIpNum("172.16.0.0");
        long bEnd = getIpNum("172.31.255.255");
        long cBegin = getIpNum("192.168.0.0");
        long cEnd = getIpNum("192.168.255.255");
        isInnerIp = isInner(ipNum, aBegin, aEnd) || isInner(ipNum, bBegin, bEnd) || isInner(ipNum, cBegin, cEnd) || ipAddress.equals("127.0.0.1");
        return isInnerIp;
    }

    private static long getIpNum(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        long a = Integer.parseInt(ip[0]);
        long b = Integer.parseInt(ip[1]);
        long c = Integer.parseInt(ip[2]);
        long d = Integer.parseInt(ip[3]);

        long ipNum = a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;
        return ipNum;
    }

    private static boolean isInner(long userIp, long begin, long end) {
        return (userIp >= begin) && (userIp <= end);
    }

    public static BigDecimal getBigDecimal(Object s) {
        if (isEmpty(s)) {
            return BigDecimal.ZERO;
        }
        return getBigDecimal(s.toString());
    }

    public static BigDecimal getBigDecimal(String s) {
        if (isEmpty(s)) {
            return BigDecimal.ZERO;
        }
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal getBigDecimal(Object s, BigDecimal df) {
        if (isEmpty(s)) {
            return df;
        }
        return getBigDecimal(s.toString(), df);
    }

    public static BigDecimal getBigDecimal(String s, BigDecimal df) {
        if (isEmpty(s)) {
            return df;
        }
        try {
            return new BigDecimal(s);
        } catch (NumberFormatException e) {
            return df;
        }
    }

}
