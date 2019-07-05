package kr.or.ddit.testenv;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.config.spring.ApplicationDatasource_dev;
import kr.or.ddit.config.spring.ApplicationTransaction;
import kr.or.ddit.config.spring.RootContext;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:kr/or/ddit/config/spring/root-context.xml", 
//									  "classpath:kr/or/ddit/config/spring/application-datasource-dev.xml",
//									  "classpath:kr/or/ddit/config/spring/application-transaction.xml"})
@ContextConfiguration(classes = {RootContext.class, 
												ApplicationDatasource_dev.class,
												ApplicationTransaction.class})
public class LogicTestEnv {
	
	@Resource(name="datasource")
	private DataSource datasource;
	
	@Before
	public void setup() {
		ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
		rdp.setContinueOnError(false);
		rdp.addScript(new ClassPathResource("kr/or/ddit/testenv/dbInit.sql"));
		DatabasePopulatorUtils.execute(rdp, datasource);
	}
	
	@Ignore
	@Test
	public void dummy() {}

}
