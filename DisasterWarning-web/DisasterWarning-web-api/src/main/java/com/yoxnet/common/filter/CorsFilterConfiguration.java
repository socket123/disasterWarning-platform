package com.yoxnet.common.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
/**
 * 加载配置文件
 * @author Administrator
 *
 */
@Configuration
//@PropertySource(value="classpath:config.properties")//jdk8的写法
@PropertySources(value = {@PropertySource("classpath:config.properties")})//兼容jdk7
public class CorsFilterConfiguration {

}
