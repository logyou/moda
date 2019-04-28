/**
 * bensue.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.moda.entity.message.push;

import java.util.Date;

/**
 *  盒子存活消息                     
 * @Description: 
 * @Copyright: bensue.com
 * @History:<br>
 *<li>Author: 梁华山</li>
 *<li>Date: 2018年10月19日</li>
 *
 */
public class BoxActivateMessage extends PushBaseMessage {
    private String  pno;        //物业编号
    private String  rno;        //房间编号
    private Integer uid;        //用户ID
    private String  mac;        //MAC地址
    private Date    activateDt; //存活时间

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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Date getActivateDt() {
        return activateDt;
    }

    public void setActivateDt(Date activateDt) {
        if (null == activateDt) {
            activateDt = new Date();
        }
        this.activateDt = activateDt;
    }
}
