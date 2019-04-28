package com.moda.util.weixin;

import com.alibaba.fastjson.JSONObject;
import com.moda.entity.exception.ServiceException;
import com.moda.entity.weixin.*;
import com.moda.util.http.HttpsClientUtils;
import com.moda.util.lang.StringUtils;
import com.moda.util.mapper.JsonMapper;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信 客户端，统一处理微信相关接口
 *
 * @author lyh
 * @version 1.1 2018-01-12
 */
public class WxApiClient {
    private static Logger log = LoggerFactory.getLogger(WxApiClient.class);

    /**
     * 检查是否有效
     *
     * @param obj
     * @return
     */
    public static boolean check(BaseJsonResponse obj) {
        if (obj == null) {
            log.debug("获取信息失败");
            return false;
        }
        if (obj.getErrcode() != null && obj.getErrcode() != 0) {
            log.debug(String.format("%s -> %s", obj.getErrcode(), obj.getErrmsg()));
            return false;
        }
        return true;
    }

    /**
     * 获取普通 Access Token
     *
     * @param wxAccount
     * @return
     */
    public static String getAccessToken(WxAccount wxAccount) {
        AccessToken token = WxMemoryCacheClient.getAccessToken(wxAccount.getAccount());
        if (token != null && !token.isExpires()) {// 不为空，并且没有过期
            return token.getAccess_token();
        } else {
            token = WxApi.getAccessToken(wxAccount.getAppId(), wxAccount.getAppSecret());
            if (check(token)) {
                WxMemoryCacheClient.addAccessToken(wxAccount.getAccount(), token);
                return token.getAccess_token();
            }
            return null;
        }
    }

    /**
     * 获取 Access Token
     *
     * @return
     */
    public static String getAccessToken() {
        return getAccessToken(WxMemoryCacheClient.getDefaultWxAccount());
    }

    // 获取jsTicket
    public static String getJSTicket(WxAccount mpAccount) {
        JsApiTicket jsApiTicket = WxMemoryCacheClient.getJsApiTicket(mpAccount.getAppId());
        if (jsApiTicket != null && !jsApiTicket.isExpires()) {// 不为空，并且没有过期
            return jsApiTicket.getTicket();
        } else {
            String token = getAccessToken(mpAccount);
            jsApiTicket = WxApi.getJsApiTicket(token);
            if (check(jsApiTicket)) {
                WxMemoryCacheClient.addJsApiTicket(mpAccount.getAccount(), jsApiTicket);
                return jsApiTicket.getTicket();
            }
            return null;
        }
    }

    /**
     * 获取jsTicket
     *
     * @return
     */
    public static String getJSTicket() {
        return getJSTicket(WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 获取网页授权 oauth access token
     *
     * @param mpAccount
     * @param code
     * @return
     */
    public static OAuthAccessToken getOAuthAccessToken(WxAccount mpAccount, String code) {
        OAuthAccessToken token = WxApi.getOAuthAccessToken(mpAccount.getAppId(), mpAccount.getAppSecret(), code);
        if (check(token)) {
            WxMemoryCacheClient.addOAuthAccessToken(token.getOpenid(), token);
            return token;
        }
        return null;
    }

    /**
     * 通过code换取网页授权access_token
     *
     * @param code
     * @return
     */
    public static OAuthAccessToken getOAuthAccessToken(String code) {
        return getOAuthAccessToken(WxMemoryCacheClient.getDefaultWxAccount(), code);
    }

    /**
     * 根据 openId 获取缓存中的网页授权凭证
     *
     * @param openId 微信 open id
     * @return
     */
    public static OAuthAccessToken getOAuthAccessTokenFromCache(String openId) {
        return WxMemoryCacheClient.getOAuthAccessToken(openId);
    }

    /**
     * 获取网页授权 oauth access token
     *
     * @param code
     * @return
     */

    /**
     * 获取 open id
     *
     * @param mpAccount
     * @param code
     * @return
     */
    public static String getOAuthOpenId(WxAccount mpAccount, String code) {
        OAuthAccessToken token = getOAuthAccessToken(mpAccount, code);
        return token == null ? null : token.getOpenid();
    }

    /**
     * 获取 open id
     *
     * @param code 授权码
     * @return
     */
    public static String getOAuthOpenId(String code) {
        return getOAuthOpenId(WxMemoryCacheClient.getDefaultWxAccount(), code);
    }

    /**
     * 根据 open id 获取用户信息
     *
     * @param openId
     * @return
     */
    public static UserInfo getOAuthUserInfo(String openId) {
        UserInfo userInfo = null;
        OAuthAccessToken token = getOAuthAccessTokenFromCache(openId);
        if (token != null) {
            String url = WxApi.getOAuthUserinfoUrl(token.getAccess_token(), openId);
            userInfo = HttpsClientUtils.doGet(UserInfo.class, url);
        }
        return check(userInfo) ? userInfo : null;
    }

    /**
     * 发布菜单
     *
     * @param menus
     * @param mpAccount
     * @return
     */
    public static boolean publishMenus(String menus, WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuCreateUrl(accessToken);
        BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url, menus);
        return check(response);
    }

    /**
     * 发布菜单
     *
     * @param menus
     * @return
     */
    public static boolean publishMenus(String menus) {
        return publishMenus(menus, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 获取菜单
     *
     * @param mpAccount
     * @return
     */
    public static String getMenus(WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuGetUrl(accessToken);
        String response = HttpsClientUtils.doPost(url);
        return response;
    }

    /**
     * 获取菜单
     *
     * @return
     */
    public static String getMenus() {
        return getMenus(WxMemoryCacheClient.getDefaultWxAccount());
    }

    // 创建个性化菜单
    public static boolean publishAddconditionalMenus(String menus, WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuAddconditionalUrl(accessToken);
        BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url, menus);
        return check(response);
    }

    /**
     * 删除菜单
     *
     * @param mpAccount
     * @return
     */
    public static boolean deleteMenu(WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getMenuDeleteUrl(accessToken);
        BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url);
        return check(response);
    }

    /**
     * 删除菜单
     *
     * @return
     */
    public static boolean deleteMenu() {
        return deleteMenu(WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 根据 open id 获取用户信息
     *
     * @param openId
     * @param mpAccount
     * @return
     */
    public static UserInfo getUserInfo(String openId, WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getUserInfoUrl(accessToken, openId);
        UserInfo userInfo = HttpsClientUtils.doGet(UserInfo.class, url);
        return check(userInfo) ? userInfo : null;
    }

    /**
     * 根据 open id 获取用户信息
     *
     * @param openId
     * @return
     */
    public static UserInfo getUserInfo(String openId) {
        return getUserInfo(openId, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 获取素材
     *
     * @param mediaType 素材类型
     * @param offset    开始位置
     * @param count     获取数量
     * @return
     */
    public static Material syncBatchMaterial(MediaType mediaType, Integer offset, Integer count, WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getBatchMaterialUrl(accessToken);
        HashMap<String, Object> bodyObj = new HashMap<String, Object>();
        bodyObj.put("type", mediaType.toString());
        bodyObj.put("offset", offset);
        bodyObj.put("count", count);
        String body = JsonMapper.toJsonString(bodyObj);
        return HttpsClientUtils.doPost(Material.class, url, body);
    }

    // 上传图文消息
    public static BaseJsonResponse uploadNews(List<MsgNews> msgNewsList, WxAccount mpAccount) {
        BaseJsonResponse rstObj = new BaseJsonResponse();
        String accessToken = getAccessToken(mpAccount);
        try {
            List<HashMap<String, Object>> jsonArr = new ArrayList<HashMap<String, Object>>();
            for (MsgNews news : msgNewsList) {
                HashMap<String, Object> jsonObj = new HashMap<String, Object>();
                // 上传图片素材
                String mediaId = WxApi.uploadMedia(accessToken, MediaType.Image.toString(), news.getPicpath());
                jsonObj.put("thumb_media_id", mediaId);
                if (news.getAuthor() != null) {
                    jsonObj.put("author", news.getAuthor());
                } else {
                    jsonObj.put("author", "");
                }
                if (news.getTitle() != null) {
                    jsonObj.put("title", news.getTitle());
                } else {
                    jsonObj.put("title", "");
                }
                if (news.getFromurl() != null) {
                    jsonObj.put("content_source_url", news.getFromurl());
                } else {
                    jsonObj.put("content_source_url", "");
                }
                if (news.getBrief() != null) {
                    jsonObj.put("digest", news.getBrief());
                } else {
                    jsonObj.put("digest", "");
                }
                if (news.getShowpic() != null) {
                    jsonObj.put("show_cover_pic", news.getShowpic());
                } else {
                    jsonObj.put("show_cover_pic", "1");
                }
                jsonObj.put("content", news.getDescription());
                jsonArr.add(jsonObj);
            }
            HashMap<String, Object> postObj = new HashMap<String, Object>();
            postObj.put("articles", jsonArr);
            rstObj = HttpsClientUtils.doPost(BaseJsonResponse.class, WxApi.getUploadNewsUrl(accessToken), JsonMapper.toJsonString(postObj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rstObj;
    }

    /**
     * 根据openid群发接口
     *
     * @param mediaId   ：素材的id；通过素材管理,或者上传素材获取
     * @param msgType
     * @param mpAccount
     * @return
     */
    public static boolean massSendByOpenIds(List<String> openids, String mediaId, MsgType msgType, WxAccount mpAccount) {
        if (openids != null && openids.size() > 0) {
            HashMap<String, Object> postObj = new HashMap<String, Object>();
            HashMap<String, String> media = new HashMap<String, String>();
            postObj.put("touser", openids);
            media.put("media_id", mediaId);
            postObj.put(msgType.toString(), media);
            postObj.put("msgtype", msgType.toString());
            String accessToken = getAccessToken(mpAccount);
            String url = WxApi.getMassSendUrl(accessToken);
            BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url, JsonMapper.toJsonString(postObj));
            return check(response);
        }
        return false;
    }

    /**
     * 根据openid群发文本消息
     *
     * @param openids
     * @param content
     * @param mpAccount
     * @return
     */
    public static boolean massSendTextByOpenIds(List<String> openids, String content, WxAccount mpAccount) {
        if (openids != null && openids.size() > 0) {
            if (openids.size() == 1) {// 根据openId群发，size至少为2
                openids.add("1");
            }
            String[] arr = (String[]) openids.toArray(new String[openids.size()]);
            HashMap<String, Object> postObj = new HashMap<String, Object>();
            HashMap<String, String> text = new HashMap<String, String>();
            postObj.put("touser", arr);
            text.put("content", content);
            postObj.put("text", text);
            postObj.put("msgtype", MsgType.Text.toString());
            String accessToken = getAccessToken(mpAccount);
            String url = WxApi.getMassSendUrl(accessToken);
            BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url, JsonMapper.toJsonString(postObj));
            return check(response);
        }
        return false;
    }

    /**
     * 发送客服消息
     *
     * @param openid
     * @param content 消息内容
     * @return
     */
    public static boolean sendCustomTextMessage(String openid, String content, WxAccount mpAccount) {
        if (!StringUtils.isBlank(openid) && !StringUtils.isBlank(content)) {
            String accessToken = getAccessToken(mpAccount);
            content = WxMessageBuilder.prepareCustomText(openid, content);
            log.debug(content);
            String url = WxApi.getSendCustomMessageUrl(accessToken);
            BaseJsonResponse response = HttpsClientUtils.doPost(BaseJsonResponse.class, url, content);
            return check(response);
        }
        return false;
    }

    /**
     * 发送客服消息
     *
     * @param openid
     * @param content 消息内容
     * @return
     */
    public static boolean sendCustomTextMessage(String openid, String content) {
        return sendCustomTextMessage(openid, content, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 发送微信模板消息
     *
     * @param wtm       模板消息
     * @param mpAccount 微信帐号
     * @return
     */
    public static TemplateMessageResponse sendTemplateMessage(WxTemplateMessage wtm, WxAccount mpAccount) {
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getSendTemplateMessageUrl(accessToken);
        TemplateMessageResponse obj = HttpsClientUtils.doPost(TemplateMessageResponse.class, url, JsonMapper.toJsonString(wtm));
        return obj;
    }

    /**
     * 发送微信模板消息
     *
     * @param wtm 模板消息
     * @return
     */
    public static TemplateMessageResponse sendTemplateMessage(WxTemplateMessage wtm) {
        WxAccount account = WxMemoryCacheClient.getWxAccount(wtm.getWeixinId());
        if (account == null) {
            account = WxMemoryCacheClient.getDefaultWxAccount();
        }
        return sendTemplateMessage(wtm, account);
    }

    /**
     * 生成带参二维码
     *
     * @param expireSecodes 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param actionName    二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @param sceneStr      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @param mpAccount     微信帐号
     * @return
     */
    public static WxQrcodeResponse createQRCode(Integer expireSecodes, String actionName, Integer sceneId, String sceneStr, WxAccount mpAccount) {
        WxQrcodeRequest.Scene scene = new WxQrcodeRequest.Scene();
        scene.setScene_id(sceneId);
        scene.setScene_str(sceneStr);
        WxQrcodeRequest.ActionInfo actionInfo = new WxQrcodeRequest.ActionInfo();
        actionInfo.setScene(scene);
        WxQrcodeRequest request = new WxQrcodeRequest();
        request.setExpire_seconds(expireSecodes);
        request.setAction_name(actionName);
        request.setAction_info(actionInfo);
        String postBody = JsonMapper.toJsonString(request);
        String accessToken = getAccessToken(mpAccount);
        String url = WxApi.getCreateQrcodeUrl(accessToken);
        return HttpsClientUtils.doPost(WxQrcodeResponse.class, url, postBody);
    }

    /**
     * 生成带参临时二维码
     *
     * @param expireSecodes 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param sceneId       场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    public static WxQrcodeResponse createTempQRCode(Integer expireSecodes, Integer sceneId) {
        return createQRCode(expireSecodes, "QR_SCENE", sceneId, null, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 生成带参临时二维码
     *
     * @param expireSecodes 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。
     * @param sceneStr      场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    public static WxQrcodeResponse createTempQRCode(Integer expireSecodes, String sceneStr) {
        return createQRCode(expireSecodes, "QR_STR_SCENE", null, sceneStr, WxMemoryCacheClient.getDefaultWxAccount());
    }

    public static WxQrcodeResponse createTempQRCode(Integer expireSecodes, String sceneStr, WxAccount wxAccount) {
        return createQRCode(expireSecodes, "QR_STR_SCENE", null, sceneStr, wxAccount);
    }

    /**
     * 生成带参永久二维码
     *
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    public static WxQrcodeResponse createLimitQRCode(Integer sceneId) {
        return createQRCode(null, "QR_LIMIT_SCENE", sceneId, null, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 生成带参永久二维码
     *
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    public static WxQrcodeResponse createLimitQRCode(String sceneStr) {
        return createQRCode(null, "QR_LIMIT_STR_SCENE", null, sceneStr, WxMemoryCacheClient.getDefaultWxAccount());
    }

    /**
     * 根据code获取小程序信息
     *
     * @param code      jscode
     * @param mpAccount 小程序账号信息
     * @return 小程序信息
     */
    public static Jscode2session jscode2Session(String code, WxAccount mpAccount) {
        String url = WxApi.getJscode2SessionUrl(mpAccount.getAppId(), mpAccount.getAppSecret(), code);
        Jscode2session userInfo = HttpsClientUtils.doGet(Jscode2session.class, url);
        return check(userInfo) ? userInfo : null;
    }

    public static GetWxaCodeUnlimitResponse getWxaCodeUnlimit(GetWxaCodeUnlimitRequest param, String accessToken) {
        String url = WxApi.getWxaCodeUnlimit(accessToken);
        log.info("url:{}", url);

        Map<String, Object> map = new HashMap<>();
        map.put("scene", param.getScene());
        map.put("page", param.getPage());
        map.put("width", 430);
        map.put("auto_color", false);
        Map<String, Object> line_color = new HashMap<>();
        line_color.put("r", 0);
        line_color.put("g", 0);
        line_color.put("b", 0);
        map.put("line_color", line_color);
        log.info("调用生成微信URL接口传参:" + map);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity requestEntity = new HttpEntity(map, headers);
            RestTemplate rest = new RestTemplate();
            ResponseEntity<byte[]> entity = rest.exchange(url, org.springframework.http.HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
            byte[] content = entity.getBody();
            String data = Base64.encodeBase64String(content);
            if (data.length() < 200) {
                String json = new String(content);
                log.info(json);
                JSONObject jsonObject = JSONObject.parseObject(json);
                if (jsonObject != null && jsonObject.getInteger("errcode") != null && jsonObject.getInteger("errcode") > 0) {
                    throw new ServiceException("获取小程序码失败");
                }
            }

            GetWxaCodeUnlimitResponse result = new GetWxaCodeUnlimitResponse();
            result.setData(data);
            return result;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;

    }

    public static GetWxaCodeUnlimitResponse getWxaCodeUnlimit(GetWxaCodeUnlimitRequest param, WxAccount mpAccount) {
        return getWxaCodeUnlimit(param, getAccessToken(mpAccount));
    }
}
