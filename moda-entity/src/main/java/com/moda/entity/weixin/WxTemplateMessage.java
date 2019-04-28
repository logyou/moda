package com.moda.entity.weixin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信模板消息实体
 *
 * @author lyh
 * @version 1.1 2016-05-11
 */
public class WxTemplateMessage implements Serializable {
    private static final long serialVersionUID = 8810458338634537633L;
    private String weixinId;
    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private Map<String, TextField> data = new HashMap<String, TextField>();
    private Miniprogram miniprogram;

    public WxTemplateMessage() {
    }

    public WxTemplateMessage(String weixinId, String touser, String template_id) {
        this(weixinId, touser, template_id, null, null);
    }

    public WxTemplateMessage(String weixinId, String touser, String template_id, String url) {
        this(weixinId, touser, template_id, url, null);
    }

    public WxTemplateMessage(String weixinId, String touser, String template_id, String url, String topcolor) {
        this.weixinId = weixinId;
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.topcolor = topcolor;
    }

    public WxTemplateMessage addTextField(String key, String value) {
        return addTextField(key, value, null);
    }

    public WxTemplateMessage addTextField(String key, String value, String color) {
        data.put(key, new TextField(value, color));
        return this;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TextField> getData() {
        return data;
    }

    public void setData(Map<String, TextField> data) {
        this.data = data;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public Miniprogram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(Miniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public static class TextField implements Serializable {
        private static final long serialVersionUID = 399914261689992885L;
        private String value;
        private String color;

        public TextField() {
        }

        public TextField(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }

    public static class Miniprogram implements Serializable {
        private String appid;
        private String pagepath;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }
    }
}
