package ddit.or.kr.bean.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class LifeCycleBean implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {
	Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);
	
	private Bean bean;
	
	public Bean getBean() {
		return bean;
	}

	public void setBean(Bean bean) {
		this.bean = bean;
	}

	public LifeCycleBean(){
		logger.debug("LifeCycleBean");
	}
	
	//BeanNameAware
	@Override
	public void setBeanName(String name) {
		logger.debug("setBeanName {}", name );
	}

	//ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		
		//applicationContext 스프링 컨테이너를 통해 다른 bean을 DL을통해 활용할수 있다
		Bean bean = applicationContext.getBean("bean", Bean.class);
		logger.debug("setApplicationContext {}", bean.sayHello());
		
	}

	//InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("afterPropertiesSet");
	}

	//DisposableBean
	//debug 출력에러
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		logger.debug("destroy");
	}

	
	public void initMethod(){
		logger.debug("initMehtod");
	}
	
	public void destroyMethod(){
		logger.debug("destroyMehtod");
	}
	
	@PostConstruct
	public void postConstruct(){
		logger.debug("postConstruct");
	}
	
	@PreDestroy
	public void preDestory(){
		logger.debug("preDestory");
	}
}















