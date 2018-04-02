package ddit.or.kr.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;

import ddit.or.kr.aop.service.AopService;
import ddit.or.kr.aop.service.AopServiceImpl;

@Configuration
@ComponentScan(basePackages="ddit.or.kr.aop",
	includeFilters=@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Aspect.class),
	useDefaultFilters=false)
@EnableAspectJAutoProxy(proxyTargetClass=false)
public class AopAnnotationConfig {
	
	@Bean
	public AopService getAopService(){
		return new AopServiceImpl();
	}
}





