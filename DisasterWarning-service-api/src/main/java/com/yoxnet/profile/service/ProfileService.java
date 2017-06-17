package com.yoxnet.profile.service;

import com.yoxnet.common.ServiceResult;
import com.yoxnet.profile.vo.ProfileVO;

/**
 * @author 
 *
 */
public interface ProfileService {
	
	/**
     * @api getDisaster 获取灾害数据
     */
	public ServiceResult<Object> getPathProfile(ProfileVO profileVO);
}

