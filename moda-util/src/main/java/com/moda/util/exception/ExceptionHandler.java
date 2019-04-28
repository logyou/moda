package com.moda.util.exception;

import com.moda.util.message.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuyuhua on 2017/6/7.
 */
public class ExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    private String productName;
    private String env;
    private String notifyMailAddress;
    @Autowired
    private MessageSender messageSender;

    public ExceptionHandler(String productName, String env, String notifyMailAddress) {
        this.productName = productName;
        this.env = env;
        this.notifyMailAddress = notifyMailAddress;
    }

    private StringBuilder getVersionMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("名称：");
        sb.append(productName);
        sb.append("<br/>版本：");
        sb.append(env);
        sb.append("<br/>详情：<br/>");
        return sb;
    }

    private StringBuilder getErrorMessage(Exception e) {
        StringBuilder sb = getVersionMessage();
        sb.append(e.toString());
        return sb;
    }

    private StringBuilder getErrorMessage(String content) {
        StringBuilder sb = getVersionMessage();
        sb.append(content);
        return sb;
    }

    public void processError(Exception e, String subject) {
        try {
            messageSender.sendEmail(subject, getErrorMessage(e).toString(), notifyMailAddress);
        } catch (Exception ex) {
            logger.error("处理错误信息失败", e);
        }
    }

    public void processError(String subject, String content) {
        try {
            messageSender.sendEmail(subject, getErrorMessage(content).toString(), notifyMailAddress);
        } catch (Exception e) {
            logger.error("处理错误信息失败", e);
        }
    }
}
