package com.yoxnet.hedgeMeasures.dao;

import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasures;
import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasuresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataHedgeMeasuresMapper {
    int countByExample(DataHedgeMeasuresExample example);

    int deleteByExample(DataHedgeMeasuresExample example);

    int deleteByPrimaryKey(String id);

    int insert(DataHedgeMeasures record);

    int insertSelective(DataHedgeMeasures record);

    List<DataHedgeMeasures> selectByExample(DataHedgeMeasuresExample example);

    DataHedgeMeasures selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DataHedgeMeasures record, @Param("example") DataHedgeMeasuresExample example);

    int updateByExample(@Param("record") DataHedgeMeasures record, @Param("example") DataHedgeMeasuresExample example);

    int updateByPrimaryKeySelective(DataHedgeMeasures record);

    int updateByPrimaryKey(DataHedgeMeasures record);
}