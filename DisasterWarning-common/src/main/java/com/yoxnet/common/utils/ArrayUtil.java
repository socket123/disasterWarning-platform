package com.yoxnet.common.utils;

public class ArrayUtil {

	/** 
	* @Title:StringArrayToString 
	* @Description:把String类型的数组转换成字符串，数组的元素用逗号隔开
	* @param:@param str
	* @param:@return
	* @return:String
	* @throws 
	*/
	public static String StringArrayToString(String[] str) {
		
		if (str == null) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < str.length; i++){
			sb. append(str[i]);
			if(i != str.length-1) {
				sb.append(",");
			}
		}
		String s = sb.toString();
		
		return s;
	}

}