package com.moda.entity.message.push;

import java.util.Date;

/**
 * 用户扫码消息
 *
 * @author lyh
 * @version 2018-5-16
 */
public class UserScanBoxMessage extends PushBaseMessage {
    private Integer uid;       //用户ID
    private String  propertyNo;//物业编号
    private String  roomNo;    //房间编号
    private Date    scanDt;    //扫码时间

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Date getScanDt() {
        return scanDt;
    }

    public void setScanDt(Date scanDt) {
        if (null == scanDt) {
            scanDt = new Date();
        }
        this.scanDt = scanDt;
    }

}
