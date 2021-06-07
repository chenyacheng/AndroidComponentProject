package com.chenyacheng.findcomponent.api;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author chenyacheng
 * @date 2020/08/10
 */
public interface FindService {

    /**
     * 获取发现页数据
     *
     * @return BaseResponse
     */
    @GET("find")
    Observable<Object> getFindCall();
}
