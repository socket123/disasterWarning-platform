package com.yoxnet.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * ClassName: StoredProCallerUtil <br/>
 * Function: 存储过程调用工具类. <br/>
 *
 * @version
 * @since JDK 1.7
 */
public class StoredProCallerUtil {

	/**
	 * getParamMap:存储过程调用参数映射 <br/>
	 * 
	 * @author yi
	 * @param paramDto
	 * @return 参数Map
	 * @since JDK 1.7
	 */
	public static <T> Map<String, Object> getParamMap(T paramDto) {

		Map<String, Object> params = new HashMap<String, Object>();

		// 传递参数实体为空的场合
		if (paramDto == null) {
			return params;
		}

		Class<? extends Object> clazz = paramDto.getClass();

		Field[] fields = clazz.getDeclaredFields();

		if (fields == null || fields.length == 0) {
			return params;
		}

		for (Field field : fields) {
			try {
				// 设置私有成员可以访问
				field.setAccessible(true);
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				// 获得get方法
				Method getMethod = pd.getReadMethod();
				// 调用get方法获取对象属性值并设置到map里面
				params.put(field.getName(), getMethod.invoke(paramDto));
			} catch (Exception e) {
				// handle exception
			}
		}

		return params;
	}

	public static void main(String[] args) {
		
	}
}
