package springDb;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import user.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springDb/application-context.xml",
								"/springDb/context-datasource.xml"})
public class DbInitTest {
	Logger logger = LoggerFactory.getLogger(DbInitTest.class);
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Resource(name="dataSource")
	private	DataSource dataSource;

	@Before
	public void setup() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/springDb/init.sql"));
		populator.setContinueOnError(true);
		DatabasePopulatorUtils.execute(populator , dataSource);
	}
	
	@After
	public void tearDown() {
		//test 실행이 완료된 이후 정리 작업
	}
	
	@Test
	public void getUserlistTest() {
		List<Map<String, String>> userList =  userDao.getUserList();
		assertEquals(3, userList.size());
	}
}