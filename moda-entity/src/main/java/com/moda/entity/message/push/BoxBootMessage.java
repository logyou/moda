package com.moda.entity.message.push;

import java.util.Date;

import com.moda.entity.message.BaseMessage;

/**
 * 盒子启动信息
 *
 * @author lyh
 * @create 2018-10-23 12:21
 **/
public class BoxBootMessage extends BaseMessage {
    /**
     * 物业编号
     */
    private String propertyNo;
    /**
     * 房间编号
     */
    private String roomNo;
    /**
     * mac地址
     */
    private String macAddress;

    private Date   bootDt;    //扫码时间

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

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Date getBootDt() {
        return bootDt;
    }

    public void setBootDt(Date bootDt) {
        this.bootDt = bootDt;
    }

}
