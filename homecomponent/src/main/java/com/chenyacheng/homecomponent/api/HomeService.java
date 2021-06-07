package com.chenyacheng.homecomponent.api;

import com.chenyacheng.homecomponent.model.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author chenyacheng
 * @date 2020/07/20
 */
public interface HomeService {

    /**
     * 获取首页数据
     *
     * @param homeBean 对象
     * @return BaseResponse
     */
    @POST("test/post")
    Observable<Object> getHomeCall(@Body HomeBean homeBean);
}
