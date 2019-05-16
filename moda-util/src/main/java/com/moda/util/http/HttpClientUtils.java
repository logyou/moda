package com.moda.util.http;

import com.moda.util.mapper.JsonMapper;
import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpClientUtils
 * Created by lyh on 2017/4/25/025.
 */
public class HttpClientUtils {
    private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

    public static List<NameValuePair> generateNameValuePairs(Map<String, Object> properties) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        return nameValuePairs;
    }

    public static String get(String spec, Map<String, Object> params, Map<String, String> headers) throws IOException {
        HttpGet httpGet = new HttpGet(spec);

        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> item : headers.entrySet()) {
                httpGet.addHeader(item.getKey(), item.getValue());
            }
        }

        log.debug(JsonMapper.toJsonStringIndent(httpGet.getAllHeaders()));

        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> item : params.entrySet()) {
                spec = UrlUtils.addUrlParams(spec, item.getKey(), String.valueOf(item.getValue()));
            }
        }
        log.debug(spec);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        String result = null;
        response = client.execute(httpGet);
        result = EntityUtils.toString(response.getEntity());
        log.debug(result);
        response.close();
        client.close();
        return result;
    }

    public static String get(String spec, Map<String, Object> params) throws IOException {
        return get(spec, params, null);
    }

    public static String get(String spec) throws IOException {
        return get(spec, null, null);
    }

    public static String post(String spec, List<NameValuePair> nameValuePairs) {
        log.debug(spec);
        log.debug(JsonMapper.toJsonString(nameValuePairs));
        HttpPost httpPost = new HttpPost(spec);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, Consts.UTF_8));
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        String result = null;
        try {
            response = client.execute(httpPost);
            result = EntityUtils.toString(response.getEntity());
            log.debug(result);
            response.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String post(String spec, Map<String, Object> params) {
        return post(spec, generateNameValuePairs(params));
    }

    public static String postAsJson(String spec, Object obj) throws IOException {
        return postAsJson(spec, obj, null);
    }

    public static String postAsJson(String spec, Object obj, Map<String, String> headers) throws IOException {
        log.debug(spec);
        HttpPost httpPost = new HttpPost(spec);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        if (obj != null) {
            String json = JsonMapper.toJsonString(obj);
            log.debug(json);
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
        }
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> item : headers.entrySet()) {
                httpPost.setHeader(item.getKey(), item.getValue());
            }
        }
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        String result = null;
        response = client.execute(httpPost);
        result = EntityUtils.toString(response.getEntity());
        log.debug(result);
        response.close();
        client.close();
        return result;
    }

    public static <T> T postAsJson(Class<T> clazz, String spec, Object obj) throws IOException {
        String json = postAsJson(spec, obj);
        return JsonMapper.parseObject(json, clazz);
    }
}
