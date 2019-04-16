package com.boot.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.boot.intercept.logingIntercept;
@Configuration
public class WebConf extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//需要拦截的路径
		String[] addPathPatterns={"/**"};
		//不拦截的路径
		String[] excludePathPatterns={"/boot/hello","/boot/index","/myFilter"};
		registry.addInterceptor(new logingIntercept()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
		/*有多个拦截器就写多少个此代码
		registry.addInterceptor(new logingIntercept()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
		*/
	}
	
}