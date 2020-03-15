package com.example.controller;

import com.example.common.AjaxResponse;
import com.example.exception.MyException;
import com.example.exception.MyExceptionType;
import com.example.pojo.Employee;
import com.example.pojo.Hr;
import com.example.service.EmployeeService;
import com.example.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ExecutorService executorService;


//    @Value("${spring.mail.username}")
//    private String fromAddress;


    @RequestMapping(value = "/addHr", method = RequestMethod.POST)
    public void addHr(@RequestBody Hr hr) {
        System.out.println(hr);
        hrService.addHr(hr);
    }

    @PostMapping("/addEmployee")
    public AjaxResponse addEmployee(@RequestBody Employee employee) {

        if (employeeService.addEmp(employee) == -1) {
            throw new MyException(MyExceptionType.USER_INPUT_ERROR, "添加失败");
        }
        //发送邮件通知,这里的邮件模板应从数据库根据具体业务去获取，可以考虑封装在service
//        executorService.execute(new EmailRunnable(employee,javaMailSender,fromAddress,"默认主体","默认内容"));
        return AjaxResponse.success();
    }

}
