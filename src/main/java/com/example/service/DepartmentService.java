package com.example.service;

import com.example.pojo.Department;
import com.example.pojo.Employee;

import java.util.List;
import java.util.Set;

public interface DepartmentService {

    int addDepartment(Department department);

    int deleteDepartment(Integer id);

    int updateDepartment(Department department);

    List<Employee> findEmployeeByDepartmentId(Integer id);
}
