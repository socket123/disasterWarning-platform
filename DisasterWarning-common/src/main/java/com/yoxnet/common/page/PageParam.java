package com.yoxnet.common.page;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

/**
 * 分页参数?
 * 
 */
public class PageParam implements Page,java.io.Serializable {

	/**
	 * 
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	/**
	 * 页号
	 */
	private int pageNo;
	
	/**
	 * 每页显示条数
	 */
	private int pageSize;
	
	private int prePage;
	private int nextPage;
	private int totalPage;
	private int totalCount;

	public PageParam() {
		this.pageNo = 1;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumber() {
		return pageNo;
	}

	public int getNumberOfElements() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getSize() {
		return pageSize;
	}

	public Sort getSort() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasContent() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFirst() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLast() {
		// TODO Auto-generated method stub
		return false;
	}

	public Pageable nextPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pageable previousPageable() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTotalElements() {
		return totalCount;
	}

	public int getTotalPages() {
		return totalPage;
	}

	public boolean hasNextPage() {
		if (pageNo < totalPage) {
			return true;
		} else {
			return false;
		}
	}

	public boolean hasPreviousPage() {
		if (pageNo > 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFirstPage() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLastPage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page map(Converter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
