package kr.or.ddit.config.spring;

import javax.swing.plaf.multi.MultiMenuItemUI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import kr.or.ddit.mvc.view.ExcelDownloadView;
import kr.or.ddit.mvc.view.ProfileImgView;

/*
   <context:component-scan base-package="kr.or.ddit" use-default-filters="false">
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
		<context:include-filter type="annotation" expression="org.springframework.web.bind.annotation.ControllerAdvice"/>
	</context:component-scan>
 */
@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false,
			   includeFilters = {@Filter(type=FilterType.ANNOTATION, 
										  classes = {Controller.class, ControllerAdvice.class})})
//<mvc:annotation-driven/>
@EnableWebMvc
public class ApplicationContext extends WebMvcConfigurerAdapter{
	
	//<mvc:default-servlet-handler/> ==> extends 구현(WebMvcConfigurerAdapter)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/*view
	<bean id="profileImgView" class="kr.or.ddit.mvc.view.ProfileImgView"/>
	<bean id="jsonView" class="org.springframework.web.servlet.view.json.MappingJackson2JsonView"/>
	<bean id="excelView" class="kr.or.ddit.mvc.view.ExcelDownloadView"/>*/
	
	@Bean
	public ProfileImgView profileImgView() {
		return new ProfileImgView();
	}
	
	@Bean 
	public MappingJackson2JsonView jsonView() {
		return new MappingJackson2JsonView();
	}
	
	@Bean 
	public ExcelDownloadView excelView(){
		return new ExcelDownloadView();
	}
	
	/*
	  <bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="1"/>
		</bean>
	 */
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver =
					new BeanNameViewResolver();
		beanNameViewResolver.setOrder(1);
		
		return beanNameViewResolver;
	}
	
	/*
	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>classpath:kr/or/ddit/config/tiles/tiles-definition.xml</value>
			</list>
		</property>
	</bean>*/
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer =
				new TilesConfigurer();
			tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles-definition.xml");
		
		return tilesConfigurer;
	}
	
	/*
	 <bean class="org.springframework.web.servlet.view.tiles3.TilesViewResolver">
		<property name="order" value="0"/>
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles3.TilesView"/>
	 </bean>     
	 */
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver =
				new TilesViewResolver();
		tilesViewResolver.setOrder(0);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	/*
	  <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		 	<property name="order" value="2"/>
			<property name="prefix" value="/WEB-INF/views/"/>
			<property name="suffix" value=".jsp"/>
	</bean>	
	 */
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = 
				new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}
	
	/*<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	  </bean>*/
	@Bean
	public MultipartResolver multipartResolver() {
		MultipartResolver multipartResolver = 
				new CommonsMultipartResolver();
		
		return multipartResolver;
	}
	
	/*<bean id="localeResolver"
			class="org.springframework.web.servlet.i18n.SessionLocaleResolver"/>*/
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	/*
	 <mvc:interceptors>	
			<mvc:interceptor>
				<mvc:mapping path="/**"/>
				<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
					<property name="paramName" value="lang"/>
				</bean>
			</mvc:interceptor>
		</mvc:interceptors>	
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor =
				new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}
	
	
	/*<mvc:resources mapping="/resources/**" location="/WEB-INF/views/error/" /> */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/WEB-INF/views/error/");
	}	
}




















