package com.yoxnet.disaster.service;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.disaster.vo.DisasterVO;

/**
 * @author 
 *
 */
public interface DisasterService {
	
	/**
     * @api getDisaster 获取灾害数据
     */
	public ServiceResult<Object> getDisaster(DisasterVO disasterVO);
}

