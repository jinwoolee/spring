package kr.or.ddit.batch.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
		{"classpath:kr/or/ddit/config/spring/batch-context.xml"})
public class BasicJobTest {
	
	// batch 테스트시 주의점
	// spring 컨테이너에 job이 하나만 등록이 되어 있어야함
	
	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;
	
	@Test
	public void basicJobTest() throws Exception {
		/***Given***/

		/***When***/
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		/***Then***/
		assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}

}





