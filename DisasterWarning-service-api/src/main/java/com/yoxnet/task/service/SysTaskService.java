package com.yoxnet.task.service;

import java.util.List;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.task.bean.SysTask;

/**
 * @author 
 *
 */
public interface SysTaskService {
	
	public ServiceResult<Object> getByName(String name);
	
	/**
     * @api getTaskList 根据时间，用户名获取任务
     */
	public ServiceResult<Object> getTaskList(String name,String time);
	
	/**
     * @api save 新增任务基本信息表
     * @apiGroup 任务基本信息表管理
     * @apiName  新增任务基本信息表记录
     * @apiDescription 全量插入任务基本信息表记录
     * @apiParam {SysTask} sysTask 任务基本信息表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (SysTask sysTask);
	
	/**
     * @api update 修改任务基本信息表
     * @apiGroup 任务基本信息表管理
     * @apiName  修改任务基本信息表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {SysTask} sysTask 任务基本信息表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(SysTask sysTask);
	
	/**
     * @api getById 根据任务基本信息表id查询详情
     * @apiGroup 任务基本信息表管理
     * @apiName  查询任务基本信息表详情
     * @apiDescription 根据主键id查询任务基本信息表详情
     * @apiParam {String} id 主键id
     * @apiSuccess SysTask 任务基本信息表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public SysTask getById(String id);
	
	/**
     * @api list 根据任务基本信息表条件查询列表
     * @apiGroup 任务基本信息表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam SysTask sysTask  实体条件
     * @apiSuccess List<SysTask> 任务基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<SysTask> list(SysTask sysTask);
	

	/**
     * @api list 根据任务基本信息表条件查询列表（含排序）
     * @apiGroup 任务基本信息表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam SysTask} sysTask  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<SysTask> 任务基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<SysTask> list(SysTask sysTask, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据任务基本信息表条件查询列表（分页）
     * @apiGroup 任务基本信息表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam SysTask} sysTask  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<SysTask> 任务基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<SysTask> findPageByParam(SysTask sysTask, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据任务基本信息表条件查询列表（分页，含排序）
     * @apiGroup 任务基本信息表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam SysTask} sysTask  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<SysTask> 任务基本信息表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<SysTask> findPageByParam(SysTask sysTask, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据任务基本信息表id删除
     * @apiGroup 任务基本信息表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);
	
	
	public List<SysTask> validTask();

}

