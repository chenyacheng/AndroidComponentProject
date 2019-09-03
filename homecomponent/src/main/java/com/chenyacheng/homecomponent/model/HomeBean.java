package com.chenyacheng.homecomponent.model;

/**
 * home的POJO model类
 *
 * @author chenyacheng
 * @date 2019/09/03
 */
public class HomeBean {

    /**
     * title : 首页数据
     * content : 世界因你而精彩
     */

    private String title;
    private String content;

    public String getTitle() {
        return title == null ? "" : title;
    }

    public String getContent() {
        return content == null ? "" : content;
    }
}
