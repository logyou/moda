package com.moda.entity.weixin;

/**
 * 获取小程序码的返回参数
 *
 * @author lyh
 * @version 1.0 2018-8-13
 */
public class GetWxaCodeUnlimitResponse extends BaseJsonResponse {
    /**
     * 二维码内容（Base64编码）
     */
    private String data;
    /**
     * 值（二维码带的参数）
     */
    private String key;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
