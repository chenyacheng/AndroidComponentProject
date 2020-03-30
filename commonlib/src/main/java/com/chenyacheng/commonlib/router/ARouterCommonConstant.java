package com.chenyacheng.commonlib.router;

/**
 * 路由共用常量类，如登录模块，支付模块
 * 路由跳转命名统一用：path+模块名+Activity名
 *
 * @author chenyacheng
 * @date 2019/01/23
 */
public class ARouterCommonConstant {

    /**
     * 登录/注册
     */
    public static final String PATH_COMMON_LOGIN_OR_REGISTER_ACTIVITY = "/commonlib/LoginOrRegisterActivity";
    /**
     * web页面
     */
    public static final String PATH_COMMON_WEB_BROWSER_ACTIVITY = "/commonlib/WebViewActivity";
    /**
     * 查看地图页面
     */
    public static final String PATH_COMMON_ADDRESS_MAP_ACTIVITY = "/commonlib/AddressMapActivity";
    /**
     * 支付方式选择页面
     */
    public static final String PATH_COMMON_CHOOSE_PAY_METHOD_ACTIVITY = "/commonlib/ChoosePayMethodActivity";
    /**
     * 支付结果页面
     */
    public static final String PATH_COMMON_PAY_RESULT_ACTIVITY = "/commonlib/PayResultActivity";
    /**
     * 选择日期页面
     */
    public static final String PATH_COMMON_CHOOSE_DATE_ACTIVITY = "/commonlib/ChooseDateActivity";
    /**
     * 服务协议页面
     */
    public static final String PATH_COMMON_SERVICE_AGREEMENT_ACTIVITY = "/commonlib/ServiceAgreementActivity";
}
