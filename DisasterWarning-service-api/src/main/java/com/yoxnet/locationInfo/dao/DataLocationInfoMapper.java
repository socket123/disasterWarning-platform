package com.yoxnet.locationInfo.dao;

import com.yoxnet.locationInfo.bean.DataLocationInfo;
import com.yoxnet.locationInfo.bean.DataLocationInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataLocationInfoMapper {
    int countByExample(DataLocationInfoExample example);

    int deleteByExample(DataLocationInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(DataLocationInfo record);

    int insertSelective(DataLocationInfo record);

    List<DataLocationInfo> selectByExample(DataLocationInfoExample example);

    DataLocationInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DataLocationInfo record, @Param("example") DataLocationInfoExample example);

    int updateByExample(@Param("record") DataLocationInfo record, @Param("example") DataLocationInfoExample example);

    int updateByPrimaryKeySelective(DataLocationInfo record);

    int updateByPrimaryKey(DataLocationInfo record);
}