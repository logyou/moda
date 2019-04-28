package com.moda.util.http;

import com.moda.entity.weixin.DataType;
import com.moda.entity.weixin.HttpMethod;
import com.moda.util.mapper.JaxbMapper;
import com.moda.util.mapper.JsonMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Map;

/**
 * HTTPS 请求帮助类
 *
 * @author lyh
 * @version 1.1 2016-06-07
 */
public class HttpsClientUtils {
    private static Logger log = LoggerFactory.getLogger(HttpsClientUtils.class);
    private static Charset UTF_8 = StandardCharsets.UTF_8;

    /**
     * String -> T
     *
     * @param clazz  类
     * @param result 字符串
     * @param type   类型
     * @return
     */
    public static <T> T convert(Class<T> clazz, String result, DataType type) {
        if (type == DataType.XML) {
            return JaxbMapper.fromXml(result, clazz);
        } else if (type == DataType.JSON) {
            return JsonMapper.parseObject(result, clazz);
        } else {
            return null;
        }
    }

    public static String httpsRequest(String spec, String method, String params) {
        String result = null;
        try {
            TrustManager[] tm = {new WeiXinX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(spec);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(method);
            if (null != params) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(params.getBytes(UTF_8));
                outputStream.close();
            }
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            result = buffer.toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        log.info(spec);
        log.info(method);
        log.info(params);
        log.info(result);
        return result;
    }

    public static String httpsRequestAsJson(String spec, String params, Map<String, String> headers) {
        String result = null;
        try {
            TrustManager[] tm = {new WeiXinX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(spec);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);

            // 设置传递方式
            conn.setRequestMethod("POST");
            //转换为字节数组
            byte[] data = params.getBytes();
            //设置类型和头部参数
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> item : headers.entrySet()) {
                    conn.setRequestProperty(item.getKey(), item.getValue());
                }
            }

            if (null != params) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(params.getBytes(UTF_8));
                outputStream.close();
            }
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            result = buffer.toString();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        log.info(spec);
        log.info(params);
        log.info(result);
        return result;
    }

    public static String doGet(String spec, String params) {
        return httpsRequest(spec, HttpMethod.GET, params);
    }

    public static String doGet(String spec) {
        return doGet(spec, null);
    }

    public static String doPost(String spec, String params) {
        return httpsRequest(spec, HttpMethod.POST, params);
    }

    public static String doPost(String spec) {
        return doPost(spec, null);
    }

    public static <T> T doGet(Class<T> clazz, String spec, String params, DataType type) {
        String result = doGet(spec, params);
        return convert(clazz, result, type);
    }

    public static <T> T doGet(Class<T> clazz, String spec, DataType type) {
        return doGet(clazz, spec, null, type);
    }

    public static <T> T doGet(Class<T> clazz, String spec, String params) {
        return doGet(clazz, spec, params, DataType.JSON);
    }

    public static <T> T doGet(Class<T> clazz, String spec) {
        return doGet(clazz, spec, DataType.JSON);
    }

    public static <T> T doPost(Class<T> clazz, String spec, String params, DataType type) {
        String result = doPost(spec, params);
        return convert(clazz, result, type);
    }

    public static <T> T doPost(Class<T> clazz, String spec, DataType type) {
        return doPost(clazz, spec, null, type);
    }

    public static <T> T doPost(Class<T> clazz, String spec, String params) {
        return doPost(clazz, spec, params, DataType.JSON);
    }

    public static <T> T doPost(Class<T> clazz, String spec) {
        return doPost(clazz, spec, DataType.JSON);
    }

    public static byte[] httpsRequestByte(String requestUrl, String requestMethod) {
        return httpsRequestByte(requestUrl, requestMethod, null);
    }

    public static byte[] httpsRequestByte(String requestUrl, String requestMethod, String outputStr) {
        try {
            TrustManager[] tm = {new WeiXinX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new SecureRandom());
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(outputStr.getBytes(UTF_8));
                outputStream.close();
            }
            InputStream inputStream = conn.getInputStream();
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
            return output.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 带证书的POST请求
     *
     * @param requestUrl 请求地址
     * @param params     参数
     * @param certPath   证书路径
     * @param password   证书密码
     * @return
     * @throws Exception
     */
    public static String postWithCert(String requestUrl, String params, String certPath, String password) throws Exception {
        log.info(params);
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream instream = new FileInputStream(new File(certPath));

        try {
            keyStore.load(instream, password.toCharArray());
        } finally {
            instream.close();
        }

        // Trust own CA and all self-signed certs
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
        // Allow TLSv1 protocol only
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, new DefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        try {
            HttpPost httppost = new HttpPost(requestUrl);
            HttpEntity data = new StringEntity(params, UTF_8);
            httppost.setEntity(data);

            log.info(httppost.getRequestLine().toString());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text;
                    StringBuffer buffer = new StringBuffer();
                    while ((text = bufferedReader.readLine()) != null) {
                        buffer.append(text);
                    }
                    String result = buffer.toString();
                    log.info(result);
                    return result;
                }
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return null;
    }
}
