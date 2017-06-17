package com.yoxnet.common.page;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

/*
 * 往前台页面返回的分页对象。
 * 
 */
public class PageResult<T>  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2620919373917939077L;
	// 返回当前页结果
	private List<T> list;
	
	//easyUi
	private List<T> rows;
	//easyUi
	private int count;
	
	private int total;
	
	/** 页大小（每页数据个数） */
	private int pageSize;

	/** 当前页号 */
	private int pageNo;

	/** 数据总个数 */
	private long totalCount = 0;
	
	/** 数据总页数数 */
	private long totalPage = 0;
	
	public PageResult() {
	}

	 /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PageResult(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.totalCount = page.getTotal();
            this.total = (int) page.getTotal();
            this.totalPage = page.getPages();
            this.list = page;
        }
    }


	/**
	 * 把查询的List封装到PageResult中
	 * @param list
	 * @return
	 */
	public static <X> PageResult<X> toPage(List<X> list) {
		PageResult<X> pageResult = new PageResult<X>();
		pageResult.setList(list);
		if( list instanceof Page ){
			Page<X> page = (Page<X>) list;
			pageResult.setPageNo(page.getPageNum());
			pageResult.setPageSize(page.getPageSize());
			pageResult.setTotalCount(page.getTotal());
			pageResult.setTotalPage(page.getPages());
		}else{
			pageResult.setTotalCount(list.size());
		}
		return pageResult;
    }
	
	
	
	/**
	* @Description: 针对easyUI
	* @param list
	* @return
	* @author: Aaron
	* @date: 2016年11月11日 上午9:30:59
	*/
	public static <X> PageResult<X> toPageUi(List<X> list) {
		PageResult<X> pageResult = new PageResult<X>();
		pageResult.setRows(list);
		if( list instanceof Page ){
			Page<X> page = (Page<X>) list;
			pageResult.setCount((int) page.getTotal());
			pageResult.setTotal((int) page.getTotal());
		}else{
			pageResult.setTotalCount(list.size());
		}
		return pageResult;
    }



	public List<T> getList() {
		return list;
	}



	public void setList(List<T> list) {
		this.list = list;
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



	public long getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}



	public long getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

	

	
	
	
}
