package com.chenyacheng.commonlib.api;

import com.chenyacheng.commonlib.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求接口
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public interface ApiService {

    /**
     * 获取首页数据
     *
     * @return BaseResponse
     */
    @GET("home")
    Observable<BaseResponse> getHomeCall();

    /**
     * 获取发现页数据
     *
     * @return BaseResponse
     */
    @GET("find")
    Observable<BaseResponse> getFindCall();

    /**
     * 获取我的页数据
     *
     * @return BaseResponse
     */
    @GET("me")
    Observable<BaseResponse> getMeCall();
}
