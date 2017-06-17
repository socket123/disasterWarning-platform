package com.yoxnet.points.service;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.disaster.vo.DisasterVO;
import com.yoxnet.points.vo.PointesVO;

/**
 * @author 
 *
 */
public interface PointesService {
	
	/**
     * @api getDisaster 获取灾害数据 线状数据
     */
	public ServiceResult<Object> getDisaster_liness(PointesVO PointesVO);

	/**
	 * @api getDisaster 获取灾害数据 点状数据
	 */
	public ServiceResult<Object> getDisaster(PointesVO PointesVO);
}

