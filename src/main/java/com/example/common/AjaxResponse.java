package com.example.common;

import com.example.exception.MyException;
import com.example.exception.MyExceptionType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Data 标签，生成getter/setter toString()等方法
 * @NonNull : 让你不在担忧并且爱上NullPointerException
 * @CleanUp : 自动资源管理：不用再在finally中添加资源的close方法
 * @Setter/@Getter : 自动生成set和get方法
 * @ToString : 自动生成toString方法
 * @EqualsAndHashcode : 从对象的字段中生成hashCode和equals的实现
 * @NoArgsConstructor/@RequiredArgsConstructor/@AllArgsConstructor 自动生成构造方法
 * @Data : 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法
 * @Value : 用于注解final类
 * @Builder : 产生复杂的构建器api类
 * @SneakyThrows : 异常处理（谨慎使用）
 * @Synchronized : 同步方法安全的转化
 * @Getter(lazy=true) :
 * @Log : 支持各种logger对象，使用时用对应的注解，如：@Log4j
 */
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class AjaxResponse {

    private boolean isok;
    private Integer status;
    private String message;
    private Object data;

    private AjaxResponse() {
    }

    public static AjaxResponse build() {
        return new AjaxResponse();
    }

    public static AjaxResponse success() {
        return new AjaxResponse(true, 200, "success", null);
    }

    public static AjaxResponse success(Object data) {
        return new AjaxResponse(true, 200, "success", data);
    }

    //请求异常信息
    public static AjaxResponse error(MyException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setStatus(e.getCode());
        if (e.getCode() == MyExceptionType.USER_INPUT_ERROR.getCode()) {
            resultBean.setMessage(e.getMessage());
        } else {
            if (e.getCode() == MyExceptionType.SYSTEM_ERROR.getCode()) {
                resultBean.setMessage(e.getMessage() + ",系统出现异常,请联系管理员953808847进行处理");
            } else {
                resultBean.setMessage("系统出现未知异常,请联系管理员953808847进行处理");
            }
        }
        return resultBean;
    }


}
