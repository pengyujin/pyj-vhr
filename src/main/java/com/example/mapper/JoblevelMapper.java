package com.example.mapper;

import com.example.pojo.Joblevel;
import com.example.pojo.JoblevelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JoblevelMapper {
    int countByExample(JoblevelExample example);

    int deleteByExample(JoblevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Joblevel record);

    int insertSelective(Joblevel record);

    List<Joblevel> selectByExample(JoblevelExample example);

    Joblevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByExample(@Param("record") Joblevel record, @Param("example") JoblevelExample example);

    int updateByPrimaryKeySelective(Joblevel record);

    int updateByPrimaryKey(Joblevel record);
}