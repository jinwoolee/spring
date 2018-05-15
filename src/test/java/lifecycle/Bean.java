package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class Bean implements BeanNameAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {
	Logger logger = LoggerFactory.getLogger(Bean.class);
	
	public Bean() {
		logger.debug("1.Bean 생성자");
	}

	//BeanNameAware
	@Override
	public void setBeanName(String name) {
		logger.debug("2.setBeanName " + name);
	}
		
	//ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.debug("7.setApplicationContext");
	}

	@PostConstruct
	public void postConstruct() {
		logger.debug("8.postConstruct");
	}
	
	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("9.afterPropertiesSet");
	}
	
	//init-method
	public void initMethod() {
	}
	
	
	@PreDestroy
	public void preDestory() {
		logger.debug("13.preDestory");
	}
	
	//DisposableBean
	@Override
	public void destroy() throws Exception {
		logger.debug("14.destory");
	}
	
	public void destoryMethod() {
		logger.debug("15.destoryMethod");
	}


	//BeanFactoryAware
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.debug("{}", "3.setBeanFactory");
	}

	//ResourceLoaderAware
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		logger.debug("{}", "4.setResourceLoader");
	}

	//ApplicationEventPublisherAware
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		logger.debug("{}", "5.setApplicationEventPublisher");
	}

	//MessageSourceAware
	@Override
	public void setMessageSource(MessageSource arg0) {
		logger.debug("{}", "6.setMessageSource");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("11.BeanPostProcessorImpl postProcessBeforeInitialization " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("12.BeanPostProcessorImpl postProcessAfterInitialization " + beanName);
		return bean;
	}
	
}