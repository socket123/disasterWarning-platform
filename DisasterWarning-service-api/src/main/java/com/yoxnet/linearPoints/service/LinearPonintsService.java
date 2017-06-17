package com.yoxnet.linearPoints.service;

import java.util.List;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.linearPoints.bean.LinearPoints;

/**
 * @author 
 *
 */
public interface LinearPonintsService {
	
	
	public ServiceResult<Object> getByLinearDisaster(String taskName,String StartTime);
	
	/**
     * @api save 新增线状灾害数据表
     * @apiGroup 线状灾害数据表管理
     * @apiName  新增线状灾害数据表记录
     * @apiDescription 全量插入线状灾害数据表记录
     * @apiParam {PathProfile} linearDisaster 线状灾害数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (LinearPoints linearDisaster);
	
	/**
     * @api update 修改线状灾害数据表
     * @apiGroup 线状灾害数据表管理
     * @apiName  修改线状灾害数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {PathProfile} linearDisaster 线状灾害数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(LinearPoints linearDisaster);
	
	/**
     * @api getById 根据线状灾害数据表id查询详情
     * @apiGroup 线状灾害数据表管理
     * @apiName  查询线状灾害数据表详情
     * @apiDescription 根据主键id查询线状灾害数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess PathProfile 线状灾害数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public LinearPoints getById(String id);
	
	/**
     * @api list 根据线状灾害数据表条件查询列表
     * @apiGroup 线状灾害数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam PathProfile linearDisaster  实体条件
     * @apiSuccess List<PathProfile> 线状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<LinearPoints> list(LinearPoints linearDisaster);
	

	/**
     * @api list 根据线状灾害数据表条件查询列表（含排序）
     * @apiGroup 线状灾害数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam PathProfile} linearDisaster  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<PathProfile> 线状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<LinearPoints> list(LinearPoints linearDisaster, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据线状灾害数据表条件查询列表（分页）
     * @apiGroup 线状灾害数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam PathProfile} linearDisaster  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<PathProfile> 线状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<LinearPoints> findPageByParam(LinearPoints linearDisaster, PageParam pageParam);
	
	/**
     * @api findPageByParam 根据线状灾害数据表条件查询列表（分页，含排序）
     * @apiGroup 线状灾害数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam PathProfile} linearDisaster  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<PathProfile> 线状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<LinearPoints> findPageByParam(LinearPoints linearDisaster, PageParam pageParam, String orderByStr);
	
	
	/**
     * @api deleteById 根据线状灾害数据表id删除
     * @apiGroup 线状灾害数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

