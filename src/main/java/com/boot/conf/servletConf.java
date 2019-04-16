package com.boot.conf;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.boot.intercept.filter.HeFilter;
/*
 * 此类事配置servlet和filter的
 */
@Configuration
public class servletConf {
	//这是servlet的另一种写法
//	@Bean
//	public ServletRegistrationBean heServlet(){
//		ServletRegistrationBean fg=new ServletRegistrationBean(new HeFilter(),"/url");
//		return fg;
//	}
	//这是filter的写法
	@Bean
	public FilterRegistrationBean heFilter(){
		FilterRegistrationBean fg=new FilterRegistrationBean(new HeFilter());
		fg.addUrlPatterns("/*");
		return fg;
	}
	
	/*编码设置等价于web.xml中配置的编码方式
	 * 注意：只有当spring.http.encoding.enabled=false配置成false后，过滤器才会起作用
	 * 也可在application.properties中配置，二选一
	 */
//	@Bean
//	public FilterRegistrationBean filterRegistrationBean(){
//		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//	   	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//	    characterEncodingFilter.setForceEncoding(true);
//	    characterEncodingFilter.setEncoding("UTF-8");
//	    registrationBean.setFilter(characterEncodingFilter);
//	    registrationBean. addUrlPatterns("/*");
//	    return registrationBean;
//	}

}
