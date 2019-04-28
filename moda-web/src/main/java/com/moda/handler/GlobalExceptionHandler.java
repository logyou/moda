package com.moda.handler;

import com.moda.autoconfigure.product.ProductProperties;
import com.moda.autoconfigure.sys.SysProperties;
import com.moda.entity.exception.AccessException;
import com.moda.entity.exception.ServiceException;
import com.moda.entity.message.system.ErrorMessage;
import com.moda.entity.rest.Result;
import com.moda.util.exception.ExceptionUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.message.MessageSender;
import com.moda.util.request.RequestUtils;
import com.moda.util.system.SystemUtils;
import com.moda.util.validation.ValidationUtils;
import com.moda.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Date;

/**
 * 全局 Controller 异常处理
 *
 * @author lyh
 * @create 2018/08/27 03:28
 **/
@EnableConfigurationProperties({SysProperties.class, ProductProperties.class})
@RestControllerAdvice
public class GlobalExceptionHandler extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HttpServletRequest request;
    @Autowired(required = false)
    private MessageSender messageSender;
    @Autowired
    private SysProperties sysProperties;
    @Autowired
    private ProductProperties productProperties;

    @ExceptionHandler(AccessException.class)
    public Result accessException(AccessException e) {
        return result(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public Result serviceException(ServiceException e) {
        return result(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result constraintViolationException(ConstraintViolationException e) {
        return fail(ValidationUtils.formatConstraintViolation(e.getConstraintViolations()));
    }

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        record(e);
        return fail("抱歉，服务器繁忙，请稍后重试！");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error(e.getMessage(), e);
        return fail("缺少参数或参数格式错误！");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return fail("不支持的参数类型，只支持 Content-Type 为 application/json 类型！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return fail("不支持" + e.getMethod() + "请求方式，请使用" + StringUtils.join(e.getSupportedMethods(), ",") + "请求方式！");
    }

    /**
     * 记录错误信息
     *
     * @param e 错误
     */
    private void record(Exception e) {
        try {
            //输出错误信息以便后期跟踪排查错误
            logger.error(e.getMessage(), e);

            //记录错误信息
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setType(e.getClass().getName());
            errorMessage.setTitle(StringUtils.substring(e.getMessage(), 0, 255));
            errorMessage.setProductName(productProperties.getName());
            errorMessage.setProductVersion(sysProperties.getEnv());
            errorMessage.setRequestUri(RequestUtils.getIpAddress(request));
            errorMessage.setUserAgent(request.getHeader("user-agent"));
            errorMessage.setRequestUri(request.getRequestURI());
            errorMessage.setMethod(request.getMethod());
            errorMessage.setException(StringUtils.substring(ExceptionUtils.getStackTraceAsString(e), 0, 10000));
            errorMessage.setCreateTime(new Date());
            errorMessage.setParams("");
            errorMessage.setIp(RequestUtils.getIpAddress(request));
            errorMessage.setHostAddress(SystemUtils.getHostAddress());
            errorMessage.setHostName(SystemUtils.getHostName());

            //发送错误信息
            messageSender.sendError(errorMessage);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
