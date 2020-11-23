package kr.or.ddit.batch.basic;

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

public class BasicBatchTask {
	
	private static final Logger logger = LoggerFactory.getLogger(BasicBatchTask.class);
	
	@Resource(name="jobLauncher")
	private JobLauncher jobLauncher;
	
	@Resource(name="basicJob")
	private Job basicJob;
	
	/*public JobLauncher getJobLauncher() {
		return jobLauncher;
	}
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}
	public Job getBasicJob() {
		return basicJob;
	}
	public void setBasicJob(Job basicJob) {
		this.basicJob = basicJob;
	}*/

	public void task() {
		logger.debug("=====task()=====");
		try {
			jobLauncher.run(basicJob, new JobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
		logger.debug("=====task()=====");
	}
}








