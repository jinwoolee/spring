package kr.or.ddit.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 * <context:component-scan base-package="kr.or.ddit" use-default-filters="false">
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
</context:component-scan>
 */

@ComponentScan(basePackages= {"kr.or.ddit"}, useDefaultFilters=false,
			  includeFilters= {@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Repository.class),
					  			@ComponentScan.Filter(type=FilterType.ANNOTATION, value=Service.class)})
@Configuration
public class RootContext {
	
}