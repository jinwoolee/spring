package aop.target;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class SecondTarget {
	Logger logger = LoggerFactory.getLogger(SecondTarget.class);
	
	public void secondTargetMethod() {
		logger.debug("firstTargetMethod");
	}
}