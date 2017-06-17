package com.yoxnet.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class OrderCodeUtil {
	
	 private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMdd");
	 private OrderCodeUtil() {
	    }

	    /**
	     * 获取当前日期与时间
	     */
	    public static String getCurrentDateTime() {
	        return dateTimeFormat.format(new Date());
	    }
	    /**
	     * 生成合同号
	     * contractIncreCode:合同号六位自增编号
	     */
	    public static String getOrderContractCode(String constactIncreCode) {
	    	StringBuilder sb=new StringBuilder();
	    	sb.append("co00");
	    	sb.append(OrderCodeUtil.getCurrentDateTime());
	    	sb.append(constactIncreCode);
	    	
	        return sb.toString();
	    }
	    /**
	     * 生成订单号
	     * pTypeCode:商品类别
	     * pbriefCode：商品简称
	     * orderIncreCode：订单六位自增编号
	     */
	    public static String getOrderCode(String pTypeCode,String pbriefCode,String orderIncreCode) {
	    	StringBuilder sb=new StringBuilder();
	    	sb.append(pTypeCode);
	    	sb.append("00");
	    	sb.append(OrderCodeUtil.getCurrentDateTime());
	    	sb.append(orderIncreCode);
	        return sb.toString();
	    }
	    /**
	     * 生成补单号
	     * orderCode：订单编号
	     * addedTypeCode：补单类型编号
	     * addedOrderIncreCode：补单两位自增编号
	     */
	    public static String getAddedOrderCode(String orderCode,String addedTypeCode,String addedOrderIncreCode) {
	    	StringBuilder sb=new StringBuilder();
	    	sb.append(orderCode);
	    	sb.append(addedTypeCode);
	    	sb.append(addedOrderIncreCode);
	        return sb.toString();
	    }
}
