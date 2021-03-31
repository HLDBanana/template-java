package com.hanergy.out.common;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.Serializable;
@Data
@ApiModel("Http结果响应")
public class HttpResult<T> implements Serializable {

    private static String successMessage = "操作成功";

    private static String errorMessage = "操作失败";

    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应数据")
    private T data;

    @ApiModelProperty("响应消息")
    private String msg;

    public HttpResult(){ }

    public HttpResult(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public HttpResult(int code, String msg, T data) {
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static HttpResult successResult() {
        return new HttpResult(HttpStatus.OK.value(), successMessage);
    }

    public static HttpResult successResult(String msg) {
        return new HttpResult(DmStatus.OK.getHttpStatus().value(), defaultSuccessMsg(msg));
    }

    public static HttpResult successResult(Object obj) {
        return new HttpResult(DmStatus.OK.getHttpStatus().value(), successMessage, obj);
    }

    public static HttpResult successResult(String msg, Object obj) {
        return new HttpResult(DmStatus.OK.getHttpStatus().value(), defaultSuccessMsg(msg), obj);
    }

    public static HttpResult failureResult() {
        return new HttpResult(DmStatus.INTERNAL_ERROR.getHttpStatus().value(), errorMessage);
    }

    public static HttpResult failureResult(String msg) {
        return new HttpResult(DmStatus.INTERNAL_ERROR.getHttpStatus().value(), defautlErrorMsg(msg));
    }

    public static HttpResult failureResult(Integer code, String msg) {
        return new HttpResult(code, defautlErrorMsg(msg));
    }

    public static HttpResult failureResult(String msg, Object obj) {
        return new HttpResult(DmStatus.INTERNAL_ERROR.getHttpStatus().value(), defaultSuccessMsg(msg), obj);
    }

    private static String defautlErrorMsg(String msg) {
        return StringUtils.isEmpty(msg)?errorMessage:msg;

    }

    private static String defaultSuccessMsg(String msg) {
        return StringUtils.isEmpty(msg)?successMessage:msg;
    }
}