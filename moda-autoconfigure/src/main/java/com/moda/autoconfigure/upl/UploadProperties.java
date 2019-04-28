package com.moda.autoconfigure.upl;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 上传文件配置
 *
 * @author lyh
 * @version 2018-10-6 11:03:43
 */
@ConfigurationProperties(prefix = "upload")
public class UploadProperties {
    /**
     * 接口地址
     */
    private String apiUrl;
    /**
     * 默认存储文件夹路径
     */
    private String folder;
    /**
     * 最大可上传图片大小（M）
     */
    private Float maxImageSize;
    /**
     * 可上传的图片类型
     */
    private String acceptedImageTypes;
    /**
     * 最大可上传文件大小（M）
     */
    private Float maxFileSize;
    /**
     * 可上传的文件类型
     */
    private String acceptedFileTypes;
    /**
     * APK上传保存目录
     */
    private String apkFolder;

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public Float getMaxImageSize() {
        return maxImageSize;
    }

    public void setMaxImageSize(Float maxImageSize) {
        this.maxImageSize = maxImageSize;
    }

    public String getAcceptedImageTypes() {
        return acceptedImageTypes;
    }

    public void setAcceptedImageTypes(String acceptedImageTypes) {
        this.acceptedImageTypes = acceptedImageTypes;
    }

    public Float getMaxFileSize() {
        return maxFileSize;
    }

    public void setMaxFileSize(Float maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public String getAcceptedFileTypes() {
        return acceptedFileTypes;
    }

    public void setAcceptedFileTypes(String acceptedFileTypes) {
        this.acceptedFileTypes = acceptedFileTypes;
    }

    public String getApkFolder() {
        return apkFolder;
    }

    public void setApkFolder(String apkFolder) {
        this.apkFolder = apkFolder;
    }
}
