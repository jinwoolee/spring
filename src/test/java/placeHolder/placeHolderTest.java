package placeHolder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import board.dao.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class placeHolderTest {
	Logger logger = LoggerFactory.getLogger(placeHolderTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void placeHoldTest() {
		logger.debug("start placeHolderTest");
		logger.debug("system.getProperty(\"username\") : {}", System.getProperty("username"));
		logger.debug("system.getEnv(\"username\") : {}", System.getenv("username"));
		
		
		//given
		DbProperties dbProperties = applicationContext.getBean("dbProperties", DbProperties.class);
																	
		//when
		
		//then
		logger.debug(dbProperties.toString());
		logger.debug(dbProperties.getDriver());
		logger.debug(dbProperties.getUrl());
		logger.debug(dbProperties.getUsername());
		logger.debug(dbProperties.getPassword());
		logger.debug(dbProperties.getAdmin());
		logger.debug(dbProperties.getTown());
		assertEquals("oracle.jdbc.driver.OracleDeriver", dbProperties.getDriver());
		assertEquals("jdbc:oracle:thin:@127.0.0.1:1521:XE", dbProperties.getUrl());
		assertEquals("dba", dbProperties.getUsername());
		assertEquals("admin", dbProperties.getPassword());
		assertEquals("brown", dbProperties.getAdmin());
		assertEquals("lineTown", dbProperties.getTown());
		
		logger.debug("end placeHolderTest");
	}
}