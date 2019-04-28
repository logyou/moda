package com.moda.entity.weixin;

/**
 * 获取小程序码的请求参数
 *
 * @author lyh
 * @version 1.0 2018-8-13
 */
public class GetWxaCodeUnlimitRequest extends BaseJsonRequest {
    private String scene;
    private String page;
    private Integer width;
    private Boolean autoColor;
    private LineColor lineColor;
    private Boolean isHyaline;

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Boolean getAutoColor() {
        return autoColor;
    }

    public void setAutoColor(Boolean autoColor) {
        this.autoColor = autoColor;
    }

    public LineColor getLineColor() {
        return lineColor;
    }

    public void setLineColor(LineColor lineColor) {
        this.lineColor = lineColor;
    }

    public Boolean getHyaline() {
        return isHyaline;
    }

    public void setHyaline(Boolean hyaline) {
        isHyaline = hyaline;
    }

    public static class LineColor {

        private String r;
        private String g;
        private String b;

        public String getR() {
            return r;
        }

        public void setR(String r) {
            this.r = r;
        }

        public String getG() {
            return g;
        }

        public void setG(String g) {
            this.g = g;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
