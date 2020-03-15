package com.example.controller;

import com.example.pojo.Department;
import com.example.common.AjaxResponse;
import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public AjaxResponse addDepartment(@RequestBody @Valid Department department) {
        return AjaxResponse.success(departmentService.addDepartment(department));

    }

    @PostMapping("/updateDepartment")
    public AjaxResponse updateDepartment(@RequestBody @Valid Department department) {
        return AjaxResponse.success(departmentService.updateDepartment(department));
    }

}
