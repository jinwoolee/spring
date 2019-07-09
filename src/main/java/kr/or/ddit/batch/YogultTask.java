package kr.or.ddit.batch;

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

public class YogultTask {
	
	private static final Logger logger = LoggerFactory.getLogger(YogultTask.class);
	
	@Resource(name="jobLauncher")
	private JobLauncher jobLauhcher;
	
	@Resource(name="yogultJob")
	private Job yogultJob;
	
	public void yogultTask() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		logger.debug("=================yogultTask=================");
		jobLauhcher.run(yogultJob, new JobParameters());
	}
}









