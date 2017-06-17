package com.yoxnet.waterSystemInfo.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.waterSystemInfo.bean.WaterSystemInfo;

/**
 * @author 
 *
 */
public interface WaterSystemInfoService {
	
	public ServiceResult<Object> getWaterSystemInfo(String waterSysId);
	
	/**
     * @api save 新增水系基本数据表
     * @apiGroup 水系基本数据表管理
     * @apiName  新增水系基本数据表记录
     * @apiDescription 全量插入水系基本数据表记录
     * @apiParam {WaterSystemInfo} waterSystemInfo 水系基本数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (WaterSystemInfo waterSystemInfo);
	
	/**
     * @api update 修改水系基本数据表
     * @apiGroup 水系基本数据表管理
     * @apiName  修改水系基本数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {WaterSystemInfo} waterSystemInfo 水系基本数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(WaterSystemInfo waterSystemInfo);
	
	/**
     * @api getById 根据水系基本数据表id查询详情
     * @apiGroup 水系基本数据表管理
     * @apiName  查询水系基本数据表详情
     * @apiDescription 根据主键id查询水系基本数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess WaterSystemInfo 水系基本数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public WaterSystemInfo getById(Integer id);
	
	/**
     * @api list 根据水系基本数据表条件查询列表
     * @apiGroup 水系基本数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam WaterSystemInfo waterSystemInfo  实体条件
     * @apiSuccess List<WaterSystemInfo> 水系基本数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemInfo> list(WaterSystemInfo waterSystemInfo);
	

	/**
     * @api list 根据水系基本数据表条件查询列表（含排序）
     * @apiGroup 水系基本数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam WaterSystemInfo} waterSystemInfo  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<WaterSystemInfo> 水系基本数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<WaterSystemInfo> list(WaterSystemInfo waterSystemInfo, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据水系基本数据表条件查询列表（分页）
     * @apiGroup 水系基本数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam WaterSystemInfo} waterSystemInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<WaterSystemInfo> 水系基本数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemInfo> findPageByParam(WaterSystemInfo waterSystemInfo, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据水系基本数据表条件查询列表（分页，含排序）
     * @apiGroup 水系基本数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam WaterSystemInfo} waterSystemInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<WaterSystemInfo> 水系基本数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<WaterSystemInfo> findPageByParam(WaterSystemInfo waterSystemInfo, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据水系基本数据表id删除
     * @apiGroup 水系基本数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(Integer id);

}

