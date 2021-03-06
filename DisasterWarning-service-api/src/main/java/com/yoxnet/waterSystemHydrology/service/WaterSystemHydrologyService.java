package com.yoxnet.waterSystemHydrology.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.waterSystemHydrology.bean.WaterSystemHydrology;

/**
 * @author 
 *
 */
public interface WaterSystemHydrologyService {
	
	public ServiceResult<Object> getWaterSystemHydrology(String time);
	
	/**
     * @api save 新增水系水文数据表
     * @apiGroup 水系水文数据表管理
     * @apiName  新增水系水文数据表记录
     * @apiDescription 全量插入水系水文数据表记录
     * @apiParam {WaterSystemHydrology} waterSystemHydrology 水系水文数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (WaterSystemHydrology waterSystemHydrology);
	
	/**
     * @api update 修改水系水文数据表
     * @apiGroup 水系水文数据表管理
     * @apiName  修改水系水文数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {WaterSystemHydrology} waterSystemHydrology 水系水文数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(WaterSystemHydrology waterSystemHydrology);
	
	/**
     * @api getById 根据水系水文数据表id查询详情
     * @apiGroup 水系水文数据表管理
     * @apiName  查询水系水文数据表详情
     * @apiDescription 根据主键id查询水系水文数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess WaterSystemHydrology 水系水文数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public WaterSystemHydrology getById(String id);
	
	/**
     * @api list 根据水系水文数据表条件查询列表
     * @apiGroup 水系水文数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam WaterSystemHydrology waterSystemHydrology  实体条件
     * @apiSuccess List<WaterSystemHydrology> 水系水文数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemHydrology> list(WaterSystemHydrology waterSystemHydrology);
	

	/**
     * @api list 根据水系水文数据表条件查询列表（含排序）
     * @apiGroup 水系水文数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam WaterSystemHydrology} waterSystemHydrology  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<WaterSystemHydrology> 水系水文数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemHydrology> list(WaterSystemHydrology waterSystemHydrology, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据水系水文数据表条件查询列表（分页）
     * @apiGroup 水系水文数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam WaterSystemHydrology} waterSystemHydrology  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<WaterSystemHydrology> 水系水文数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemHydrology> findPageByParam(WaterSystemHydrology waterSystemHydrology, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据水系水文数据表条件查询列表（分页，含排序）
     * @apiGroup 水系水文数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam WaterSystemHydrology} waterSystemHydrology  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<WaterSystemHydrology> 水系水文数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemHydrology> findPageByParam(WaterSystemHydrology waterSystemHydrology, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据水系水文数据表id删除
     * @apiGroup 水系水文数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

