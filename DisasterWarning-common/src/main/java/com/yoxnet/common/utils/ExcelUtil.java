package com.yoxnet.common.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

/**
 * excel导出、导入工具
 * @author Administrator
 *
 */
public class ExcelUtil {
	//科学计数法正则表达式
	public static String regx = "^((-?\\d+.?\\d*)[Ee]{1}(-?\\d+))$";
	
	/**
	 * 判断是否为科学计数法
	 * @param input
	 * @return
	 */
    public static boolean isENum(String input){//判断输入字符串是否为科学计数法
    	Pattern pattern = Pattern.compile(regx);
        return pattern.matcher(input).matches();
    }
	
    public static void main(String[] args){
    	System.out.println(isENum("1.213123123123e100"));
    	
    	String value = "1.213123123123e100";
    	if (value.indexOf("E") > -1 || value.indexOf(".") > -1) {
			DecimalFormat df = new DecimalFormat("0");
			value = df.format(Double.parseDouble(value));
		}
    	System.out.println(value);
    }
    
	/**
	 * 获取单元格的值
	 */
	public static String getCellValue(Cell cell) {
		String value = cell.getStringCellValue();
		if (isENum(value)) {
			DecimalFormat df = new DecimalFormat("0");
			value = df.format(Double.parseDouble(value));
		}
		return value;
	}
	
	/**
	 * 日期单元格转化为 日期字符串
	 * @param cell
	 * @return
	 */
	public static String cellToDateStr (Cell cell) {
		String value = null;
		try {
			value = cell.getStringCellValue();
			if (!value.trim().equals("")) {
				DateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
				Date d = HSSFDateUtil.getJavaDate(Double.parseDouble(value));
				value = formater.format(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	/**
	 * 日期单元格转化为 日期字符串
	 * @param cell
	 * @return
	 */
	public static String cellToDateString (Cell cell) {
		String value = null;
		try {
			value = cell.getStringCellValue();
			if (!value.trim().equals("")) {
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				Date d = HSSFDateUtil.getJavaDate(Double.parseDouble(value));
				value = formater.format(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
