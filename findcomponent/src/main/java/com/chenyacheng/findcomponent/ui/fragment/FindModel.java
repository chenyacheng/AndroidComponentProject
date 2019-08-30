package com.chenyacheng.findcomponent.ui.fragment;

/**
 * 发现页面的model
 *
 * @author chenyacheng
 * @date 2019/02/19
 */
class FindModel {

    /**
     * title : 发现页数据
     * content : 有一双发现美好事物的眼睛
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
