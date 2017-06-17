package com.yoxnet.kilometerPileInfo.service;

import java.util.List;
import java.util.Map;

import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.kilometerPileInfo.bean.KilometerPileInfo;

/**
 * @author 
 *
 */
public interface KilometerPileInfoService {
	
	public KilometerPileInfo select(String pileId);
	
	
	public List<KilometerPileInfo> selectByStartEnd(Integer start,Integer end);
	
	/**
     * @api save 新增公里桩数据表 
     * @apiGroup 公里桩数据表 管理
     * @apiName  新增公里桩数据表 记录
     * @apiDescription 全量插入公里桩数据表 记录
     * @apiParam {KilometerPileInfo} kilometerPileInfo 公里桩数据表 对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (KilometerPileInfo kilometerPileInfo);
	
	/**
     * @api update 修改公里桩数据表 
     * @apiGroup 公里桩数据表 管理
     * @apiName  修改公里桩数据表 记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {KilometerPileInfo} kilometerPileInfo 公里桩数据表 对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(KilometerPileInfo kilometerPileInfo);
	
	/**
     * @api getById 根据公里桩数据表 id查询详情
     * @apiGroup 公里桩数据表 管理
     * @apiName  查询公里桩数据表 详情
     * @apiDescription 根据主键id查询公里桩数据表 详情
     * @apiParam {String} id 主键id
     * @apiSuccess KilometerPileInfo 公里桩数据表 实体对象
     * @apiVersion 1.0.0
     * 
     */
	public KilometerPileInfo getById(Integer id);
	
	/**
     * @api list 根据公里桩数据表 条件查询列表
     * @apiGroup 公里桩数据表 管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam KilometerPileInfo kilometerPileInfo  实体条件
     * @apiSuccess List<KilometerPileInfo> 公里桩数据表 实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<KilometerPileInfo> list(KilometerPileInfo kilometerPileInfo);
	

	/**
     * @api list 根据公里桩数据表 条件查询列表（含排序）
     * @apiGroup 公里桩数据表 管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam KilometerPileInfo} kilometerPileInfo  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<KilometerPileInfo> 公里桩数据表 实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<KilometerPileInfo> list(KilometerPileInfo kilometerPileInfo, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据公里桩数据表 条件查询列表（分页）
     * @apiGroup 公里桩数据表 管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam KilometerPileInfo} kilometerPileInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<KilometerPileInfo> 公里桩数据表 实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<KilometerPileInfo> findPageByParam(KilometerPileInfo kilometerPileInfo, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据公里桩数据表 条件查询列表（分页，含排序）
     * @apiGroup 公里桩数据表 管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam KilometerPileInfo} kilometerPileInfo  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<KilometerPileInfo> 公里桩数据表 实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<KilometerPileInfo> findPageByParam(KilometerPileInfo kilometerPileInfo, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据公里桩数据表 id删除
     * @apiGroup 公里桩数据表 管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(Integer id);

}

