package com.moda.entity.app;

import com.moda.entity.BaseEntity;

import java.util.Date;

/**
 * 应用帐号 实体类
 *
 * @author lyh
 * @version 2018-8-31
 */
public class ApplicationAccount extends BaseEntity {
    /**
     * ID
     */
    private Integer id;
    /**
     * 应用id
     */
    private String appId;
    /**
     * 应用密钥
     */
    private String appKey;
    /**
     * 状态：1-启用；0-禁用
     */
    private Integer status;
    /**
     * 有效开始时间
     */
    private Date startTime;
    /**
     * 有效结束时间
     */
    private Date endTime;
    /**
     * 创建时间
     */
    private Date createTime;

    public ApplicationAccount() {
        super();
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}