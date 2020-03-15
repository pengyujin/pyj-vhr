package com.example.service;

import com.example.pojo.Hr;
import com.example.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HrService {

    Hr getByUsername(String username);

    void addHr(Hr hr);

    List<Role> getRoleListByUsername(String username);
}
