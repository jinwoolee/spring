package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/ioc/application-context-placeholder.xml"})
public class PlaceHolderTest {
	
	@Resource(name="placeHolder")
	private PlaceHolder placeHolder;
	
	@Test
	public void placeHodlerTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertEquals("semtest", placeHolder.getUser());
		assertEquals("java", placeHolder.getPassword());
		assertEquals("oracle.jdbc.driver.OracleDriver", placeHolder.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", placeHolder.getUrl());
	}
}
