package com.example.controller;

import com.example.pojo.Employee;
import com.example.common.AjaxResponse;
import com.example.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Api(tags = "员工管理相关接口")
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @ApiOperation("通过Id查询员工信息")
    @GetMapping("/findEmpByIdCard")
    public AjaxResponse findEmpByIdCard(@RequestParam String idCard) {

        return AjaxResponse.success(employeeService.findEmpByIdCard(idCard));

    }

    @ApiOperation("查询所有员工信息")
    @GetMapping("/findAllEmp")
    public AjaxResponse findAllEmp() {

        return AjaxResponse.success(employeeService.findAllEmp());

    }

    /**
     * 分页查询，整合pagehelper
     *
     * @param pageNum
     * @return
     */
//    @CrossOrigin  vue测试的时候需要跨域
    @GetMapping("getAllEmp")
    @ApiOperation("分页查询所有的员工")
    @ApiImplicitParam(name = "pageNum", value = "页数", defaultValue = "1", required = true)
    public PageInfo getAllEmp(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, 8);
        List<Employee> employees = employeeService.findAllEmp();
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);

        return pageInfo;
    }

    /**
     * 添加员工
     */
    @PostMapping("/addEmp")
    @ApiOperation("新增员工")
    public AjaxResponse addEmp(@RequestBody @Validated Employee employee) {

        return AjaxResponse.success(employeeService.addEmp(employee));

    }

    /**
     * http://localhost:8081/deleteEmp/1524
     *
     * @param id
     * @return
     */
    @ApiOperation("删除员工")
    @GetMapping("/deleteEmp/{id}")
    public AjaxResponse deleteEmp(@PathVariable("id") Integer id) {

        return AjaxResponse.success(employeeService.deleteEmp(id));

    }

    @ApiOperation("批量删除员工")
    @PostMapping("/batchDeteleEmp")
    public AjaxResponse batchDeleteEmp(@RequestBody Map map) {

        List<Integer> list = (List<Integer>) map.get("list");

        return AjaxResponse.success(employeeService.batchDeleteEmp(list));

    }

    @ApiOperation("更新员工信息")
    @PostMapping("/updateEmp")
    public AjaxResponse updateEmp(@RequestBody Employee employee) {

        return AjaxResponse.success(employeeService.updateEmp(employee));

    }

    /**
     * 测试通过部门ID查询员工
     */
    @ApiOperation("通过部门查询员工信息")
    @GetMapping("/findEmployeeByDepartmentId")
    public AjaxResponse findEmployeeByDepartmentId(@RequestParam Integer id) {
        return AjaxResponse.success(employeeService.findEmployeeByDepartmentId(id));
    }


}

