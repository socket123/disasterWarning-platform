package com.yoxnet.waterSystemHydrology.dao;

import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrology;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrologyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterSystemHydrologyMapper {
    int countByExample(WaterSystemHydrologyExample example);

    int deleteByExample(WaterSystemHydrologyExample example);

    int deleteByPrimaryKey(String id);

    int insert(WaterSystemHydrology record);

    int insertSelective(WaterSystemHydrology record);

    List<WaterSystemHydrology> selectByExample(WaterSystemHydrologyExample example);

    WaterSystemHydrology selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") WaterSystemHydrology record, @Param("example") WaterSystemHydrologyExample example);

    int updateByExample(@Param("record") WaterSystemHydrology record, @Param("example") WaterSystemHydrologyExample example);

    int updateByPrimaryKeySelective(WaterSystemHydrology record);

    int updateByPrimaryKey(WaterSystemHydrology record);
}