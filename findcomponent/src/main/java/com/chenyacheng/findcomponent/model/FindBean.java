package com.chenyacheng.findcomponent.model;

/**
 * find的POJO model类
 *
 * @author chenyacheng
 * @date 2019/09/04
 */
public class FindBean {

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
