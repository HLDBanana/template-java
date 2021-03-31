package com.hanergy.out.config;

import com.hanergy.out.common.DmStatus;
import com.hanergy.out.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolationException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 统一异常处理
 * @author: fangzhao
 * @create: 2020/3/24 13:09
 * @update: 2020/3/24 13:09
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 统一的异常封装
     * @param exception DmBizException
     * @return 返回消息
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResult<Object> sendErrorResponse(Exception exception){
        log.error("后台服务异常: {}", getStackTrace(exception));
        return HttpResult.failureResult(DmStatus.INTERNAL_ERROR.getHttpStatus().value(),exception.getLocalizedMessage());
    }

    /**
     * 系统运行时异常
     * @param exception RuntimeException
     * @return 返回消息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResult<Object> sendErrorResponse(RuntimeException exception){
        log.error("系统运行时异常: {}", getStackTrace(exception));
        return HttpResult.failureResult(DmStatus.SYS_RUNTIME_ERROR.getHttpStatus().value(),exception.getLocalizedMessage());
    }
    /**
     * 单个参数校验（没有绑定对象）
     * @param e ConstraintViolationException
     * @return 返回的信息
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResult<Object> otherValidException(ConstraintViolationException e) {
        log.error("参数校验异常: {}", getStackTrace(e));
        return HttpResult.failureResult(DmStatus.CONSTRAINT_VIOLATION_ERROR.getHttpStatus().value(),e.getLocalizedMessage());
    }
    /**
     * 必填参数缺失
     * @param e ServletRequestBindingException
     * @return 返回的信息
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResult<Object> servletRequestBinding(ServletRequestBindingException e) {
        log.error("必填参数缺失异常: {}", getStackTrace(e));
        return HttpResult.failureResult(DmStatus.SERVLET_REQUEST_BINDING_ERROR.getHttpStatus().value(),e.getLocalizedMessage());
    }

    /**
     * 参数错误异常
     * @param e 异常参数
     * @return 返回的信息
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HttpResult<Object> handleException(Exception e) {
        StringBuilder errorMsg = new StringBuilder();
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            BindingResult result = validException.getBindingResult();
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                errors.forEach(p ->{
                    FieldError fieldError = (FieldError) p;
                    errorMsg.append(fieldError.getDefaultMessage()).append(",");
                });
            }
        } else if (e instanceof BindException) {
            BindException bindException = (BindException)e;
            if (bindException.hasErrors()) {
                log.error("请求参数错误: {}", bindException.getAllErrors());
                errorMsg.append(bindException.getAllErrors());
            }
        }
        log.error("参数校验异常: {}", getStackTrace(e));
        return HttpResult.failureResult(DmStatus.PARAM_IS_INVALID.getHttpStatus().value(),errorMsg.toString());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public HttpResult<Object> sendErrorResponse(HttpRequestMethodNotSupportedException exception){
        log.error("http方法不允许: {}", getStackTrace(exception));
        return HttpResult.failureResult(DmStatus.HTTP_METHOD_NOT_ALLOW_ERROR.getHttpStatus().value(), Arrays.toString(exception.getSupportedMethods()));
    }
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public HttpResult<Object> sendErrorResponse(HttpMediaTypeNotSupportedException exception){
        return HttpResult.failureResult(DmStatus.HTTP_MEDIA_TYPE_NOT_SUPPORTED_ERROR.getHttpStatus().value(),exception.getLocalizedMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HttpResult<Object> sendErrorResponse(MaxUploadSizeExceededException exception){
        return HttpResult.failureResult(DmStatus.MAX_UPLOAD_SIZE_EXCEEDED.getHttpStatus().value(),exception.getLocalizedMessage());
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
