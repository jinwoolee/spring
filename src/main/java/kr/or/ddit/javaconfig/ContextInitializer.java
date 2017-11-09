package kr.or.ddit.javaconfig;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootContext.class, ContextDatasource.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ApplicationConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);
		
	    FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", encodingFilter);
	    
	    characterEncoding.addMappingForUrlPatterns( EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), false, "/*");
	    characterEncoding.setAsyncSupported(true);
		super.onStartup(servletContext);
	}
}