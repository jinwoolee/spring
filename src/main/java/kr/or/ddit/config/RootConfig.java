package kr.or.ddit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 * 	<context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation"
				 expression="org.springframework.stereotype.Service"/>
		<context:include-filter type="annotation"
				 expression="org.springframework.stereotype.Repository"/>
	</context:component-scan>
 */
@Configuration
@ComponentScan(basePackages = "kr.or.ddit", useDefaultFilters = false,
				includeFilters = @Filter(type = FilterType.ANNOTATION, 
										 classes = {Service.class, Repository.class}))
public class RootConfig {

}





