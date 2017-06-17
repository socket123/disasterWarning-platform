package com.yoxnet.common.pdf;

import java.util.List;
import java.util.Map;

public class PdfFile {
	
	/**
	 * 模板键值对应集合
	 */
	private Map<Object,Object> fields ;
	/**
	 * 插入pdf的图片的集合
	 */
	private List<PdfImage> imageList ;
	/**
	 * pdf文件唯一标识
	 * 例如：orderid
	 */
	private String pdfId ;
	/**
	 * pdf模板名称
	 */
	private String templateName ;

	public Map<Object,Object> getFields() {
		return fields;
	}

	public void setFields(Map<Object,Object> fields) {
		this.fields = fields;
	}

	public List<PdfImage> getImageList() {
		return imageList;
	}

	public void setImageList(List<PdfImage> imageList) {
		this.imageList = imageList;
	}

	public String getPdfId() {
		return pdfId;
	}

	public void setPdfId(String pdfId) {
		this.pdfId = pdfId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
}
