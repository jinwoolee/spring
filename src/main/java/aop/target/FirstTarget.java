package aop.target;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class FirstTarget {
	Logger logger = LoggerFactory.getLogger(FirstTarget.class);
	
	public void firstTargetMethod() {
		logger.debug("firstTargetMethod");
	}
}