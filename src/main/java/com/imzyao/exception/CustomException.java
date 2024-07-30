package com.imzyao.exception;


import com.imzyao.enums.ResponseCode;
import lombok.Getter;

/**
 * @author yaomaozhong
 * @title: CustomException
 * @description: TODO
 * @date 2023/3/1113:46
 */
@Getter
public class CustomException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public CustomException(int code, String message) {
        super(message);
        this.code = code;
    }

    public CustomException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public CustomException(ResponseCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }


}
