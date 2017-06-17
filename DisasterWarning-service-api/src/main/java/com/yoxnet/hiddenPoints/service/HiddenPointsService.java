package com.yoxnet.hiddenPoints.service;

import java.util.List;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.hiddenPoints.bean.HiddenPoints;


/**
 * @author 
 *
 */
public interface HiddenPointsService {
	
	public ServiceResult<Object> getByPointDisaster(String taskName,String StartTime);
	
	/**
     * @api save 新增点状灾害数据表
     * @apiGroup 点状灾害数据表管理
     * @apiName  新增点状灾害数据表记录
     * @apiDescription 全量插入点状灾害数据表记录
     * @apiParam {HiddenPoints} hiddenPoints 点状灾害数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (HiddenPoints hiddenPoints);
	
	/**
     * @api update 修改点状灾害数据表
     * @apiGroup 点状灾害数据表管理
     * @apiName  修改点状灾害数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {HiddenPoints} hiddenPoints 点状灾害数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(HiddenPoints hiddenPoints);
	
	/**
     * @api getById 根据点状灾害数据表id查询详情
     * @apiGroup 点状灾害数据表管理
     * @apiName  查询点状灾害数据表详情
     * @apiDescription 根据主键id查询点状灾害数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess HiddenPoints 点状灾害数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public HiddenPoints getById(String id);
	
	/**
     * @api list 根据点状灾害数据表条件查询列表
     * @apiGroup 点状灾害数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam HiddenPoints hiddenPoints  实体条件
     * @apiSuccess List<HiddenPoints> 点状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<HiddenPoints> list(HiddenPoints hiddenPoints);
	

	/**
     * @api list 根据点状灾害数据表条件查询列表（含排序）
     * @apiGroup 点状灾害数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam HiddenPoints} hiddenPoints  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<HiddenPoints> 点状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<HiddenPoints> list(HiddenPoints hiddenPoints, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据点状灾害数据表条件查询列表（分页）
     * @apiGroup 点状灾害数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam HiddenPoints} hiddenPoints  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<HiddenPoints> 点状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<HiddenPoints> findPageByParam(HiddenPoints hiddenPoints, PageParam pageParam);
	
	/**
     * @api findPageByParam 根据点状灾害数据表条件查询列表（分页，含排序）
     * @apiGroup 点状灾害数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam HiddenPoints} hiddenPoints  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<HiddenPoints> 点状灾害数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<HiddenPoints> findPageByParam(HiddenPoints hiddenPoints, PageParam pageParam, String orderByStr);
	
	
	/**
     * @api deleteById 根据点状灾害数据表id删除
     * @apiGroup 点状灾害数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

