package com.example.exception;

import lombok.Getter;

public enum MyExceptionType {

    USER_INPUT_ERROR(400, "用户输入异常"),

    SYSTEM_ERROR(500, "系统服务异常"),
        
    OTHER_ERROR(999, "其他未知异常");

    MyExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    @Getter
    private int code;

    @Getter
    private String typeDesc;


}
