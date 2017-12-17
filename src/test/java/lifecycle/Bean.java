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
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class Bean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware  {
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
		logger.debug("3.setApplicationContext");
	}

	@PostConstruct
	public void postConstruct() {
		logger.debug("4.postConstruct");
	}
	
	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("5.afterPropertiesSet");
	}
	
	//init-method
	public void initMethod() {
		logger.debug("6.initMethod");
	}
	
	
	@PreDestroy
	public void preDestory() {
		logger.debug("9.preDestory");
	}
	
	//DisposableBean
	@Override
	public void destroy() throws Exception {
		logger.debug("10.destory");
	}
	
	public void destoryMethod() {
		logger.debug("11.destoryMethod");
	}


	//BeanFactoryAware
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		logger.debug("{}", "setBeanFactory");
	}

	//ResourceLoaderAware
	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		logger.debug("{}", "setResourceLoader");
	}

	//ApplicationEventPublisherAware
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		logger.debug("{}", "setApplicationEventPublisher");
	}

	//MessageSourceAware
	@Override
	public void setMessageSource(MessageSource arg0) {
		logger.debug("{}", "setMessageSource");
	}
	
}