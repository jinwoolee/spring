package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Bean implements BeanNameAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {
	Logger logger = LoggerFactory.getLogger(Bean.class);
	
	public Bean() {
		logger.debug("Bean 생성자");
	}

	//BeanPostProcessor 빈객체 초기화시 특정 작업을 수행할 수 있다.
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("postProcessBeforeInitialization " + beanName);
		return bean;
	}

	//BeanPostProcessor 빈객체 초기화시 특정 작업을 수행할 수 있다.
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("postProcessAfterInitialization " + beanName);
		return bean;
	}

	//ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		logger.debug("setApplicationContext");
	}

	//BeanNameWare
	@Override
	public void setBeanName(String name) {
		logger.debug("setBeanName " + name);
	}

	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		logger.debug("destory");
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.debug("postConstruct");
	}
	
	@PreDestroy
	public void preDestory() {
		logger.debug("preDestory");
	}
	
	public void initMethod() {
		logger.debug("initMethod");
	}
	
	public void destoryMethod() {
		logger.debug("destoryMethod");
	}
}