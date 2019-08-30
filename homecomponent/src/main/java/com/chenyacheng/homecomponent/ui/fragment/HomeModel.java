package com.chenyacheng.homecomponent.ui.fragment;

/**
 * 首页页面的model
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
class HomeModel {

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
