package com.example.mapper;

import com.example.pojo.Employeetrain;
import com.example.pojo.EmployeetrainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeetrainMapper {
    int countByExample(EmployeetrainExample example);

    int deleteByExample(EmployeetrainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Employeetrain record);

    int insertSelective(Employeetrain record);

    List<Employeetrain> selectByExample(EmployeetrainExample example);

    Employeetrain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Employeetrain record, @Param("example") EmployeetrainExample example);

    int updateByExample(@Param("record") Employeetrain record, @Param("example") EmployeetrainExample example);

    int updateByPrimaryKeySelective(Employeetrain record);

    int updateByPrimaryKey(Employeetrain record);
}