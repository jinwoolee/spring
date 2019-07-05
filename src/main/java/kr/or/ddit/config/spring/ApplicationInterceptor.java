package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class ApplicationInterceptor extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * <mvc:interceptor>
			<mvc:mapping path="/**"/>
			<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
				<property name="paramName" value="lang"/>
			</bean>
		</mvc:interceptor>
		 */
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		
		registry.addInterceptor(lci).addPathPatterns("/**");
	}

}






