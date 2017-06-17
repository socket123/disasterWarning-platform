package com.yoxnet.role.service;


import java.util.List;
import java.util.Map;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.role.bean.SysRole;

/**
 * @author 
 *
 */
public interface SysRoleService {
	
	
	public ServiceResult<Object> getByName(String name);
	
	/**
     * @api save 新增用户权限表
     * @apiGroup 用户权限表管理
     * @apiName  新增用户权限表记录
     * @apiDescription 全量插入用户权限表记录
     * @apiParam {SysRole} sysRole 用户权限表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (SysRole sysRole);
	
	/**
     * @api update 修改用户权限表
     * @apiGroup 用户权限表管理
     * @apiName  修改用户权限表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {SysRole} sysRole 用户权限表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(SysRole sysRole);
	
	/**
     * @api getById 根据用户权限表id查询详情
     * @apiGroup 用户权限表管理
     * @apiName  查询用户权限表详情
     * @apiDescription 根据主键id查询用户权限表详情
     * @apiParam {String} id 主键id
     * @apiSuccess SysRole 用户权限表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public SysRole getById(String id);
	
	/**
     * @api list 根据用户权限表条件查询列表
     * @apiGroup 用户权限表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam SysRole sysRole  实体条件
     * @apiSuccess List<SysRole> 用户权限表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<SysRole> list(SysRole sysRole);
	

	/**
     * @api list 根据用户权限表条件查询列表（含排序）
     * @apiGroup 用户权限表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam SysRole} sysRole  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<SysRole> 用户权限表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<SysRole> list(SysRole sysRole, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据用户权限表条件查询列表（分页）
     * @apiGroup 用户权限表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam SysRole} sysRole  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<SysRole> 用户权限表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<SysRole> findPageByParam(SysRole sysRole, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据用户权限表条件查询列表（分页，含排序）
     * @apiGroup 用户权限表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam SysRole} sysRole  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<SysRole> 用户权限表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<SysRole> findPageByParam(SysRole sysRole, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据用户权限表id删除
     * @apiGroup 用户权限表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);
	
	
	/**
	 * 
	* @Description: 根据任务名称查询相关角色
	* @param taskName
	* @return
	* @author: Storydo
	* @date: 2017年3月30日 下午4:49:19
	 */
	public List<SysRole> findSysRoleByTaskName(String taskName);
	

}

