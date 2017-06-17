package com.yoxnet.linearPoints.dao;

import com.yoxnet.linearPoints.bean.LinearPoints;
import com.yoxnet.linearPoints.bean.LinearPointsExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LinearPointsMapper {
    int countByExample(LinearPointsExample example);

    int deleteByExample(LinearPointsExample example);

    int deleteByPrimaryKey(String id);

    int insert(LinearPoints record);

    int insertSelective(LinearPoints record);

    List<LinearPoints> selectByExample(LinearPointsExample example);

    LinearPoints selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LinearPoints record, @Param("example") LinearPointsExample example);

    int updateByExample(@Param("record") LinearPoints record, @Param("example") LinearPointsExample example);

    int updateByPrimaryKeySelective(LinearPoints record);

    int updateByPrimaryKey(LinearPoints record);
}