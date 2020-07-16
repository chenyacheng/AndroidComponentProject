package com.chenyacheng.commonuilib.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 网络请求接口
 *
 * @author chenyacheng
 * @date 2020/07/06
 */
public interface ApiService {

    /**
     * 获取首页数据
     *
     * @return BaseResponse
     */
    @GET("test/get")
    Observable<Object> getHomeCall();

    /**
     * 获取发现页数据
     *
     * @return BaseResponse
     */
    @GET("find")
    Observable<Object> getFindCall();

    /**
     * 获取我的页数据
     *
     * @return BaseResponse
     */
    @GET("me")
    Observable<Object> getMeCall();
}
