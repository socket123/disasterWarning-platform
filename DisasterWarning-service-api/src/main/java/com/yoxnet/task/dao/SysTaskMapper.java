package com.yoxnet.task.dao;

import com.yoxnet.task.bean.SysTask;
import com.yoxnet.task.bean.SysTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTaskMapper {
    int countByExample(SysTaskExample example);

    int deleteByExample(SysTaskExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysTask record);

    int insertSelective(SysTask record);

    List<SysTask> selectByExample(SysTaskExample example);

    SysTask selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByExample(@Param("record") SysTask record, @Param("example") SysTaskExample example);

    int updateByPrimaryKeySelective(SysTask record);

    int updateByPrimaryKey(SysTask record);
}