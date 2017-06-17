package com.yoxnet.common.pdf;

public class PdfImage {
	
	/**
	 * 当前页X坐标位置
	 */
	private int absoluteX;
	/**
	 * 当前页Y坐标位置
	 */
	private int absoluteY;
	/**
	 * 插入的页数
	 */
	private int pageNum;
	/**
	 * 图片百分百缩略大小
	 */
	private int scalePercent;
	/**
	 * 图片真实路径
	 */
	private String filePath;
	
	public int getAbsoluteX() {
		return absoluteX;
	}
	
	public void setAbsoluteX(int absoluteX) {
		this.absoluteX = absoluteX;
	}
	
	public int getAbsoluteY() {
		return absoluteY;
	}
	
	public void setAbsoluteY(int absoluteY) {
		this.absoluteY = absoluteY;
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getScalePercent() {
		return scalePercent;
	}
	
	public void setScalePercent(int scalePercent) {
		this.scalePercent = scalePercent;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
}
