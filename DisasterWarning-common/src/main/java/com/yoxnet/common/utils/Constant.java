package com.yoxnet.common.utils;

public class Constant {
	
	/**
	 * 手机号码的正则表达式
	 */
	public static final String telPattern = "^13[0-9]{9}|15[012356789][0-9]{8}|18[0-9]{9}|14[57][0-9]{8}|170[059][0-9]{7}|17[678][0-9]{8}$";

	/**
	 * 邮箱的正则表达式
	 */
	public static final String mailPattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	
}
