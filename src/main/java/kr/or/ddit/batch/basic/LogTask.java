package kr.or.ddit.batch.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTask {
	private static final Logger logger = LoggerFactory.getLogger(LogTask.class);
	
	public void logging() {
		logger.debug("logging()");
	}
}
