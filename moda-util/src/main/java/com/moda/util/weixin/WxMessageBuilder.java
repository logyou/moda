package com.moda.util.weixin;

import com.moda.entity.weixin.*;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 消息builder工具类
 */
public class WxMessageBuilder {

	// 客服文本消息
	public static String prepareCustomText(String openid, String content) {
		HashMap<String, Object> jsObj = new HashMap<String, Object>();
		jsObj.put("touser", openid);
		jsObj.put("msgtype", MsgType.Text.name());
		HashMap<String, Object> textObj = new HashMap<String, Object>();
		textObj.put("content", content);
		jsObj.put("text", textObj);
		return JsonMapper.toJsonString(jsObj);
	}

	// 获取 MsgResponseText 对象
	public static MsgResponseText getMsgResponseText(MsgRequest msgRequest, MsgText msgText) {
		if (msgText != null) {
			MsgResponseText reponseText = new MsgResponseText();
			reponseText.setToUserName(msgRequest.getFromUserName());
			reponseText.setFromUserName(msgRequest.getToUserName());
			reponseText.setMsgType(MsgType.Text.toString());
			reponseText.setCreateTime(new Date().getTime());
			reponseText.setContent(msgText.getContent());
			return reponseText;
		} else {
			return null;
		}
	}

	// 获取 MsgResponseNews 对象
	public static MsgResponseNews getMsgResponseNews(MsgRequest msgRequest, List<MsgNews> msgNews) {
		if (msgNews != null && msgNews.size() > 0) {
			MsgResponseNews responseNews = new MsgResponseNews();
			responseNews.setToUserName(msgRequest.getFromUserName());
			responseNews.setFromUserName(msgRequest.getToUserName());
			responseNews.setMsgType(MsgType.News.toString());
			responseNews.setCreateTime(new Date().getTime());
			responseNews.setArticleCount(msgNews.size());
			List<Article> articles = new ArrayList<Article>(msgNews.size());
			for (MsgNews n : msgNews) {
				Article a = new Article();
				a.setTitle(n.getTitle());
				a.setPicUrl(n.getPicpath());
				if (StringUtils.isEmpty(n.getFromurl())) {
					a.setUrl(n.getUrl());
				} else {
					a.setUrl(n.getFromurl());
				}
				a.setDescription(n.getBrief());
				articles.add(a);
			}
			responseNews.setArticles(articles);
			return responseNews;
		} else {
			return null;
		}
	}

}
