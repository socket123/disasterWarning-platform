package com.yoxnet.waterSystemInfo.dao;

import com.yoxnet.waterSystemInfo.bean.WaterSystemInfo;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterSystemInfoMapper {
    int countByExample(WaterSystemInfoExample example);

    int deleteByExample(WaterSystemInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WaterSystemInfo record);

    int insertSelective(WaterSystemInfo record);

    List<WaterSystemInfo> selectByExample(WaterSystemInfoExample example);

    WaterSystemInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WaterSystemInfo record, @Param("example") WaterSystemInfoExample example);

    int updateByExample(@Param("record") WaterSystemInfo record, @Param("example") WaterSystemInfoExample example);

    int updateByPrimaryKeySelective(WaterSystemInfo record);

    int updateByPrimaryKey(WaterSystemInfo record);
}