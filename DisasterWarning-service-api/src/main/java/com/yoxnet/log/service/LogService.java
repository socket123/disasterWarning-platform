package com.yoxnet.log.service;

import java.util.List;

import com.yoxnet.common.page.PageParam;
import com.yoxnet.common.page.PageResult;
import com.yoxnet.log.bean.Log;

/**
 * @author 
 *
 */
public interface LogService {
	
	/**
     * @api save 新增推送日志数据表
     * @apiGroup 推送日志数据表管理
     * @apiName  新增推送日志数据表记录
     * @apiDescription 全量插入推送日志数据表记录
     * @apiParam {Log} log 推送日志数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public  void save (Log log);
	
	/**
     * @api update 修改推送日志数据表
     * @apiGroup 推送日志数据表管理
     * @apiName  修改推送日志数据表记录
     * @apiDescription 根据主键id修改记录，只修改非null属性
     * @apiParam {Log} log 推送日志数据表对象
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void update(Log log);
	
	/**
     * @api getById 根据推送日志数据表id查询详情
     * @apiGroup 推送日志数据表管理
     * @apiName  查询推送日志数据表详情
     * @apiDescription 根据主键id查询推送日志数据表详情
     * @apiParam {String} id 主键id
     * @apiSuccess Log 推送日志数据表实体对象
     * @apiVersion 1.0.0
     * 
     */
	public Log getById(String id);
	
	/**
     * @api list 根据推送日志数据表条件查询列表
     * @apiGroup 推送日志数据表管理
     * @apiName  查询列表
     * @apiDescription 根据条件查询列表
     * @apiParam Log log  实体条件
     * @apiSuccess List<Log> 推送日志数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Log> list(Log log);
	

	/**
     * @api list 根据推送日志数据表条件查询列表（含排序）
     * @apiGroup 推送日志数据表管理
     * @apiName  查询列表（含排序）
     * @apiDescription 根据条件查询列表，含排序
     * @apiParam Log} log  实体条件
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess List<Log> 推送日志数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public List<Log> list(Log log, String orderByStr);
	
	
	/**
     * @api findPageByParam 根据推送日志数据表条件查询列表（分页）
     * @apiGroup 推送日志数据表管理
     * @apiName  查询列表（分页）
     * @apiDescription 根据条件查询列表，分页
     * @apiParam Log} log  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiSuccess PageResult<Log> 推送日志数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Log> findPageByParam(Log log, PageParam pageParam); 
	
	/**
     * @api findPageByParam 根据推送日志数据表条件查询列表（分页，含排序）
     * @apiGroup 推送日志数据表管理
     * @apiName  查询列表（分页，含排序）
     * @apiDescription 根据条件查询列表，分页，含排序。
     * @apiParam Log} log  实体条件
     * @apiParam {PageParam} pageParam  必需属性pageNo，pageSize。
     * @apiParam {String} orderByStr  排序字段。举例：id asc。
     * @apiSuccess PageResult<Log> 推送日志数据表实体列表
     * @apiVersion 1.0.0
     * 
     */
	public PageResult<Log> findPageByParam(Log log, PageParam pageParam,String orderByStr); 
	
	
	/**
     * @api deleteById 根据推送日志数据表id删除
     * @apiGroup 推送日志数据表管理
     * @apiName  根据id删除
     * @apiDescription 根据主键id删除对象。
     * @apiParam {String} id  主键id。
     * @apiSuccess void
     * @apiVersion 1.0.0
     * 
     */
	public void deleteById(String id);
	
	/**
	 * 
	* @Description: 
	* @param username
	* @param pageNum 页号，默认每页10条
	* @param size 每页数量
	* @return
	* @author: Storydo
	* @date: 2017年3月15日 上午11:32:10
	 */
	public List<Log> selectAllLogAndOwner(String username,Integer pageNum,Integer size);
	

}

