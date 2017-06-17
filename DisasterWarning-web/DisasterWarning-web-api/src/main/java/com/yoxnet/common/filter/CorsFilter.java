package com.yoxnet.common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.yoxnet.api.util.CollectionUtil;
import com.yoxnet.api.util.StringUtil;

/**
 * 支持 CORS 跨域
 *
 * @author huangyong
 * @since 1.0.0
 */
public class CorsFilter implements Filter {
	private static Environment environment;
	static {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CorsFilterConfiguration.class);
		if(environment == null){
			environment = ctx.getEnvironment();
    	}
	}
	
	private String allowOrigin;//允许访问的客户端域名,例如：http://web.xxx.com，若为 *，则表示从任意域都能访问，即不做任何限制。
    private String allowMethods;//允许访问的方法名，多个方法名用逗号分割，例如：GET,POST,PUT,DELETE,OPTIONS。
    private String allowCredentials;//是否允许请求带有验证信息，若要获取客户端域下的 cookie 时，需要将其设置为 true。
    private String allowHeaders;//允许服务端访问的客户端请求头，多个请求头用逗号分割，例如：Content-Type。
    private String exposeHeaders;//允许客户端访问的服务端响应头，多个响应头用逗号分割。
    private String maxAge;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //allowOrigin = filterConfig.getInitParameter("allowOrigin");
        allowOrigin = environment.getProperty("corse.rest");
        allowMethods = filterConfig.getInitParameter("allowMethods");
        allowCredentials = filterConfig.getInitParameter("allowCredentials");
        allowHeaders = filterConfig.getInitParameter("allowHeaders");
        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
        maxAge = filterConfig.getInitParameter("maxAge");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (StringUtil.isNotEmpty(allowOrigin)) {
            List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
            if (CollectionUtil.isNotEmpty(allowOriginList)) {
                String currentOrigin = request.getHeader("Origin");
                //判断是否是post请求
                if (allowOriginList.contains(currentOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                } else if(null==currentOrigin) {//是null说明是get请求
                	 response.setHeader("Access-Control-Allow-Origin",allowOrigin);
                }
            }
        }
        if (StringUtil.isNotEmpty(allowMethods)) {
            response.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        if (StringUtil.isNotEmpty(allowCredentials)) {
            response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        }
        if (StringUtil.isNotEmpty(allowHeaders)) {
            response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        }
        if (StringUtil.isNotEmpty(exposeHeaders)) {
            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        if (StringUtil.isNotEmpty(maxAge)) {
            response.setHeader("Access-Control-Max-Age", maxAge);
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
