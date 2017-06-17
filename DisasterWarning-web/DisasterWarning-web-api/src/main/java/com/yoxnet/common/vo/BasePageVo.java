package com.yoxnet.common.vo;

import java.io.Serializable;

import com.yoxnet.common.page.PageParam;

public class BasePageVo<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T entity;
	
	private PageParam pageParam;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public PageParam getPageParam() {
		return pageParam;
	}

	public void setPageParam(PageParam pageParam) {
		this.pageParam = pageParam;
	}
	
	public static void main(String[] args) {
	}
	
}
