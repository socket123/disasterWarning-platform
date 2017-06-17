package com.yoxnet.waterSystemLocation.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.waterSystemLocation.bean.WaterSystemLocation;

/**
 * @author 
 *
 */
public interface WaterSystemLocationService {
	
	public ServiceResult<Object> getWaterSystemLocation(String waterSysId) ;
	
	/**
     * @api save 新增水系定位点数据表
     * @apiGroup 水系定位点数据表管理
     * @apiName  新增水系定位点数据表记录
     * @apiDescription 全量插入水系定位点数据表记录
     * @apiParam {WaterSystemLocation} waterSystemLocation 水系定位点数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (WaterSystemLocation waterSystemLocation);
	
	/**
     * @api update 修改水系定位点数据表
     * @apiGroup 水系定位点数据表管理
     * @apiName  修改水系定位点数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {WaterSystemLocation} waterSystemLocation 水系定位点数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(WaterSystemLocation waterSystemLocation);
	
	/**
     * @api getById 根据水系定位点数据表id查询详情
     * @apiGroup 水系定位点数据表管理
     * @apiName  查询水系定位点数据表详情
     * @apiDescription 根据主键id查询水系定位点数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess WaterSystemLocation 水系定位点数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public WaterSystemLocation getById(String id);
	
	/**
     * @api list 根据水系定位点数据表条件查询列表
     * @apiGroup 水系定位点数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam WaterSystemLocation waterSystemLocation  实体条件
     * @apiSuccess List<WaterSystemLocation> 水系定位点数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemLocation> list(WaterSystemLocation waterSystemLocation);
	

	/**
     * @api list 根据水系定位点数据表条件查询列表（含排序）
     * @apiGroup 水系定位点数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam WaterSystemLocation} waterSystemLocation  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<WaterSystemLocation> 水系定位点数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemLocation> list(WaterSystemLocation waterSystemLocation, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据水系定位点数据表条件查询列表（分页）
     * @apiGroup 水系定位点数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam WaterSystemLocation} waterSystemLocation  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<WaterSystemLocation> 水系定位点数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemLocation> findPageByParam(WaterSystemLocation waterSystemLocation, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据水系定位点数据表条件查询列表（分页，含排序）
     * @apiGroup 水系定位点数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam WaterSystemLocation} waterSystemLocation  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<WaterSystemLocation> 水系定位点数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemLocation> findPageByParam(WaterSystemLocation waterSystemLocation, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据水系定位点数据表id删除
     * @apiGroup 水系定位点数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

