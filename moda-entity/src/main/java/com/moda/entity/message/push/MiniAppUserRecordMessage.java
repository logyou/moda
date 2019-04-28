/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.message.push;

/**
 * 小程序用户操作日志消息                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2019年03月30日</li>
 *
 */
public class MiniAppUserRecordMessage extends PushBaseMessage {
    private Long    ti;      //操作时间，格式：yyyyMMddHHmmss
    private Integer appId;   //应用ID,10:DK互娱小程序;14:邸客合伙人小程序端;19:设备管理小程序;20:盛世美颜小程序;21:一城一礼小程序
    private Integer adAppId; //广告主应用ID,1:一城一礼小程序;2:盛世美颜小程序
    private String  url;     //页面路径
    private String  v;       //版本号
    private Integer uid;     //用户ID
    private Integer ot;      //类型:1摇控操作;11:播放视频;13:浏览视频;23:播放广告;31盛世美颜-播放视频;32盛世美颜-接通视频;33盛世美颜-浏览主播;99其他操作
    private String  okey;    //操作键，若无，则为空
    private Integer vid;     //视频ID，若无，则为空
    private Integer adid;    //广告id，若无，则为空
    private Integer aid;     //主播id，若无，则为空
    private String  desc;    //描述，正常情况下不传，只在异常情况下传。
    private String  ip;      //客户端IP

    public Long getTi() {
        return ti;
    }

    public void setTi(Long ti) {
        this.ti = ti;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getAdAppId() {
        return adAppId;
    }

    public void setAdAppId(Integer adAppId) {
        this.adAppId = adAppId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOt() {
        return ot;
    }

    public void setOt(Integer ot) {
        this.ot = ot;
    }

    public String getOkey() {
        return okey;
    }

    public void setOkey(String okey) {
        this.okey = okey;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
