package com.hanergy.out.common;

/**
 * @description: 通用注解
 * @author: fangzhao
 * @create: 2020/3/24 13:09
 * @update: 2020/3/24 13:09
 */
public enum CommonEnum {

    /**
     * 操作返回状态定义
     */
    SUCCESS(200, "操作成功!"),
    FAIL(-1, "操作失败!"),
    REQUEST_ENTITY_NOT_NULL(3001, "请求对象不能为空"),
    ENTITY_NOT_EXIST(3002, "对象不存在"),
    BODY_NOT_MATCH(400,"请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401,"请求的数字签名不匹配!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    /**
     * 操作码
     */
    private int code;

    /**
     * 操作描述
     */
    private String msg;

    CommonEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
