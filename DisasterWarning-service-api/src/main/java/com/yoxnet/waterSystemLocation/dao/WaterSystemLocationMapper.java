package com.yoxnet.waterSystemLocation.dao;

import com.yoxnet.waterSystemLocation.bean.WaterSystemLocation;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterSystemLocationMapper {
    int countByExample(WaterSystemLocationExample example);

    int deleteByExample(WaterSystemLocationExample example);

    int deleteByPrimaryKey(String id);

    int insert(WaterSystemLocation record);

    int insertSelective(WaterSystemLocation record);

    List<WaterSystemLocation> selectByExample(WaterSystemLocationExample example);

    WaterSystemLocation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WaterSystemLocation record, @Param("example") WaterSystemLocationExample example);

    int updateByExample(@Param("record") WaterSystemLocation record, @Param("example") WaterSystemLocationExample example);

    int updateByPrimaryKeySelective(WaterSystemLocation record);

    int updateByPrimaryKey(WaterSystemLocation record);
}