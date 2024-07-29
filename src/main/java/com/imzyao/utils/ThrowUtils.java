package com.imzyao.utils;

import com.imzyao.enums.ResponseCode;
import com.imzyao.exception.CustomException;

/**
 * @author yaomaozhong
 * @title: ThrowUtils
 * @description: TODO
 * @date 2023/3/1113:47
 */
public class ThrowUtils {


    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     */
    public static void throwIf(boolean condition, ResponseCode errorCode) {
        throwIf(condition, new CustomException(errorCode));
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     * @param message
     */
    public static void throwIf(boolean condition, ResponseCode errorCode, String message) {
        throwIf(condition, new CustomException(errorCode, message));
    }


}
