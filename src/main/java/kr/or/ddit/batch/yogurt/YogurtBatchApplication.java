package kr.or.ddit.batch.yogurt;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class YogurtBatchApplication {

	public static void main(String[] args) {
		// batch-context.xml을 이용하여 스프링 컨테이너를 생성
		ApplicationContext context = new  ClassPathXmlApplicationContext(
				"classpath:kr/or/ddit/config/spring/datasource-context.xml",
			  	"classpath:kr/or/ddit/config/spring/transaction-context.xml",
			  	"classpath:kr/or/ddit/config/spring/yogurt-batch.xml");
		
		//jobLaucher, job 스프링빈 DL
		JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);
		Job yogurtJob = context.getBean("yogurtJob", Job.class);
		
		try {
			jobLauncher.run(yogurtJob, new JobParametersBuilder()
												.addString("ym", "202011")
												.addLong("st_dt", System.currentTimeMillis())
											.toJobParameters()   );
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

}







