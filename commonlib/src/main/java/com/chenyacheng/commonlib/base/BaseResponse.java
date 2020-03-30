package com.chenyacheng.commonlib.base;

/**
 * 服务端返回的数据格式
 *
 * @author chenyacheng
 * @date 2019/01/17
 */
public class BaseResponse {

    private String statusCode;
    private String msg;
    private Object data;

    public String getCode() {
        return statusCode;
    }

    public String getMessage() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
