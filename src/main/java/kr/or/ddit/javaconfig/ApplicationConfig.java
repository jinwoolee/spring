package kr.or.ddit.javaconfig;

import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.tiles2.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

import kr.or.ddit.interceptors.PerformanceCheckInterceptor;

@Configuration

/*
 * <!-- controller bean scan --> <context:component-scan
 * base-package="kr.or.ddit" use-default-filters="false">
 * <context:include-filter type="annotation"
 * expression="org.springframework.stereotype.Controller" />
 * <context:include-filter type="annotation"
 * expression="org.springframework.web.bind.annotation.ControllerAdvice" />
 * <context:include-filter type="annotation"
 * expression="org.springframework.stereotype.Component" />
 * </context:component-scan>
 */
@ComponentScan(basePackages = { "kr.or.ddit" }, useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class) })

@EnableWebMvc // <mvc:annotation-driven>
public class ApplicationConfig extends WebMvcConfigurerAdapter {

	@Override // <mvc:default-servlet-handler >, WebMvcConfigurerAdapter
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	/*
	 * <mvc:interceptors> <mvc:interceptor> <mvc:mapping path="/**" />
	 * <mvc:exclude-mapping path="/hello.do" /> <bean
	 * class="kr.or.ddit.interceptors.PerformanceCheckInterceptor" />
	 * </mvc:interceptor>
	 * 
	 * <mvc:interceptor> <mvc:mapping path="/**" /> <bean
	 * class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor">
	 * <property name="paramName" value="language" /> </bean> </mvc:interceptor>
	 * </mvc:interceptors>
	 */

	@Override // <mvc:interceptors>
	public void addInterceptors(InterceptorRegistry registry) {
		PerformanceCheckInterceptor performanceInnterceptor = new PerformanceCheckInterceptor();
		registry.addInterceptor(performanceInnterceptor).addPathPatterns("/**").excludePathPatterns("/hello.do");

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}

	/*
	 * <bean id="messageSource"
		class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
		<property name="basenames">
			<list> <!-- 메세지 파일의 위치를 지정합니다. message_언어.properties 파일을 찾습니다. -->
				<value>classpath:/config/msg/error/error</value>
				<value>classpath:/config/msg/label/label</value>
			</list>
		</property>
		<property name="cacheSeconds" value="60" /><!-- properties 파일 변경확인 주기 -->
	</bean>
	*/
	 
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
		source.setBasenames("classpath:/config/msg/error/error", "classpath:/config/msg/label/label");
		source.setCacheSeconds(60);
		return source;
	}
	
	/*
	 * <bean id="msAccessor"
		class="org.springframework.context.support.MessageSourceAccessor">
		<constructor-arg>
			<ref local="messageSource" />
		</constructor-arg>
	</bean>
	 */
	@Bean
	public MessageSourceAccessor msAccessor() {
		MessageSourceAccessor msAccessor = new MessageSourceAccessor(messageSource());
		return msAccessor;
	}
	
	/*
	 *  <!-- 언어 정보를 세션에 저장하여 사용합니다. -->
		<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver" />
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	
	
	/*
	<!-- view resolver -->
	<bean class="org.springframework.web.servlet.view.BeanNameViewResolver">
		<property name="order" value="0" />
	</bean>

	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="order" value="2" />
		<property name="prefix" value="/WEB-INF/views/" />
		<property name="suffix" value=".jsp" />
	</bean>
	 */
	
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver bnViewResolver = new BeanNameViewResolver();
		bnViewResolver.setOrder(0);
		return bnViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver irViewResolver = new InternalResourceViewResolver();
		irViewResolver.setPrefix("/WEB-INF/views/");
		irViewResolver.setSuffix(".jsp");
		irViewResolver.setOrder(2);
		return irViewResolver;
	}
	
	/*
	 * <bean id="pageJsonReport" class="org.springframework.web.servlet.view.json.MappingJacksonJsonView" />
	 */
	
	@Bean
	public MappingJacksonJsonView pageJsosReport() {
		return new MappingJacksonJsonView();
	}
	
	
	/*
	 * 
	<!-- multipart resolver -->
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="100000000" />
		<property name="maxInMemorySize" value="100000000" />
	</bean>
	 */
	
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(100000000);
		multipartResolver.setMaxUploadSize(100000000);
		return multipartResolver;
	}
	
	/*
	 * <!-- tiles -->
	<bean class="org.springframework.web.servlet.view.tiles2.TilesViewResolver">
		<property name="order" value="1" />
		<property name="viewClass" value="org.springframework.web.servlet.view.tiles2.TilesView"/>
	</bean>
	
	<bean id="tilesConfigurer" class="org.springframework.web.servlet.view.tiles2.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/config/tiles/tiles.xml</value>
			</list>
		</property>
		<property name="preparerFactoryClass" value="org.springframework.web.servlet.view.tiles2.SpringBeanPreparerFactory"/>
	</bean>
	 */
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setOrder(1);
		tilesViewResolver.setViewClass(TilesView.class);
		
		return tilesViewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/WEB-INF/config/tiles/tiles.xml");
		tilesConfigurer.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
		
		return tilesConfigurer;
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(mappingJacksonHttpMessageConverter());
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setPrettyPrint(true);
		return converter;
	}
}