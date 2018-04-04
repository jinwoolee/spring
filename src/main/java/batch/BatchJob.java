package batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class BatchJob {
	private Logger logger = LoggerFactory.getLogger(BatchJob.class); 
	
	public void scheduleJob() {
		logger.debug("{}", "scheduleJob()");
	}
}
