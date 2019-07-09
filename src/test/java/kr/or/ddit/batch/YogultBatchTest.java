package kr.or.ddit.batch;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
					"classpath:kr/or/ddit/config/spring/application-datasource-dev.xml",
					"classpath:kr/or/ddit/config/spring/application-transaction.xml",
					"classpath:kr/or/ddit/config/spring/application-batch-dev.xml"})
public class YogultBatchTest {
	
	@Resource(name="jobLauncher")
	private JobLauncher jobLauhcher;
	
	@Resource(name="yogultJob")
	private Job yogultJob;
	
	
	/** 
	 * Method   : yogultBatchTest
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @throws Exception 
	 * Method 설명 : 발효유 일실적 생성 배치
	 */
	@Test
	public void yogultBatchTest() throws Exception {
		/***Given***/
		String st = "201907";

		/***When***/
		JobExecution jobExeuction = jobLauhcher.run(yogultJob, 
				new JobParametersBuilder().addParameter("ym", new JobParameter(st))
														.addLong("start_dt", System.currentTimeMillis())
														.toJobParameters());
		
		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExeuction.getExitStatus());
	}

}












