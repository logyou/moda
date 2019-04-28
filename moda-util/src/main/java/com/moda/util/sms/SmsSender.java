package com.moda.util.sms;

import com.moda.entity.sms.SmsResult;
import com.moda.util.cache.JedisUtils;
import com.moda.util.mapper.JsonMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短信发送者
 *
 * @author lyh
 * @since 2018-09-02
 */
public class SmsSender {
    private String apiKey;
    private static Logger log = LoggerFactory.getLogger(SmsSender.class);

    // 查账户信息的http地址
    private static final String URI_GET_USER_INFO = "https://sms.yunpian.com/v2/user/get.json";

    // 智能匹配模版单条发送接口的http地址
    private static final String URI_SINGLE_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    // 编码格式。发送编码格式统一用UTF-8
    private static final String ENCODING = "UTF-8";

    public SmsSender(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * 取账户信息
     *
     * @return json格式字符串
     */

    public static String getUserInfo(String apikey) {
        Map<String, String> params = new HashMap<>();
        params.put("apikey", apikey);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 获取帐户信息
     *
     * @return
     */
    public String getUserInfo() {
        return getUserInfo(getApiKey());
    }

    /**
     * 智能匹配模版接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接收的手机号
     * @return json格式字符串
     */

    public static String sendSms(String apikey, String text, String mobile) {
        Map<String, String> params = new HashMap<>();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SINGLE_SEND_SMS, params);
    }

    /**
     * 发送短信
     *
     * @param text   短信内容
     * @param mobile 接收的手机号
     * @return SmsResult
     */
    public SmsResult sendSms(String text, String mobile) {
        log.debug("发送短信给：{}，内容：{}", mobile, text);
        String json = sendSms(getApiKey(), text, mobile);
        log.debug(json);
        SmsResult smsResult = JsonMapper.parseObject(json, SmsResult.class);
        return smsResult;
    }

    private static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    /**
     * 获取服务器里保存的验证码
     *
     * @param type
     * @param mobile
     * @return
     */
    public static String getSmsCodeOnServer(String type, String mobile) {
        return JedisUtils.get(type + mobile);
    }

    /**
     * 设置服务器里保存的验证码
     *
     * @param type    类型
     * @param mobile  手机号
     * @param code    验证码
     * @param timeout 有效时间（单位：秒）
     * @return
     */
    public static void setSmsCodeOnServer(String type, String mobile, String code, int timeout) {
        JedisUtils.set(type + mobile, code, timeout);
    }

    /**
     * 移除服务器里保存的验证码
     *
     * @param type
     * @param mobile
     * @return
     */
    public static void removeSmsCodeOnServer(String type, String mobile) {
        JedisUtils.del(type + mobile);
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}