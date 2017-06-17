package com.yoxnet.locationInfo.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.locationInfo.bean.DataLocationInfo;

/**
 * @author 
 *
 */
public interface DataLocationInfoService {
	
	/**
     * @api save 新增定位数据表
     * @apiGroup 定位数据表管理
     * @apiName  新增定位数据表记录
     * @apiDescription 全量插入定位数据表记录
     * @apiParam {DataLocationInfo} dataLocationInfo 定位数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (DataLocationInfo dataLocationInfo);
	
	/**
     * @api update 修改定位数据表
     * @apiGroup 定位数据表管理
     * @apiName  修改定位数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {DataLocationInfo} dataLocationInfo 定位数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(DataLocationInfo dataLocationInfo);
	
	/**
     * @api getById 根据定位数据表id查询详情
     * @apiGroup 定位数据表管理
     * @apiName  查询定位数据表详情
     * @apiDescription 根据主键id查询定位数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess DataLocationInfo 定位数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public DataLocationInfo getById(String id);
	
	/**
     * @api list 根据定位数据表条件查询列表
     * @apiGroup 定位数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam DataLocationInfo dataLocationInfo  实体条件
     * @apiSuccess List<DataLocationInfo> 定位数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<DataLocationInfo> list(DataLocationInfo dataLocationInfo);
	

	/**
     * @api list 根据定位数据表条件查询列表（含排序）
     * @apiGroup 定位数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam DataLocationInfo} dataLocationInfo  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<DataLocationInfo> 定位数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<DataLocationInfo> list(DataLocationInfo dataLocationInfo, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据定位数据表条件查询列表（分页）
     * @apiGroup 定位数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam DataLocationInfo} dataLocationInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<DataLocationInfo> 定位数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<DataLocationInfo> findPageByParam(DataLocationInfo dataLocationInfo, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据定位数据表条件查询列表（分页，含排序）
     * @apiGroup 定位数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam DataLocationInfo} dataLocationInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<DataLocationInfo> 定位数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<DataLocationInfo> findPageByParam(DataLocationInfo dataLocationInfo, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据定位数据表id删除
     * @apiGroup 定位数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

