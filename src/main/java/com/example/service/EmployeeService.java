package com.example.service;

import com.example.pojo.Employee;

import javax.swing.*;
import java.util.List;

public interface EmployeeService {
    List<Employee> findEmpByIdCard(String idCard);

    List<Employee> findAllEmp();

    int addEmp(Employee employee);

    int deleteEmp(Integer id);

    int updateEmp(Employee employee);

    int batchDeleteEmp(List<Integer> list);

    List<Employee> findEmployeeByDepartmentId(Integer id);
}
