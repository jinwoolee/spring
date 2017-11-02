package aop.target;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

public class AnnotationTarget {
	Logger logger = LoggerFactory.getLogger(AnnotationTarget.class);
	
	public void annotationTargetMethod() {
		logger.debug("annotationTargetMethod");
	}
}