package com.example.mapper;

import com.example.pojo.Empsalary;
import com.example.pojo.EmpsalaryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpsalaryMapper {
    int countByExample(EmpsalaryExample example);

    int deleteByExample(EmpsalaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Empsalary record);

    int insertSelective(Empsalary record);

    List<Empsalary> selectByExample(EmpsalaryExample example);

    Empsalary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Empsalary record, @Param("example") EmpsalaryExample example);

    int updateByExample(@Param("record") Empsalary record, @Param("example") EmpsalaryExample example);

    int updateByPrimaryKeySelective(Empsalary record);

    int updateByPrimaryKey(Empsalary record);
}