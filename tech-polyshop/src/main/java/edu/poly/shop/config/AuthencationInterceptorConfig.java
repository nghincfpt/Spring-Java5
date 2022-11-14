package edu.poly.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.poly.shop.interceptor.AdminAuthencationInterceptor;
import edu.poly.shop.interceptor.SiteAuthencationInterceptor;


@Configuration
public class AuthencationInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private AdminAuthencationInterceptor adminAuthencationInterceptor;

	@Autowired
	private SiteAuthencationInterceptor siteAuthencationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//registry.addInterceptor(adminAuthencationInterceptor).addPathPatterns("/admin/**");

		registry.addInterceptor(siteAuthencationInterceptor).addPathPatterns("/ite/**");
	}
}
