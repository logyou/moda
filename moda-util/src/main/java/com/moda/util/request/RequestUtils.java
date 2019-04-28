package com.moda.util.request;

import com.moda.entity.consts.Global;
import com.moda.util.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.net.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公用工具类
 *
 * @author lyh
 * @version 2015-11-10
 */
public class RequestUtils {

    private static Logger log = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 内网IP
     */
    public static final String INTRANET_IP = getIntranetIp();
    /**
     * 外网IP
     */
    public static final String INTERNET_IP = getInternetIp();

    // \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),
    // 字符串在编译时会被转码一次,所以是 "\\b"
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)
    private static String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i" + "|windows (phone|ce)|blackberry" + "|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp" + "|laystation portable)|nokia|fennec|htc[-_]" + "|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    private static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser" + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";

    // 移动设备正则匹配：手机端、平板
    private static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    private static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    /**
     * 检测是否是移动设备访问
     *
     * @return true:移动设备接入，false:pc端接入
     */
    public static boolean isMobilePlatform(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        if (null == userAgent) {
            userAgent = "";
        }
        // 匹配
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        return matcherPhone.find() || matcherTable.find();
    }

    /**
     * 获取IP
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        if (request == null) {
            return null;
        }
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(unknown, ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(unknown, ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(unknown, ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(unknown, ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(unknown, ip)) {
            ip = request.getRemoteAddr();
        }

        //如果是多级代理，获取到的IP是多个，如：10.40.146.21, 150.70.168.8, 150.70.168.142
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (StringUtils.isNotEmpty(ip) && ip.contains(Global.COMMA_EN)) {
            String[] arr = StringUtils.split(ip, Global.COMMA_EN);
            if (arr.length > 0) {
                ip = arr[0];
            }
        }

        return ip;
    }

    /**
     * 获取POST回来的数据
     *
     * @param request
     * @return
     */
    public static String getPostString(HttpServletRequest request) {
        try {
            BufferedReader br = request.getReader();
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取网站根路径
     *
     * @param request
     * @return
     */
    public static String getWebRoot(HttpServletRequest request) {
        String path;
        if (request.getServerPort() == 80) {
            path = request.getScheme() + "://" + request.getServerName() + request.getContextPath();
        } else {
            path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        }
        log.info(path);
        return path;
    }

    /**
     * 获取微信内跳转的路径（当前网站地址）
     *
     * @param request
     * @param to
     * @return
     */
    public static String getRedirect(HttpServletRequest request, String to) {
        String path = getWebRoot(request) + "/wx/wechat/redirect?to=" + to;
        log.info(path);
        return path;
    }

    /**
     * 获取微信内跳转的路径（指定base地址）
     *
     * @param base
     * @param to
     * @return
     */
    public static String getRedirect(String base, String to) {
        String path = base + "/wx/wechat/redirect?to=" + to;
        log.info(path);
        return path;
    }

    /**
     * 获取请求中所有的参数
     *
     * @param request
     * @return （按参数字母排序）
     */
    @SuppressWarnings("unchecked")
    public static SortedMap<String, String> getParameterMap(HttpServletRequest request) {
        SortedMap<String, String> result = new TreeMap<String, String>();
        // 获取到的值是String[]类型
        Map<String, String[]> requestParams = request.getParameterMap();
        Iterator<String> iter = requestParams.keySet().iterator();
        while (iter.hasNext()) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            result.put(name, StringUtils.join(values, ","));
        }
        return result;
    }

    public static Map<String, String> getHeaderMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            map.put(name, request.getHeader(name));
        }
        return map;
    }

    /**
     * 获得内网IP
     *
     * @return 内网IP
     */
    private static String getIntranetIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得外网IP
     *
     * @return 外网IP
     */
    private static String getInternetIp() {
        try {
            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            Enumeration<InetAddress> addrs;
            while (networks.hasMoreElements()) {
                addrs = networks.nextElement().getInetAddresses();
                while (addrs.hasMoreElements()) {
                    ip = addrs.nextElement();
                    log.debug("host address:{}", ip.getHostAddress());
                    if (ip != null
                            && ip instanceof Inet4Address
                            && !ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && !ip.getHostAddress().equals(INTRANET_IP)) {
                        return ip.getHostAddress();
                    }
                }
            }

            // 如果没有外网IP，就返回内网IP
            return INTRANET_IP;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测端口是否可用
     *
     * @param port 端口号
     * @return 是否
     */
    public static boolean isPortAvailable(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            server.close();
            log.debug("端口{}可用", port);
            return true;
        } catch (Exception e) {
            log.debug(e.getMessage());
            log.debug("端口{}不可用", port);
        }
        return false;
    }

    /**
     * 在范围内寻找可用端口
     *
     * @param min 最小端口号
     * @param max 最大端口号
     * @return 端口号
     */
    public static int getAvailablePort(int min, int max) {
        log.debug("在{}-{}范围内寻找可用端口", min, max);
        for (int i = min; i <= max; i++) {
            if (isPortAvailable(i)) {
                return i;
            }
        }
        throw new RuntimeException(min + "-" + max + "范围内没有可用端口");
    }

    /**
     * 从请求体（Body）中获取字符串数据
     *
     * @param request HttpServletRequest
     * @return
     */
    public static String getBodyString(HttpServletRequest request) {
        try {
            BufferedReader br = request.getReader();
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从请求体（Body）中获取二进制数据
     *
     * @param request HttpServletRequest
     * @return
     */
    public static byte[] getBodyBinary(HttpServletRequest request) {
        try {
            int len = request.getContentLength();
            ServletInputStream iii = request.getInputStream();
            byte[] buffer = new byte[len];
            iii.read(buffer, 0, len);
            iii.close();
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
