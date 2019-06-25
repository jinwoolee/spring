package kr.or.ddit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//<context:annotation-config/> 역할을 @Configuration에서 담당
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit.board", "kr.or.ddit.aop"}, 
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Aspect.class),
	excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, value = Controller.class))
@EnableAspectJAutoProxy
public class AopScanConfig {
	
}





