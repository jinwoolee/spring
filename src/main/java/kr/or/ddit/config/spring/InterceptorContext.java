package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import kr.or.ddit.interceptor.ProfileInterceptor;
import kr.or.ddit.interceptor.SesseionCheckInterceptor;

@Configuration
public class InterceptorContext extends WebMvcConfigurerAdapter{

	@Bean
	public HandlerInterceptor profileInterceptor(){
		return new ProfileInterceptor();
	}
	
	@Bean
	public HandlerInterceptor sessionCheckInterceptor(){
		return new SesseionCheckInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(profileInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(sessionCheckInterceptor())
					.addPathPatterns("/**")
					.excludePathPatterns("/login")
					.excludePathPatterns("/excelView")
					.excludePathPatterns("/resources/**")
					.excludePathPatterns("/css/**")
					.excludePathPatterns("/js/**")
					.excludePathPatterns("/error/**");
	}
}
