package com.moda.entity.weixin;

import java.io.Serializable;
import java.util.List;

/**
 * 微信自定义菜单 实体类
 *
 * @author lyh
 * @version 2017-05-16
 */
public class WxCustomMenu implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级id
     */
    private Integer pid;
    /**
     * 类型
     */
    private String type;
    /**
     * 链接
     */
    private String url;
    /**
     * 媒体id
     */
    private String mediaId;
    /**
     * 键值
     */
    private String key;
    /**
     * 小程序的appid
     */
    private String appid;
    /**
     * 小程序的页面路径
     */
    private String pagepath;
    /**
     * 子菜单
     */
    private List<WxCustomMenu> sub_button;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<WxCustomMenu> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<WxCustomMenu> sub_button) {
        this.sub_button = sub_button;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getRootId() {
        return 0;
    }

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