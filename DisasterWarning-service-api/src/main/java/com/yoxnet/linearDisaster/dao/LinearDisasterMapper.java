package com.yoxnet.linearDisaster.dao;

import com.yoxnet.linearDisaster.bean.LinearDisaster;
import com.yoxnet.linearDisaster.bean.LinearDisasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LinearDisasterMapper {
    int countByExample(LinearDisasterExample example);

    int deleteByExample(LinearDisasterExample example);

    int deleteByPrimaryKey(String id);

    int insert(LinearDisaster record);

    int insertSelective(LinearDisaster record);

    List<LinearDisaster> selectByExample(LinearDisasterExample example);

    LinearDisaster selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LinearDisaster record, @Param("example") LinearDisasterExample example);

    int updateByExample(@Param("record") LinearDisaster record, @Param("example") LinearDisasterExample example);

    int updateByPrimaryKeySelective(LinearDisaster record);

    int updateByPrimaryKey(LinearDisaster record);
}