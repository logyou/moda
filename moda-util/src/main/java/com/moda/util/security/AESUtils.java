package com.moda.util.security;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

public class AESUtils {
    private static Logger logger = LoggerFactory.getLogger(AESUtils.class);
    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";

    static {

    }

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptData(String password, String data) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        //生成key
        SecretKeySpec key = new SecretKeySpec(DigestUtils.md5Hex(password).toLowerCase().getBytes(), ALGORITHM);
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encode(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     * @param password   密码
     * @param ciphertext 密文
     * @return
     * @throws Exception
     */
    public static String decryptData(String password, byte[] ciphertext) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        //生成key
        SecretKeySpec key = new SecretKeySpec(password.getBytes(), ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(ciphertext));
    }


    /**
     * 解密用户敏感数据获取用户信息
     *
     * @param sessionKey    数据进行加密签名的密钥
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param iv            加密算法的初始向量
     * @return
     */
    public static JSONObject decryMiniAppUserInfo(String encryptedData, String sessionKey, String iv) {
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionKey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, StandardCharsets.UTF_8);
                return JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        String encryptedData = "9cB5EcWyqAtzYKsUhPDHeFXJKdPtOc2HLE/eVmlGVkwjfZo/l9dn3w9o+KjRMi9937kHyscda+kM2WUkr0Xcqt4zVr8UiD4954XKUBi9LXIgXTQ/hBK46SVD7Q5Ruvu1GlIWEJk1ISLqSvX41o8jBsi0Q1h0jneW4ruP7yi+xunWHiZoLI6Rfetgs2UpahClJ7kwPymKR2rs09yY+vJ53qxxES7IujTmTMFLGKYo0avasJqTH+VxxebyghjARKHzkmkrDqDnr9YDdULFVfYYPVceqho48XYE6gpl4Zd/56APE1Wc2KdbkJPPtG8XtO2zZFCa8oUqzu1kKc1XCIGfHsoaT19gmEhYBsnkwJwL4wpNq430fSfnLakws6Uiv7g+YdoHna/8o52zeIpYnGtSOate+VP48HY74xiOp1GgKDR83MkMsw6a+gJWBzNlC2T9hSbxdsnkuaqF5iboXVzJ2TeE1I4V1hAciItV/3UwlawvNnxBWxHTMNpBJ7SH1nACf/Jbnome+MQxVfLvYR/5YarcdMuVsatA3KtA/nab0HY=";
        String iv = "d8+MAacG3DZGPr04ncYCBA==";
        String sessionKey = "BndEM6ME8Ju+YrpDfEb2xQ==";
        System.out.println(AESUtils.decryMiniAppUserInfo(encryptedData, sessionKey, iv));
    }
}
