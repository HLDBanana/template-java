package com.hanergy.out.config;


import com.hanergy.out.common.CommonEnum;
import lombok.Data;

/**
 * @description: 异常
 * @author: fangzhao
 * @create: 2020/3/24 13:09
 * @update: 2020/3/24 13:09
 */
@Data
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 描述：错误码
     */
    private int errorCode;

    /**
     * 描述：错误信息
     */
    private String errorMsg;

    public BizException() {
    }

    public BizException(CommonEnum commonEnum) {
        super(String.valueOf(commonEnum.getCode()));
        this.errorCode = commonEnum.getCode();
        this.errorMsg = commonEnum.getMsg();
    }

    public BizException(CommonEnum commonEnum, Throwable cause) {
        super(String.valueOf(commonEnum.getCode()), cause);
        this.errorCode = commonEnum.getCode();
        this.errorMsg = commonEnum.getMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
