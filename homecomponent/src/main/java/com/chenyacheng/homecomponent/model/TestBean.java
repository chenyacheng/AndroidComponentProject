package com.chenyacheng.homecomponent.model;

/**
 * @author Administrator
 * @date 2019/09/09
 */
public class TestBean {

    private static boolean receive = false;

    public static boolean isReceive() {
        return receive;
    }

    public static void setReceive(boolean receive) {
        TestBean.receive = receive;
    }
}
