package com.moda.entity.weixin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信语音消息响应类
 *
 * @author lyh
 * @version 1.0 2016-10-10
 */
@XmlRootElement(name = "xml")
public class WxVoiceMessageResponse extends BaseMessageXmlResponse {
    private static final long serialVersionUID = 1396770480578540714L;
    private String mediaId;// 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String format;// 语音格式，如amr，speex等
    private String recognition;// 语音识别结果，UTF8编码

    @XmlElement(name = "MediaId")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @XmlElement(name = "Format")
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @XmlElement(name = "Recognition")
    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
