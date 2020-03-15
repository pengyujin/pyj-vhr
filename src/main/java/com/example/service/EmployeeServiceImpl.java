package com.example.service;

import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import com.example.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> findEmpByIdCard(String idCard) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdcardEqualTo(idCard);
        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public List<Employee> findAllEmp() {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIsNotNull();
        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public int addEmp(Employee employee) {

        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdcardEqualTo(employee.getIdcard());
        List<Employee> employees = employeeMapper.selectByExample(employeeExample);
        if (employees.size() == 0) {
            return employeeMapper.insert(employee);
        }
        return -1;
    }

    @Override
    public int deleteEmp(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int batchDeleteEmp(List<Integer> list) {

        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andIdIn(list);
        return employeeMapper.deleteByExample(employeeExample);
    }

    @Override
    public List<Employee> findEmployeeByDepartmentId(Integer id) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andDepartmentidEqualTo(id);
        return employeeMapper.selectByExample(employeeExample);
    }

    @Override
    public int updateEmp(Employee employee) {
        return employeeMapper.updateByPrimaryKey(employee);
    }
}
