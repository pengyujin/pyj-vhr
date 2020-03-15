package com.example.service;

import com.example.mapper.HrMapper;
import com.example.mapper.HrRoleMapper;
import com.example.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private HrService hrService;

    @Autowired
    private HrRoleMapper hrRoleMapper;

    @Override
    public Hr getByUsername(String username) {
        HrExample hrExample = new HrExample();
        hrExample.createCriteria().andUsernameEqualTo(username);
        List<Hr> list = hrMapper.selectByExample(hrExample);
        if (list == null) {
            return null;
        } else {
            return list.get(0);
        }
    }

    @Override
    public void addHr(Hr hr) {
        hrMapper.insert(hr);
    }

    @Override
    public List<Role> getRoleListByUsername(String username) {
        return hrMapper.getRoleListByUsername(username);
    }
}
