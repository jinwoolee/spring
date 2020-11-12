package kr.or.ddit.config.spring;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
   <context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
	</context:component-scan>   
 */

//@ImportResource({"classpath:kr/or/ddit/config/spring/aop-context.xml"})
//@Import({AopContext.class, DataSourceContext.class, TransactionContext.class})
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
			   includeFilters = {@Filter(type=FilterType.ANNOTATION, 
										  classes = {Service.class, Repository.class})})
public class RootContext {
	
	/*
	 <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basenames">
			<list>
				<value>classpath:/kr/or/ddit/message/error</value>
				<value>classpath:/kr/or/ddit/message/msg</value>
			</list>
		</property>
	</bean>
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = 
				new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/kr/or/ddit/message/error", 
								   "classpath:/kr/or/ddit/message/msg");		
		return messageSource;
	}
}







