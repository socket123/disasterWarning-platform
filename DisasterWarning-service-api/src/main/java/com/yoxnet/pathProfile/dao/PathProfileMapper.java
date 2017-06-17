package com.yoxnet.pathProfile.dao;

import com.yoxnet.pathProfile.bean.PathProfile;
import com.yoxnet.pathProfile.bean.PathProfileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PathProfileMapper {
    int countByExample(PathProfileExample example);

    int deleteByExample(PathProfileExample example);

    int deleteByPrimaryKey(String id);

    int insert(PathProfile record);

    int insertSelective(PathProfile record);

    List<PathProfile> selectByExample(PathProfileExample example);

    PathProfile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PathProfile record, @Param("example") PathProfileExample example);

    int updateByExample(@Param("record") PathProfile record, @Param("example") PathProfileExample example);

    int updateByPrimaryKeySelective(PathProfile record);

    int updateByPrimaryKey(PathProfile record);
}