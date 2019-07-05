package com.chenyacheng.commoblib.api;

import com.chenyacheng.commoblib.base.BaseResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 网络请求接口
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public interface ApiService {

    /**
     * 获取验证码接口
     *
     * @param mobileNo   手机号码
     * @param sign       签名
     * @return BaseResponse
     */
    @POST("login/sendCaptcha")
    Observable<BaseResponse> getCaptchaCall(@Query("mobileNo") String mobileNo, @Query("sign") String sign);

    /**
     * 登录接口
     *
     * @param map  封装的map
     * @param sign 签名
     * @return BaseResponse
     */
    @POST("login/login")
    Observable<BaseResponse> getLoginCall(@QueryMap Map<String, String> map, @Query("sign") String sign);
}
