/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.message.push;

/**
 * 盒子端用户操作日志消息                      
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年10月19日</li>
 *
 */
public class UserRecordMessage extends PushBaseMessage {
    private Long    ti;  //操作时间，格式：yyyyMMddHHmmss
    private String  pno; //物业编号
    private String  rno; //房间编号
    private String  v;   //版本号
    private Integer uid; //用户ID
    private Integer ot;  //类型:1摇控操作;2:小程序操作;11:播放视频;21:主页播放广告;22:其他页播放广告;
    private String  okey;//操作键
    private Integer vid; //视频ID
    private Integer adid;//广告id，若无，则为空
    private String  desc;//描述，正常情况下不传，只在异常情况下传。
    private String  clnm;//页面类名
    private String  ip;  //客户端IP

    public Long getTi() {
        return ti;
    }

    public void setTi(Long ti) {
        this.ti = ti;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getRno() {
        return rno;
    }

    public void setRno(String rno) {
        this.rno = rno;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getClnm() {
        return clnm;
    }

    public void setClnm(String clnm) {
        this.clnm = clnm;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
