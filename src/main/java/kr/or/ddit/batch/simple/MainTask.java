package kr.or.ddit.batch.simple;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;

public class MainTask {
	private static final Logger logger = LoggerFactory.getLogger(MainTask.class);
	
	@Resource(name="jobLauncher")
	private JobLauncher jobLauncher;
	
	@Resource(name="rangerJob")
	private Job rangerJob;
	
	public void runScheduler() {
		//logger.debug("jobLaucher, rangerJob : {}, {}", jobLauncher, rangerJob);
		
		try {
			jobLauncher.run(rangerJob, new JobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}




