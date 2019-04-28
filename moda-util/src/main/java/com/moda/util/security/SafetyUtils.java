package com.moda.util.security;

import com.moda.util.codec.EncodeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密等安全相关
 *
 * @author lyh
 * @date 2018-9-21
 */
public class SafetyUtils {
    private static Logger logger = LoggerFactory.getLogger(SafetyUtils.class);

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String encryptPassword(String plainPassword) {
        byte[] salt = DigestUtils.generateSalt(SALT_SIZE);
        byte[] hashPassword = DigestUtils.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
        return EncodeUtils.encodeHex(salt) + EncodeUtils.encodeHex(hashPassword);
    }

    /**
     * 验证密码
     *
     * @param plainPassword   明文密码
     * @param encryptPassword 密文密码
     * @return 验证成功返回true，否则返回false
     */
    public static boolean validatePassword(String plainPassword, String encryptPassword) {
        try {
            byte[] salt = EncodeUtils.decodeHex(encryptPassword.substring(0, 16));
            byte[] hashPassword = DigestUtils.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
            return encryptPassword.equals(EncodeUtils.encodeHex(salt) + EncodeUtils.encodeHex(hashPassword));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }
}
