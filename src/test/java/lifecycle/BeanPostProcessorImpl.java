package lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor{
	Logger logger = LoggerFactory.getLogger(BeanPostProcessorImpl.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("BeanPostProcessorImpl postProcessBeforeInitialization " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		logger.debug("BeanPostProcessorImpl postProcessAfterInitialization " + beanName);
		return bean;
	}

}
