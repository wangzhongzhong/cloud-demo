package com.dnt.cloud.demo.web.filter;

import javax.annotation.Resource;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
//@EnableWebMvc //不能加入这个注解否则不执行自定义的converter
public class BehaviorWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Resource(name = "behaviorInterceptor")
	private BehaviorInterceptor behaviorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(behaviorInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/","/index","/css/*", "/js/*", "/images/*","/fonts/*");
		// 排除拦截目录 /extinterface/** 两个星“*”表示 该目录下及其子目录 全部涵盖
		super.addInterceptors(registry);
	}
}
