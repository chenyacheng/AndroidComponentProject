package com.chenyacheng.mecomponent.ui.fragment;

/**
 * 我的页面的model
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
class MeModel {

    /**
     * title : 我的页数据
     * content : 有我才更加完美
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
