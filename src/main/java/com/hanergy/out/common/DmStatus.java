package com.hanergy.out.common;

import java.text.MessageFormat;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public enum DmStatus {
    OK(HttpStatus.OK, "DM-200-00000", "数据返回正常"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "DM-400-A0001", "{0}"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DM-500-B0001", "后台服务异常，请联系管理员!"),
    SYS_RUNTIME_ERROR(HttpStatus.REQUEST_TIMEOUT, "DM-400-B0002", "系统运行时异常,请联系管理员!"),
    DATA_OPT_ERROR(HttpStatus.BAD_REQUEST, "DM-400-B0003", "数据操作异常！{0}"),
    TARGET_OBJ_EXCEPTION(HttpStatus.BAD_REQUEST, "DM-400-B0004", "目标对象异常！"),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, "DM-504-B0100", "网关超时【{0}】"),
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT, "DM-408-B0101", "系统请求超时【{0}】"),
    PARAM_IS_INVALID(HttpStatus.BAD_REQUEST, "DM-400-B0200", "请求参数异常错误！【{0}】"),
    CONSTRAINT_VIOLATION_ERROR(HttpStatus.BAD_REQUEST, "DM-400-B0201", "未绑定对象！【{0}】"),
    SERVLET_REQUEST_BINDING_ERROR(HttpStatus.BAD_REQUEST, "DM-400-B0202", "缺失必要参数！【{0}】"),
    HTTP_METHOD_NOT_ALLOW_ERROR(HttpStatus.METHOD_NOT_ALLOWED, "DM-405-B0203", "HTTP请求方法不被允许【{0}】"),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERROR(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "DM-415-B0203", "不支持的媒体类型"),
    MAX_UPLOAD_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "DM-400-B0300", "文件大小超出【{0}】限制, 请压缩或降低文件质量!！"),
    MAX_UPLOAD_TYPE_ERROR(HttpStatus.BAD_REQUEST, "DM-400-B0301", "文件上传类型错误！【{0}】"),
    THIRD_SERVER_ERROR(HttpStatus.BAD_REQUEST, "DM-400-C0001", "调用第三方服务出错"),
    MIDDLE_CALL_ERROR(HttpStatus.BAD_REQUEST, "DM-400-C0100", "中间服务调用出错"),
    MESSAGE_SEND_ERROR(HttpStatus.BAD_REQUEST, "DM-400-C0120", "消息发送失败");

    private static final Logger LOG = LoggerFactory.getLogger(DmStatus.class);
    private final String errorMessage;
    private final String errorCode;
    private final HttpStatus httpStatus;

    private DmStatus(HttpStatus httpStatus, String errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getFormattedErrorMessage(String... params) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(String.format("<== DmErrorCode.getMessage(%s)", Arrays.toString(params)));
        }

        MessageFormat mf = new MessageFormat(this.errorMessage);
        String result = mf.format(params);
        if (LOG.isDebugEnabled()) {
            LOG.debug(String.format("==> DmErrorCode.getMessage(%s): %s", Arrays.toString(params), result));
        }

        return result;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public static enum SysType {
        DM,
        MD,
        DSD,
        DQC,
        DLC,
        DMP,
        DSRT,
        DMA,
        DAL,
        DMPC,
        DQY,
        DIC,
        MG,
        DS;

        private SysType() {
        }
    }
}
