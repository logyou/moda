package com.moda.entity.message.push;

import java.io.Serializable;

/**
 * 推送视频详细信息
 */
public class PushVideoDetailMessage implements Serializable {
    private Integer id;//视频ID
    private Integer eid;//剧集ID
    private String vid;//百视通视频ID
    private String fdncode;//百视通视频代码
    private String localUrl;//本地视频地址
    private String cloudUrl;//云端视频地址
    private String coverUrl;//封面图片地址

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getFdncode() {
        return fdncode;
    }

    public void setFdncode(String fdncode) {
        this.fdncode = fdncode;
    }

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getCloudUrl() {
        return cloudUrl;
    }

    public void setCloudUrl(String cloudUrl) {
        this.cloudUrl = cloudUrl;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
