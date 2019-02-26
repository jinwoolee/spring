package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-context-placeholder.xml")
public class DbPropertiesTest {
	
	@Resource(name="dbProperties")
	private DbProperties dbProperties;
	
	/**
	 * Method : testPlaceholder
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : property placeholder 테스트
	 */
	@Test
	public void testPlaceholder() {
		/***Given***/
		
		/***When***/
		String url = dbProperties.getUrl();
		String driverClassName = dbProperties.getDriverClassName();
		String username = dbProperties.getUsername();
		String password = dbProperties.getPassword();

		/***Then***/
		assertEquals("jdbc:oracle:thin:@localhost:1521:XE", url);
		assertEquals("oracle.jdbc.driver.OracleDriver", driverClassName);
		assertEquals("sem_pc", username);
		assertEquals("java", password);
	}

}






