package com.yoxnet.pointDisaster.dao;

import com.yoxnet.pointDisaster.bean.PointDisaster;
import com.yoxnet.pointDisaster.bean.PointDisasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PointDisasterMapper {
    int countByExample(PointDisasterExample example);

    int deleteByExample(PointDisasterExample example);

    int deleteByPrimaryKey(String id);

    int insert(PointDisaster record);

    int insertSelective(PointDisaster record);

    List<PointDisaster> selectByExample(PointDisasterExample example);

    PointDisaster selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PointDisaster record, @Param("example") PointDisasterExample example);

    int updateByExample(@Param("record") PointDisaster record, @Param("example") PointDisasterExample example);

    int updateByPrimaryKeySelective(PointDisaster record);

    int updateByPrimaryKey(PointDisaster record);
}