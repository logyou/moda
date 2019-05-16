package com.moda.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.moda.entity.rest.Result;
import com.moda.util.http.HttpClientUtils;
import com.moda.util.mapper.JsonMapper;
import com.moda.web.spring.boot.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller
 *
 * @author lyh
 * @date 2019-5-14
 **/
@RestController
@Api(tags = "警报", description = "系统警报通知")
@RequestMapping(value = "/alert/")
public class AlertController extends BaseController {

    @RequestMapping(value = "send")
    public Result alert(HttpServletRequest request, @RequestBody(required = false) String json) throws IOException {
        logger.info(JsonMapper.toJsonStringIndent(request.getParameterMap()));
        JSONObject jsonObject = JsonMapper.parseObject(json, JSONObject.class);
        logger.info(JsonMapper.toJsonStringIndent(jsonObject));
        test(jsonObject);
        return success("OK");
    }

    public void test(JSONObject obj) throws IOException {
        List<String> firingList = new ArrayList<>();
        List<String> resolvedList = new ArrayList<>();
        JSONArray alerts = obj.getJSONArray("alerts");
        StringBuilder content;
        for (int i = 0; i < alerts.size(); i++) {
            JSONObject a = alerts.getJSONObject(i);
            content = new StringBuilder();
            content.append(a.getJSONObject("labels").getString("exported_application"))
                    .append("→")
                    .append(a.getJSONObject("labels").getString("exported_instance"));
            switch (a.getString("status")) {
                case "firing":
                    firingList.add(content.toString());
                    break;
                case "resolved":
                    resolvedList.add(content.toString());
                    break;
                default:
                    logger.info("unknown");
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("### 服务报警\n");
        sb.append("![](http://devkeep.com/img/p4.jpg)\n");
        if (firingList.size() > 0) {
            sb.append("#### 以下服务已离线\n");
            firingList.forEach(a -> sb.append("> ").append("- ").append(a).append("\n"));
        }
        if (resolvedList.size() > 0) {
            sb.append("#### 以下服务已恢复\n");
            resolvedList.forEach(a -> sb.append("> ").append("- ").append(a).append("\n"));
        }

        Map<String, Object> markdown = new HashMap<>(2);
        markdown.put("title", "服务报警");
        markdown.put("text", sb.toString());

        Map<String, Object> msg = new HashMap<>(2);
        msg.put("msgtype", "markdown");
        msg.put("markdown", markdown);

        String url = "https://oapi.dingtalk.com/robot/send?access_token=52e917ba69e83399539dce0d67d28bc83332426408f847c1e2e4ad3fc0485cae";
        HttpClientUtils.postAsJson(url, msg);
        logger.info(JsonMapper.toJsonStringIndent(msg));
    }
}
