package com.moda.util.weixin;

import com.moda.entity.weixin.AccessToken;
import com.moda.entity.weixin.JsApiTicket;
import com.moda.entity.weixin.OAuthAccessToken;
import com.moda.util.codec.EncodeUtils;
import com.moda.util.http.HttpsClientUtils;
import com.moda.util.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * 微信 API、微信基本接口
 */

public class WxApi {

    private static Logger log = LoggerFactory.getLogger(WxApi.class);

    // token 接口
    private static final String TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    // 创建菜单
    private static final String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";

    // 获取菜单
    private static final String MENU_GET = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";

    // 创建个性化菜单
    private static final String MENU_ADDCONDITIONAL = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=%s";

    // 删除菜单
    private static final String MENU_DELETE = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";

    // 获取账号粉丝信息
    private static final String GET_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";

    // 获取账号粉丝列表
    private static final String GET_USER_LIST = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s";

    // 获取批量素材
    private static final String GET_BATCH_MATERIAL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";

    // 上传多媒体资料接口
    private static final String UPLOAD_MEDIA = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s";

    // 下载多媒体文件
    private final static String GET_MEDIA = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";

    // 上传永久素材：图文
    private static final String UPLOAD_NEWS = "https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=%s";

    // 群发接口
    private static final String MASS_SEND = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=%s";

    // 网页授权OAuth2.0获取code
    private static final String GET_OAUTH_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=%s&scope=%s&state=%s#wechat_redirect";

    // 网页授权OAuth2.0获取token
    private static final String GET_OAUTH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

    // 网页授权OAuth2.0获取用户信息
    private static final String GET_OAUTH_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN";

    // 生成二维码
    private static final String CREATE_QRCODE = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s";

    // 生成小程序二维码
    private static final String GET_WXA_CODE_UNLIMIT = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";

    // 根据ticket获取二维码图片
    private static final String SHOW_QRCODE = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s";

    // js ticket
    private static final String GET_JSAPI_TICKET = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    // 发送客服消息
    private static final String SEND_CUSTOM_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s";

    // 模板消息接口
    private static final String SEND_TEMPLATE_MESSAGE = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";

    // 统一下单
    private static final String PAY_UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 申请退款
    private static final String SECAPI_PAY_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    //发送现金红包
    private static final String SEND_RED_PACK = "https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";

    //小程序 code 换取 session_key
    private static final String JSCODE_2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    // 获取token接口
    public static String getTokenUrl(String appId, String appSecret) {
        return String.format(TOKEN, appId, appSecret);
    }

    // 获取上传Media接口
    public static String getUploadMediaUrl(String token, String type) {
        return String.format(UPLOAD_MEDIA, token, type);
    }

    /**
     * 获取下载Media接口
     *
     * @param token   token
     * @param mediaId 多媒体ID
     * @return
     */
    public static String getMediaUrl(String token, String mediaId) {
        return String.format(GET_MEDIA, token, mediaId);
    }

    /**
     * 获取下载Media接口
     *
     * @param mediaId 多媒体IID
     * @return
     */
    public static String getMediaUrl(String mediaId) {
        return String.format(GET_MEDIA, WxApiClient.getAccessToken(), mediaId);
    }

    // 获取菜单创建接口
    public static String getMenuCreateUrl(String token) {
        return String.format(MENU_CREATE, token);
    }

    // 获取菜单创建接口
    public static String getMenuGetUrl(String token) {
        return String.format(MENU_GET, token);
    }

    // 获取个性化菜单创建接口
    public static String getMenuAddconditionalUrl(String token) {
        return String.format(MENU_ADDCONDITIONAL, token);
    }

    // 获取菜单删除接口
    public static String getMenuDeleteUrl(String token) {
        return String.format(MENU_DELETE, token);
    }

    // 获取粉丝信息接口
    public static String getUserInfoUrl(String token, String openid) {
        return String.format(GET_USER_INFO, token, openid);
    }

    // 获取粉丝列表接口
    public static String getUserListUrl(String token, String nextOpenId) {
        if (nextOpenId == null) {
            return String.format(GET_USER_LIST, token);
        } else {
            return String.format(GET_USER_LIST + "&next_openid=%s", token, nextOpenId);
        }
    }

    // 获取素材列表接口
    public static String getBatchMaterialUrl(String token) {
        return String.format(GET_BATCH_MATERIAL, token);
    }

    // 获取上传图文消息接口
    public static String getUploadNewsUrl(String token) {
        return String.format(UPLOAD_NEWS, token);
    }

    // 群发接口
    public static String getMassSendUrl(String token) {
        return String.format(MASS_SEND, token);
    }

    // 网页授权OAuth2.0获取code
    public static String getOAuthCodeUrl(String appId, String redirectUrl, String scope, String state) {
        return String.format(GET_OAUTH_CODE, appId, EncodeUtils.urlEncode(redirectUrl), "code", scope, state);
    }

    // 网页授权OAuth2.0获取token
    public static String getOAuthTokenUrl(String appId, String appSecret, String code) {
        return String.format(GET_OAUTH_TOKEN, appId, appSecret, code);
    }

    // 网页授权OAuth2.0获取用户信息
    public static String getOAuthUserinfoUrl(String token, String openid) {
        return String.format(GET_OAUTH_USERINFO, token, openid);
    }

    // 获取创建二维码接口url
    public static String getCreateQrcodeUrl(String token) {
        return String.format(CREATE_QRCODE, token);
    }

    // 获取创建小程序二维码接口url
    public static String getWxaCodeUnlimit(String token) {
        return String.format(GET_WXA_CODE_UNLIMIT, token);
    }

    // 获取显示二维码接口
    public static String getShowQrcodeUrl(String ticket) {
        return String.format(SHOW_QRCODE, ticket);
    }

    // 获取js ticket url
    public static String getJsApiTicketUrl(String token) {
        return String.format(GET_JSAPI_TICKET, token);
    }

    // 获取发送客服消息 url
    public static String getSendCustomMessageUrl(String token) {
        return String.format(SEND_CUSTOM_MESSAGE, token);
    }

    // 获取发送模板消息 url
    public static String getSendTemplateMessageUrl(String token) {
        return String.format(SEND_TEMPLATE_MESSAGE, token);
    }

    /**
     * 获取微信支付统一下单地址
     *
     * @return
     */
    public static String getUnifiedOrderUrl() {
        return PAY_UNIFIED_ORDER_URL;
    }

    /**
     * 获取微信支付申请退款地址
     *
     * @return
     */
    public static String getSecapiPayRefundUrl() {
        return SECAPI_PAY_REFUND;
    }

    /**
     * 获取微信发送现金红包地址
     *
     * @return
     */
    public static String getSendRedPackUrl() {
        return SEND_RED_PACK;
    }

    /**
     * 获取code 换取 session_key地址
     *
     * @return
     */
    public static String getJscode2SessionUrl(String appId, String appSecret, String code) {
        return String.format(JSCODE_2_SESSION, appId, appSecret, code);
    }

    /**
     * 获取接口访问凭证
     *
     * @param appId     应用ID
     * @param appSecret 应用密码
     * @return
     */
    public static AccessToken getAccessToken(String appId, String appSecret) {
        String tockenUrl = WxApi.getTokenUrl(appId, appSecret);
        return HttpsClientUtils.doGet(AccessToken.class, tockenUrl);
    }

    /**
     * 获取 jsapi ticket
     *
     * @param token
     * @return
     */
    public static JsApiTicket getJsApiTicket(String token) {
        String jsTicketUrl = WxApi.getJsApiTicketUrl(token);
        return HttpsClientUtils.doGet(JsApiTicket.class, jsTicketUrl);
    }

    /**
     * 获取网页授权 oauth 2.0 access token
     *
     * @param appId
     * @param appSecret
     * @param code
     * @return
     */
    public static OAuthAccessToken getOAuthAccessToken(String appId, String appSecret, String code) {
        String tockenUrl = getOAuthTokenUrl(appId, appSecret, code);
        return HttpsClientUtils.doGet(OAuthAccessToken.class, tockenUrl);
    }

    /**
     * 上传多媒体文件 返回media_id
     */
    @SuppressWarnings("unchecked")
    public static String uploadMedia(String accessToken, String mediaType, String mediaUri) {
        String uploadMediaUrl = String.format(UPLOAD_MEDIA, accessToken, mediaType);
        String boundary = "----------" + System.currentTimeMillis();// 设置边界
        try {
            URL uploadUrl = new URL(uploadMediaUrl);
            HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
            uploadConn.setDoOutput(true);
            uploadConn.setDoInput(true);
            uploadConn.setRequestMethod("POST");
            // 设置请求头Content-Type
            uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            // 获取媒体文件上传的输出流（往微信服务器写数据）
            OutputStream outputStream = uploadConn.getOutputStream();

            URL mediaUrl = new URL(mediaUri);
            HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl.openConnection();
            meidaConn.setDoOutput(true);
            meidaConn.setRequestMethod("GET");

            // 从请求头中获取内容类型
            String contentType = meidaConn.getHeaderField("Content-Type");
            // 根据内容类型判断文件扩展名
            String fileExt = ".jpg";
            // 请求体开始
            outputStream.write(("--" + boundary + "\r\n").getBytes());
            outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
            outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

            // 获取媒体文件的输入流（读取文件）
            BufferedInputStream bis = new BufferedInputStream(meidaConn.getInputStream());
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1) {
                outputStream.write(buf, 0, size);
            }
            // 请求体结束
            outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
            outputStream.close();
            bis.close();
            meidaConn.disconnect();

            // 获取媒体文件上传的输入流（从微信服务器读数据）
            InputStream inputStream = uploadConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            uploadConn.disconnect();
            // 使用JSON-lib解析返回结果
            HashMap<String, Object> jsonObject = JsonMapper.parseObject(buffer.toString(), HashMap.class);
            if (jsonObject.containsKey("media_id"))
                return jsonObject.get("media_id").toString();
            return null;
        } catch (Exception e) {
            String error = String.format("上传媒体文件失败：%s", e);
            log.debug(error);
        }
        return null;
    }
}