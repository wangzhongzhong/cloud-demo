package com.dnt.cloud.demo.web;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;





import com.dnt.cloud.home.HomeController;
import com.dnt.cloud.swagger.SwaggerConfig;

@MapperScan(basePackages = "com.dnt.cloud.demo.dao")
@ComponentScan(basePackages = { "com.dnt.cloud.demo" }, basePackageClasses = { HomeController.class })
@Import(SwaggerConfig.class)
@SpringBootApplication(scanBasePackages = { "com.dnt.cloud.web","com.dnt.cloud.demo.web", "com.dnt.cloud.logger" })
public class DemoApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	
	public static ConfigurableApplicationContext run(Class<?> clazz, String[] args) {
		Logger logger = LoggerFactory.getLogger(clazz);

		ConfigurableApplicationContext context = SpringApplication.run(clazz, args);

		Environment env = context.getEnvironment();
		String appName = env.getProperty("spring.application.name");
		String port = env.getProperty("server.port");
		String contextPath = env.getProperty("server.context-path");
		String hostAddress;
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
			String localInfo = "\n-----------------------------------------------------------------------\n\tApplication '{}' is running! Access URLs:\n\tLocal: \thttp://127.0.0.1:{}{}\n\tExternal: \thttp://{}:{}{}\n-----------------------------------------------------------------------";
			logger.info(localInfo, appName, port, contextPath, hostAddress, port, contextPath);
		} catch (Exception e) {
			logger.error("启动异常", e);
		}
		return context;
	}

	public static void main(String[] args) throws UnknownHostException {
		DemoApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/")
	public ModelAndView index() {
		// return "Welcome to NRC Cloud Config Center!";
		return new ModelAndView("/index");
	}

	@GetMapping(value = "/_health_check")
	public String healthCheck() {
		return "ok";
	}
}