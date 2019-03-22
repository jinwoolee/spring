package kr.or.ddit.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration	//<context:annotation-config/>
@ComponentScan(basePackages={"kr.or.ddit"}, useDefaultFilters=false, 
	includeFilters={@Filter(type=FilterType.ANNOTATION, classes={Controller.class, ControllerAdvice.class})})
@EnableWebMvc	//<mvc:annotation-driven/>
public class ServletContext extends WebMvcConfigurerAdapter{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();	// <mvc:default-servlet-handler/>
	}
	
	
	//interceptor
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = 
					new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("paramName");
		registry.addInterceptor(localeChangeInterceptor).addPathPatterns("/**");
	}



	@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(0);
		return viewResolver;
	}
	
	@Bean
	public ViewResolver tilesViewsResolver(){
		TilesViewResolver viewResolver = new TilesViewResolver();
		viewResolver.setOrder(1);
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("classpath:kr/or/ddit/config/tiles/tiles.xml");
		return tilesConfigurer;
	}
	
	
	@Bean ViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver viewResolver = 
				new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}
	
	@Bean
	public View jsonView(){
		View view = new MappingJackson2JsonView();
		return view;
	}
	
	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = 
				new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1024*1024*3*5);
		multipartResolver.setMaxUploadSizePerFile(1024*1024*3);
		return multipartResolver;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		LocaleResolver localeResolver = new SessionLocaleResolver();
		return localeResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {	
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(0);
		registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/").setCachePeriod(0);
		registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/").setCachePeriod(0);
		registry.addResourceHandler("/error/**").addResourceLocations("/resources/error/");	
	}
}
