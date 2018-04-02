package ddit.or.kr.bean.pholder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PlaceHolderTest {
	Logger logger = LoggerFactory.getLogger(PlaceHolderTest.class);
	
	//spring 컨테이너 생성 (spring 컨테이너 == ioc 컨테이너)
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("ddit/or/kr/bean/pholder/application-context.xml");
	
	//db.properties 파일의 속성값이 placeHolder bean 속성에 정상적으로 주입되었는지 테스트
	@Test
	public void verifyPropertyTest() {
		/***Given***/

		/***When***/
		PlaceHolder pholder = context.getBean("placeHolder", PlaceHolder.class);

		/***Then***/
		logger.debug("{}", pholder.getDriver());
		logger.debug("{}", pholder.getUrl());
		logger.debug("{}", pholder.getDbuser());
		logger.debug("{}", pholder.getPassword());
		logger.debug("System.getProperty(\"username\") : {} ", System.getProperty("username"));
		logger.debug("System.getenv(\"username\") : {} ", System.getenv("username"));
		assertEquals("oracle.jdbc.driver.OracleDriver", pholder.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", pholder.getUrl());
		assertEquals("java", pholder.getDbuser());
		assertEquals("java", pholder.getPassword());
		
		
		
		

	}

}




