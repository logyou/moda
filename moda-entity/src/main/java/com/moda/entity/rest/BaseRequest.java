package com.moda.entity.rest;

import com.moda.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * 请求基类
 *
 * @author lyh
 * @create 2018/8/25 20:06
 **/
public class BaseRequest extends BaseEntity {
    /**
     * 应用ID
     */
    @ApiModelProperty(value = "应用ID", required = true, position = -6)
    private String appId;
    /**
     * 应用密钥
     */
    @ApiModelProperty(hidden = true)
    private String appKey;
    /**
     * 签名
     */
    @ApiModelProperty(value = "签名", required = true, position = -5)
    private String sign;
    /**
     * 时间戳
     */
    @ApiModelProperty(value = "时间戳", required = true, position = -4)
    private Long timestamp;
    /**
     * 第几页
     */
    @ApiModelProperty(value = "第几页", position = -3, example = "1")
    private Integer pageNo;
    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量", position = -2, example = "10")
    private Integer pageSize;
    /**
     * 访问凭证
     */
    @ApiModelProperty(value = "访问凭证", position = -1)
    private String accessToken;

    /**
     * 是否是第一页
     *
     * @return boolean
     */
    @ApiModelProperty(hidden = true)
    public boolean isFirstPage() {
        return getPageNo().equals(1);
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

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getPageNo() {
        return pageNo == null ? 1 : pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
