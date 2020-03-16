package com.example.exception;

import com.example.common.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

//说明这是一个全局的异常处理类
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    //针对某种异常，处理之后返回
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public AjaxResponse myException(MyException e) {
        log.error("自定义异常");
        if (e.getCode() == MyExceptionType.USER_INPUT_ERROR.getCode()) {
            //400不需要持久化，通知用户即可
            //TODO 将500异常信息持久化，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    //针对参数异常处理
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse bindException(BindException e) {
        log.error("参数检验异常", e);
        List<String> defaultMsg = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        log.warn(defaultMsg.toString());
        return AjaxResponse.error(new MyException(MyExceptionType.USER_INPUT_ERROR, defaultMsg.toString()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public AjaxResponse constraintViolationException(ConstraintViolationException e) {
        log.error("单个参数检验异常", e);
        return AjaxResponse.error(new MyException(MyExceptionType.USER_INPUT_ERROR, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("检验异常");
        List<String> defaultMsg = e.getBindingResult().getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());
        return AjaxResponse.error(new MyException(MyExceptionType.USER_INPUT_ERROR, defaultMsg.toString()));
    }

    //捕获未知异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        //TODO 将异常信息持久化,方便运维人员处理
        //没有被程序员发现,并转化为MyException的异常，都是其他异常或者未知异常
        log.error(e.getMessage());
        return AjaxResponse.error(new MyException(MyExceptionType.OTHER_ERROR, "未知异常"));
    }

}
