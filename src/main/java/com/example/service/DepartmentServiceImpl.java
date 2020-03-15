package com.example.service;

import com.example.mapper.DepartmentMapper;
import com.example.mapper.EmployeeMapper;
import com.example.pojo.Department;
import com.example.pojo.Employee;
import com.example.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    private EmployeeMapper employeeMapper;

    @Override
    public int addDepartment(Department department) {
        return departmentMapper.insert(department);

    }

    @Override
    public int deleteDepartment(Integer id) {
        return 0;
    }

    @Override
    public int updateDepartment(Department department) {
        return 0;
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andDepartmentidEqualTo(id);
        return employeeMapper.selectByExample(employeeExample);
    }
}
