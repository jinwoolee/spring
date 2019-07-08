package kr.or.ddit.batch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/application-batch-dev.xml"})
public class RangerBatchJobLauncherTestUtilsTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void rangerBatchTest() throws Exception {
		/***Given***/

		/***When***/
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
		
	}

}








