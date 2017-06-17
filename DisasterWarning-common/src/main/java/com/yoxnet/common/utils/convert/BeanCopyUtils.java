package com.yoxnet.common.utils.convert;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.PropertyUtils;

public class BeanCopyUtils {

	/**
	 * 复制实体属性到另外一个实体中
	 * @param toBean  拷贝的实体
	 * @param fromBean  被拷贝的实体
	 */
	public static void copyProperties(Object toBean,Object fromBean){
		ConvertUtils.register(new DateConverter(), java.util.Date.class);
//		try {
//			BeanUtils.copyProperties(toBean, fromBean);
//			
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
		
		//原来的BeanUtils对于Internet和Long的null数据，会自动拷贝成0，故换成下面方法。
		try {
			PropertyUtils.copyProperties(toBean, fromBean);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
