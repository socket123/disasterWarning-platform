package com.yoxnet.common;

public class PageUtil {
	
	/**
	 * page：第几页
	 */
	private Integer page;
	
	/**
	 * rows：每页多少条数据
	 */
	private Integer rows;
	
	/**
	 * startRows：开始于第几条数据
	 */
	private Integer startRows;
	
	/**
	 * totalRows：总记录数
	 */
	private Integer totalRows;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStartRows() {
		this.startRows = (page-1)*rows; 
		return this.startRows;
	}

	public void setStartRows(Integer startRows) {
		this.startRows = startRows;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	
}