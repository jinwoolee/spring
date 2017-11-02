package aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

import aop.target.AnnotationTarget;

@Configuration
@ComponentScan(basePackages = {"aop.annotation"},useDefaultFilters = false 
			  ,includeFilters=@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Aspect.class))
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ApplicationConfig {
	
	@Bean
	public AnnotationTarget annotationTarget() {
		return new AnnotationTarget();
	}
}