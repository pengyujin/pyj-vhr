package com.example.exception;

import lombok.Getter;

//自定义异常
public class MyException extends RuntimeException {

    //异常错误码
    @Getter
    private int code;

    //异常信息
    @Getter
    private String message;

    private MyException() {
    }

    ;

    public MyException(MyExceptionType exceptionType, String message) {
        this.code = exceptionType.getCode();
        this.message = message;
    }


}
