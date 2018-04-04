package batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class BatchJobAnnotation {
	private Logger logger = LoggerFactory.getLogger(BatchJobAnnotation.class); 
	
	@Scheduled(cron="*/5 * * * * *")
	public void scheduleJob() {
		logger.debug("{}", "annotation scheduleJob()");
	}
}
