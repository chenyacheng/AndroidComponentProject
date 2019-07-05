package com.chenyacheng.commoblib.base;

/**
 * 服务端返回的数据格式
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public class BaseResponse {

    private String errCode;
    private String errMsg;
    private Object data;

    public String getStatusCode() {
        return errCode;
    }

    public String getStatusCodeMessage() {
        return errMsg;
    }

    public Object getData() {
        return data;
    }
}
