package com.hanergy.out.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("返回结果")
public class RetResult<T> implements Serializable {
    private static final long serialVersionUID = 7424094087156251104L;
    @ApiModelProperty("响应代码")
    private int code;
    @ApiModelProperty("响应消息")
    private String message;
    @ApiModelProperty("响应数据")
    private T data;

    public RetResult() {
    }

    public RetResult(DmStatus dmStatus, String... params) {
        this.code = dmStatus.getHttpStatus().value();
        this.message = dmStatus.getFormattedErrorMessage(params);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "RetResult{code=" + this.code + ", message='" + this.message + "', data=" + this.data + "}";
    }
}
