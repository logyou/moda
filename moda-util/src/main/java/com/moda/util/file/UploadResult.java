package com.moda.util.file;

import java.io.Serializable;

/**
 * 文件上传结果
 * Created by lyh on 2017/7/27/010.
 */
public class UploadResult implements Serializable {
    private String srcUrl;          //原文件相对路径
    private String zipUrl;          //压缩文件相对路径
    private String thuUrl;          //缩略图相对路径
    private String basePath;        //网站根文件夹
    private String subPath;         //网站子文件夹
    private String savePath;        //保存的文件夹
    private String srcFileName;     //原文件名
    private String zipFileName;     //压缩文件名
    private String thuFileName;     //缩略文件名
    private String srcFullFileName; //完整原文件名（包含完整路径）
    private String zipFullFileName; //完整压缩文件名（包含完整路径）
    private String thuFullFileName; //完整缩略文件名（包含完整路径）
    private String tempFullFileName;//临时文件的完整文件名（包含完整路径）
    private String extName;         //文件扩展名

    public String getSrcUrl() {
        if (srcUrl == null && subPath != null && srcFileName != null) {
            srcUrl = subPath + "/" + srcFileName;
        }
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getZipUrl() {
        if (zipUrl == null && subPath != null && zipFileName != null) {
            zipUrl = subPath + "/" + zipFileName;
        }
        return zipUrl;
    }

    public void setZipUrl(String zipUrl) {
        this.zipUrl = zipUrl;
    }

    public String getThuUrl() {
        if (thuUrl == null && subPath != null && thuFileName != null) {
            thuUrl = subPath + "/" + thuFileName;
        }
        return thuUrl;
    }

    public void setThuUrl(String thuUrl) {
        this.thuUrl = thuUrl;
    }

    public String getSavePath() {
        if (savePath == null && basePath != null && subPath != null) {
            savePath = basePath + "/" + subPath;
        }
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getSubPath() {
        return subPath;
    }

    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    public String getSrcFileName() {
        return srcFileName;
    }

    public void setSrcFileName(String srcFileName) {
        this.srcFileName = srcFileName;
    }

    public String getSrcFullFileName() {
        if (srcFullFileName == null && getSavePath() != null && srcFileName != null) {
            srcFullFileName = getSavePath() + "/" + srcFileName;
        }
        return srcFullFileName;
    }

    public void setSrcFullFileName(String srcFullFileName) {
        this.srcFullFileName = srcFullFileName;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public String getTempFullFileName() {
        return tempFullFileName;
    }

    public void setTempFullFileName(String tempFullFileName) {
        this.tempFullFileName = tempFullFileName;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public String getThuFileName() {
        return thuFileName;
    }

    public void setThuFileName(String thuFileName) {
        this.thuFileName = thuFileName;
    }

    public String getZipFullFileName() {
        if (zipFullFileName == null && getSavePath() != null && zipFileName != null) {
            zipFullFileName = getSavePath() + "/" + zipFileName;
        }
        return zipFullFileName;
    }

    public void setZipFullFileName(String zipFullFileName) {
        this.zipFullFileName = zipFullFileName;
    }

    public String getThuFullFileName() {
        if (thuFullFileName == null && getSavePath() != null && thuFileName != null) {
            thuFullFileName = getSavePath() + "/" + thuFileName;
        }
        return thuFullFileName;
    }

    public void setThuFullFileName(String thuFullFileName) {
        this.thuFullFileName = thuFullFileName;
    }
}
