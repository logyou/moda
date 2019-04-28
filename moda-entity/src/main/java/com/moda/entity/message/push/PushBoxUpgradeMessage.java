package com.moda.entity.message.push;

/**
 * 推送盒子更新消息
 *
 * @author lyh
 * @version 2018-10-22 17:22:47
 */
public class PushBoxUpgradeMessage extends PushBaseMessage {
    /**
     * APP版本号，如：12
     */
    private Integer versionCode;
    /**
     * APP版本名，如：1.2.0.3
     */
    private String versionName;
    /**
     * APP文件ID，如：salmon_release_v1.2.0.1.apk
     */
    private String fileId;
    /**
     * 版本描述，如：修复BUG
     */
    private String versionDesc;

    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
    }
}
