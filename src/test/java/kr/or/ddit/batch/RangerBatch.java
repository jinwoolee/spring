package kr.or.ddit.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RangerBatch {
	
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:kr/or/ddit/config/spring/application-batch-dev.xml");
		
		JobLauncher jobLauncher = (JobLauncher)context.getBean("jobLauncher");
		Job rangerJob = (Job)context.getBean("rangerJob");
		
		try {
			
			jobLauncher.run(rangerJob, new JobParameters());
			
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}
}











