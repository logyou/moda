package com.moda.util.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lyh
 * @create 2018/09/02 19:22
 **/
public class SystemUtils {
    private static Logger logger = LoggerFactory.getLogger(SystemUtils.class);

    /**
     * 获取本机地址
     *
     * @return IP
     */
    public static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取本机名称
     *
     * @return 名称
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
