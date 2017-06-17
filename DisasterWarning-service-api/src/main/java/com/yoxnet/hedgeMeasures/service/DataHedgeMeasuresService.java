package com.yoxnet.hedgeMeasures.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.hedgeMeasures.bean.DataHedgeMeasures;

/**
 * @author 
 *
 */
public interface DataHedgeMeasuresService {
	
	/**
     * @api save 新增避险措施数据表
     * @apiGroup 避险措施数据表管理
     * @apiName  新增避险措施数据表记录
     * @apiDescription 全量插入避险措施数据表记录
     * @apiParam {DataHedgeMeasures} dataHedgeMeasures 避险措施数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (DataHedgeMeasures dataHedgeMeasures);
	
	/**
     * @api update 修改避险措施数据表
     * @apiGroup 避险措施数据表管理
     * @apiName  修改避险措施数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {DataHedgeMeasures} dataHedgeMeasures 避险措施数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(DataHedgeMeasures dataHedgeMeasures);
	
	/**
     * @api getById 根据避险措施数据表id查询详情
     * @apiGroup 避险措施数据表管理
     * @apiName  查询避险措施数据表详情
     * @apiDescription 根据主键id查询避险措施数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess DataHedgeMeasures 避险措施数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public DataHedgeMeasures getById(String id);
	
	/**
     * @api list 根据避险措施数据表条件查询列表
     * @apiGroup 避险措施数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam DataHedgeMeasures dataHedgeMeasures  实体条件
     * @apiSuccess List<DataHedgeMeasures> 避险措施数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<DataHedgeMeasures> list(DataHedgeMeasures dataHedgeMeasures);
	

	/**
     * @api list 根据避险措施数据表条件查询列表（含排序）
     * @apiGroup 避险措施数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam DataHedgeMeasures} dataHedgeMeasures  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<DataHedgeMeasures> 避险措施数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<DataHedgeMeasures> list(DataHedgeMeasures dataHedgeMeasures, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据避险措施数据表条件查询列表（分页）
     * @apiGroup 避险措施数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam DataHedgeMeasures} dataHedgeMeasures  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<DataHedgeMeasures> 避险措施数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<DataHedgeMeasures> findPageByParam(DataHedgeMeasures dataHedgeMeasures, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据避险措施数据表条件查询列表（分页，含排序）
     * @apiGroup 避险措施数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam DataHedgeMeasures} dataHedgeMeasures  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<DataHedgeMeasures> 避险措施数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<DataHedgeMeasures> findPageByParam(DataHedgeMeasures dataHedgeMeasures, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据避险措施数据表id删除
     * @apiGroup 避险措施数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);

}

