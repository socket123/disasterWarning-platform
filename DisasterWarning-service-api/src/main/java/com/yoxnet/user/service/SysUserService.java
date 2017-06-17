package com.yoxnet.user.service;


import java.util.List;
import java.util.Map;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.user.bean.User;

/**
 * @author 
 *
 */
public interface SysUserService {
	
	ServiceResult<Object> getByName(String name);
	
	/**
     * @api save 新增用户基本信息表
     * @apiGroup 用户基本信息表管理
     * @apiName  新增用户基本信息表记录
     * @apiDescription 全量插入用户基本信息表记录
     * @apiParam {User} User 用户基本信息表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (User User);
	
	/**
     * @api update 修改用户基本信息表
     * @apiGroup 用户基本信息表管理
     * @apiName  修改用户基本信息表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {User} User 用户基本信息表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(User User);
	
	/**
     * @api getById 根据用户基本信息表id查询详情
     * @apiGroup 用户基本信息表管理
     * @apiName  查询用户基本信息表详情
     * @apiDescription 根据主键id查询用户基本信息表详情
     * @apiParam {String} id 主键id
     * @apiSuccess User 用户基本信息表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public User getById(String id);
	
	/**
     * @api list 根据用户基本信息表条件查询列表
     * @apiGroup 用户基本信息表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam User User  实体条件
     * @apiSuccess List<User> 用户基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<User> list(User User);
	

	/**
     * @api list 根据用户基本信息表条件查询列表（含排序）
     * @apiGroup 用户基本信息表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam User} User  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<User> 用户基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<User> list(User User, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据用户基本信息表条件查询列表（分页）
     * @apiGroup 用户基本信息表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam User} User  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<User> 用户基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<User> findPageByParam(User User, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据用户基本信息表条件查询列表（分页，含排序）
     * @apiGroup 用户基本信息表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam User} User  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<User> 用户基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<User> findPageByParam(User User, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据用户基本信息表id删除
     * @apiGroup 用户基本信息表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

