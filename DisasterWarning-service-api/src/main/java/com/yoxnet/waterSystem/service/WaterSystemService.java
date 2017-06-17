package com.yoxnet.waterSystem.service;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.waterSystem.vo.WaterSysVO;

/**
 * @author 
 *
 */
public interface WaterSystemService {
	
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
	public ServiceResult<Object> getWaterSys (WaterSysVO waterSysVO);

}

