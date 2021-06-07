package com.chenyacheng.mecomponent.model;

/**
 * me的POJO model类
 *
 * @author chenyacheng
 * @date 2019/09/04
 */
public class MeBean {

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
