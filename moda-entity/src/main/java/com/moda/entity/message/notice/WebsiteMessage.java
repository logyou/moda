package com.moda.entity.message.notice;

import com.moda.entity.message.BaseMessage;

import java.util.List;

/**
 * 站内信
 *
 * @author lyh
 * @version 2018-8-29 18:15:27
 */
public class WebsiteMessage extends BaseMessage {
    /**
     * 发送者id：0-系统；大于0-其它用户
     */
    private Integer senderId;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * url
     */
    private String url;
    /**
     * 接收用户列表
     */
    private List<Receiver> userList;
    /**
     * 接收分组列表
     */
    private List<Receiver> groupList;
    /**
     * 所属子系统ID
     */
    private Integer sid;
    /**
     * 酒店ID
     */
    private Integer hid;

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Receiver> getUserList() {
        return userList;
    }

    public void setUserList(List<Receiver> userList) {
        this.userList = userList;
    }

    public List<Receiver> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Receiver> groupList) {
        this.groupList = groupList;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 消息接收者
     */
    public static class Receiver extends BaseMessage {
        /**
         * 用户ID或分组ID
         */
        private Integer id;
        /**
         * 参数
         */
        private String parameter;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }
    }
}
