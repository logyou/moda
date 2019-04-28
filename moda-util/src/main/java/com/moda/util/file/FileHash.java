/**
 * 文件Hash处理方法
 * 20160108 add by 梁华山
 */
package com.moda.util.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class FileHash {

    private static char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String MD5 = "MD5";
    public static String SHA1 = "SHA1";
    public static String SHA_256 = "SHA-256";
    public static String SHA_384 = "SHA-384";


    /**
     * 计算文件的hash值:MD5,SHA1
     *
     * @param fileName 文件名
     * @return key为：fileSize， fileMd5， fileSha1
     * @throws Exception
     */
    public static Map<String, Object> getFileMD5AndSHA1(String fileName) throws Exception {
        Map<String, Object> map = new HashMap<>();
        InputStream fis = null;
        int size = 0;
        try {
            fis = new FileInputStream(fileName);
            byte[] buffer = new byte[1024 * 1024 * 10];// 10M
            MessageDigest md5 = MessageDigest.getInstance(MD5);
            MessageDigest sha1 = MessageDigest.getInstance(SHA1);
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
                sha1.update(buffer, 0, numRead);
                size += numRead;
            }
            map.put("fileSize", size);
            String md5Str = toHexString(md5.digest());
            map.put("fileMd5", md5Str);
            String sha1Str = toHexString(sha1.digest());
            map.put("fileSha1", sha1Str);
        } catch (Exception e) {
            throw e;
        } finally {
            if (fis != null)
                fis.close();
        }
        return map;
    }

    /**
     * 计算文件的hash值
     *
     * @param fileName 文件名
     * @param hashType hash类型：MD5,SHA1,SHA-256,SHA-384
     * @return
     * @throws Exception
     */
    public static String getFileHash(String fileName, String hashType) {
        String hashStr = "";
        InputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            byte[] buffer = new byte[1024 * 1024 * 10];// 10M
            MessageDigest md5 = MessageDigest.getInstance(hashType);
            int numRead = 0;
            while ((numRead = fis.read(buffer)) > 0) {
                md5.update(buffer, 0, numRead);
            }
            hashStr = toHexString(md5.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        return hashStr;
    }

    private static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }
}
