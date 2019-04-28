package com.moda.entity.weixin;

/**
 * 二维码请求信息
 */
public class WxQrcodeRequest extends BaseJsonRequest {
    private Integer expire_seconds;
    private String action_name;
    private ActionInfo action_info;

    public Integer getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(Integer expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public ActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(ActionInfo action_info) {
        this.action_info = action_info;
    }

    public static class ActionInfo {
        private Scene scene;

        public Scene getScene() {
            return scene;
        }

        public void setScene(Scene scene) {
            this.scene = scene;
        }
    }

    public static class Scene {
        private Integer scene_id;
        private String scene_str;

        public Integer getScene_id() {
            return scene_id;
        }

        public void setScene_id(Integer scene_id) {
            this.scene_id = scene_id;
        }

        public String getScene_str() {
            return scene_str;
        }

        public void setScene_str(String scene_str) {
            this.scene_str = scene_str;
        }
    }
}
