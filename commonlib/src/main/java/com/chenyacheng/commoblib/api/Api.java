package com.chenyacheng.commoblib.api;

import com.chenyacheng.commoblib.app.AppConfig;
import com.chenyacheng.commoblib.base.BaseApi;

/**
 * api请求配置
 *
 * @author chenyacheng
 * @date 2019/01/21
 */
public class Api {

    private volatile static ApiService apiService;

    private Api() {
        String baseUrl = AppConfig.BASE_URL;
        BaseApi baseApi = new BaseApi();
        apiService = baseApi.getRetrofit(baseUrl).create(ApiService.class);
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (Api.class) {
                if (apiService == null) {
                    new Api();
                }
            }
        }
        return apiService;
    }
}
