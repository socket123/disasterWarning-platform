package com.yoxnet.hiddenPoints.dao;

import java.util.List;

import com.yoxnet.hiddenPoints.bean.HiddenPoints;
import com.yoxnet.hiddenPoints.bean.HiddenPointsExample;
import com.yoxnet.log.bean.Log;
import org.apache.ibatis.annotations.Param;

public interface HiddenPointsMapper {
    int countByExample(HiddenPointsExample example);

    int deleteByExample(HiddenPointsExample example);

    int deleteByPrimaryKey(String id);

    int insert(HiddenPoints record);
    int inserterster(Log record);

    int insertSelective(HiddenPoints record);

    List<HiddenPoints> selectByExample(HiddenPointsExample example);

    HiddenPoints selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") HiddenPoints record, @Param("example") HiddenPointsExample example);

    int updateByExample(@Param("record") HiddenPoints record, @Param("example") HiddenPointsExample example);

    int updateByPrimaryKeySelective(HiddenPoints record);

    int updateByPrimaryKey(HiddenPoints record);
}