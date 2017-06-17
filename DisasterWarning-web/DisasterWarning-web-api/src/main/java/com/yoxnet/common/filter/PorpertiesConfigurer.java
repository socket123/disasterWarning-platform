package com.yoxnet.common.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * 自定义读取配置文件
 * @author Administrator
 *
 */
public class PorpertiesConfigurer extends PropertyPlaceholderConfigurer {
	private static Map<Object, Object> ctxPropertiesMap;  
	   
    @Override  
    protected void processProperties(  
            ConfigurableListableBeanFactory beanFactoryToProcess,  
            Properties props) throws BeansException {  
        super.processProperties(beanFactoryToProcess, props);  
        ctxPropertiesMap = new HashMap<Object, Object>();  
        for (Object key : props.keySet()) {  
            String keyStr = key.toString();  
            String value = props.getProperty(keyStr);  
            ctxPropertiesMap.put(keyStr, value);  
            System.out.println(keyStr + "=" + value);
        }  
        System.out.println("============================");	
    }  
    public static Object getContextProperty(String name) {  
        return ctxPropertiesMap.get(name);  
    }  
    
    public static void setCtxPropertiesMap(Map<Object, Object> ctxPropertiesMap) {
		PorpertiesConfigurer.ctxPropertiesMap = ctxPropertiesMap;
	}
}
