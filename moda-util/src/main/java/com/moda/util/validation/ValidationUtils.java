package com.moda.util.validation;

import com.moda.entity.exception.AccessException;
import com.moda.util.lang.StringUtils;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 校验工具类
 *
 * @author lyh
 * @version 2018-08-31
 */
public class ValidationUtils {
    /**
     * 验证手机号正则表达式
     */
    public static final String REGEX_MOBILE = "^((1[3|4|5|6|7|8|9][0-9])+\\d{8})$";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-zA-Z0-9]+[-a-zA-Z0-9]*[a-zA-Z0-9]+.){1,63}[a-zA-Z0-9]+$";
    /**
     * 验证IPV4正则表达式，只验证基本位数是否合法，此处正则表达式有待完善
     */
    public static final String REGEX_IP_V4 = "^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}$";

    /**
     * 验证是否为手机号
     *
     * @param mobile
     * @return
     */
    public static Boolean isMobile(String mobile) {
        if (mobile == null || mobile.equals("")) {
            return false;
        }
        return mobile.matches(REGEX_MOBILE);
    }

    /**
     * 验证是否为非负浮点数（即正浮点数，包括 0）
     *
     * @param str 字符串
     * @return
     */
    public static Boolean isNonNegativeFloat(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("^\\d+(\\.\\d+)?$");
    }

    /***
     * 验证是否为非负整数
     *
     * @param str
     * @return
     */
    public static Boolean isInteger(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("^\\d+$");
    }

    /**
     * 验证是否是身份证号码
     *
     * @param str
     * @return
     */
    public static boolean isIdcard(String str) {
        return IDCardUtils.validateCard(str);
    }

    /**
     * 验证是否为银行卡号
     *
     * @return
     */
    public static Boolean isBankCardNo(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^(\\d{16}|\\d{19})$");
    }

    /**
     * 验证是否为银行卡号
     *
     * @return
     */
    public static Boolean isEmail(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(REGEX_EMAIL);
    }

    /**
     * 格式错误结果为字符串
     *
     * @param result BindingResult
     * @return 详细错误信息
     */
    public static String formatResult(BindingResult result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.getAllErrors().size(); i++) {
            if (i > 0) {
                sb.append("；");
            }
            sb.append(result.getAllErrors().get(i).getDefaultMessage());
        }
        return sb.toString();
    }

    /**
     * 验证参数，并返回验证信息，JSR303 规范（Bean Validation 规范）
     *
     * @param obj 要验证的实体类
     * @return 错误信息
     */
    public static String validate(Object obj) {
        if (obj == null) {
            return "";
        }

        ValidatorFactory validation = Validation.buildDefaultValidatorFactory();
        Validator validator = validation.getValidator();
        Set<ConstraintViolation<Object>> set = validator.validate(obj);
        if (set == null || set.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (ConstraintViolation<Object> cv : set) {
            if (i > 0) {
                sb.append("；");
            }
            sb.append(cv.getMessage());
            i++;
        }

        return sb.toString();
    }

    /**
     * 格式化验证信息
     *
     * @param set 验证信息集合
     * @return 验证信息
     */
    public static String formatConstraintViolation(Set<ConstraintViolation<?>> set) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (ConstraintViolation<?> cv : set) {
            if (i > 0) {
                sb.append("；");
            }
            sb.append(cv.getMessage());
            i++;
        }

        return sb.toString();
    }

    /**
     * 验证实体属性值是否有效，JSR303 规范（Bean Validation 规范）
     *
     * @param obj 要验证的实体类
     */
    public static void assertSuccess(Object obj) {
        String error = validate(obj);
        if (StringUtils.isNotEmpty(error)) {
            throw new AccessException(error);
        }
    }

    /**
     * 验证是否为合法的IPV4
     *
     * @param ip ip
     * @return 是否合法
     */
    public static boolean isIpV4(String ip) {
        if (StringUtils.isEmpty(ip)) {
            return false;
        }
        return ip.matches(REGEX_IP_V4);
    }
}
