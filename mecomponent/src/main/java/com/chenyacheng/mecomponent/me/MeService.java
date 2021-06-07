package com.chenyacheng.mecomponent.me;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author chenyacheng
 * @date 2020/08/10
 */
public interface MeService {

    /**
     * 获取我的页数据
     *
     * @return BaseResponse
     */
    @GET("me")
    Observable<Object> getMeCall();
}
