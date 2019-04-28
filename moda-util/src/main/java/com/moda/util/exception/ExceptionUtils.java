package com.moda.util.exception;

import com.moda.entity.exception.AccessException;
import com.moda.entity.exception.ServiceException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常处理
 *
 * @author lyh
 * @create 2018-9-22
 **/
public class ExceptionUtils {
    /**
     * 抛出访问异常
     *
     * @param message 消息
     */
    public static void throwAccessException(String message) {
        throw new AccessException(message);
    }

    public static void throwAccessException(Integer status, String message) {
        throw new AccessException(status, message);
    }

    /**
     * 抛出服务异常
     *
     * @param message 消息
     */
    public static void throwServiceException(String message) {
        throw new ServiceException(message);
    }

    public static void throwServiceException(Integer status, String message) {
        throw new ServiceException(status, message);
    }

    /**
     * 将ErrorStack转化为String.
     */
    public static String getStackTraceAsString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
