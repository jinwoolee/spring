package kr.or.ddit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//repository + service : root-context.xml
//sqlSessionTemplate : datasource-context.xml
//transaction : transaction-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = 
				{"classpath:kr/or/ddit/config/spring/root-context.xml",
				 "classpath:kr/or/ddit/config/spring/datasource-context.xml",
				 "classpath:kr/or/ddit/config/spring/transaction-context.xml"})
public class ModelTestConfig {
	
	@Ignore
	@Test
	public void dummy() {
		
	}
}
