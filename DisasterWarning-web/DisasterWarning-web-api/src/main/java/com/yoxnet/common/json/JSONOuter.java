/**   
 * @Title: JSONOuter.java 
 * @Package com.htjx.common.web.json 
 * @Copyright: Copyright @  
 * @author 
 * @date - 
 * @version V1.0   
 */
package com.yoxnet.common.json;

import java.io.Writer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;

/**
 * @ClassName: JSONOuter
 * @Description: JSONOuter工具类
 *
 */
public class JSONOuter {
	
	/**
	 * 向前端写数据
	 * @param out:java.io.Writer对象
	 * @param object:需要写出去的对象
	 */
	public static final void write(Writer out, Object object) {
		JSONSerializer.write(out, object);
    }
	
	/**
	 * 将指定数据格式化为JSON格式
	 * @param object
	 * @return
	 */
	public static final String getJson(Object object) {
		return JSON.toJSONString(object);
    }

	
}
