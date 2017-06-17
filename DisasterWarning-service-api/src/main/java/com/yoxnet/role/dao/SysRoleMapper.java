package com.yoxnet.role.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yoxnet.role.bean.SysRole;
import com.yoxnet.role.bean.SysRoleExample;

public interface SysRoleMapper {
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    
//    List<Map<String, Object>>  validTaskRoleList(@Param("time")String time);
    
}