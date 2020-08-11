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

    private String name;
    private String sex;
    private int age;
    private int score;
    private String mobile;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
