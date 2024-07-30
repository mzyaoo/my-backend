package com.imzyao.exception;

import com.imzyao.enums.ResponseCode;
import com.imzyao.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 全局异常处理
 */
@Order(2)
@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {


    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Result<?> accessDeniedExceptionHandler(AccessDeniedException e) {
        return Result.fail(ResponseCode.NO_AUTH_ERROR);
    }


    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler({CustomException.class})
    public Result<?> businessExceptionHandler(CustomException e) {
        log.error("CustomException", e);
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * form-data 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result<?> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errorList = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        log.error("form-data 传参校验异常处理 -->", e);
        return Result.fail(ResponseCode.PARAMS_ERROR, errorList);
    }


    /**
     * json 参数校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errorList = fieldErrors.stream()
                .map(o -> o.getDefaultMessage())
                .collect(Collectors.toList());
        log.error("json 传参校验异常处理 -->", e);
        return Result.fail(ResponseCode.PARAMS_ERROR, errorList);
    }

    /**
     * 处理单个参数校验失败抛出的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        List<String> errorList = constraintViolations.stream()
                .map(o -> o.getMessage())
                .collect(Collectors.toList());
        log.error("单个参数校验异常处理 -->", e);
        return Result.fail(ResponseCode.PARAMS_ERROR, errorList);
    }

}
