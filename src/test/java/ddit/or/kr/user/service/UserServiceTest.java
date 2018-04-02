package ddit.or.kr.user.service;

import static org.junit.Assert.*; 

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ddit.or.kr.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/user/service/application-context.xml",
								 "classpath:/ddit/or/kr/spring/config/context-datasource.xml",
								 "classpath:/ddit/or/kr/spring/config/context-transaction.xml"})
public class UserServiceTest {

	@Resource(name="userService")
	private UserService userService;
	
	// @Before / @After
	
	//각 테스트 메소드가 실행되기전에 데이터 베이스를 초기화한다.
	@Before
	public void dbInit(){
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("/ddit/or/kr/test/dbinit/init.sql"));
		populator.setContinueOnError(false);
		
		//아래 datasource는 반드시 개발자 db 환경에서 실행되야된다.
		//spring 구성파일을 공유하지 않고, 직접 입력한다
		//이 부분을 실수하면 한강을 가야한다
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("sem");
		bds.setPassword("java");
				
		DatabasePopulatorUtils.execute(populator, bds);	
	}
	
	
	@Test
	public void userListAllTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> list = userService.userListAll();
		//for 문으로 logger를 이용한 출력

		/***Then***/
		assertTrue(list.size() > 0);
	}
	
	//사용자 추가
	@Test
	public void insertUser(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("TEST_BROWN2");
		userVo.setUserNm("BROWN2 name");
		userVo.setUserAlias("BROWN2 alias");
		
		/***When***/
		int insertCnt = userService.insertUser(userVo); 

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	//사용자 입력시 롤백 테스트
	@Test(expected=RuntimeException.class)
	public void insertUserExceptionTest() throws RuntimeException{
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("TEST_BROWN2");
		userVo.setUserNm("BROWN2 name");
		userVo.setUserAlias("BROWN2 alias");
		
		/***When***/
		int insertCnt = userService.insertUserException(userVo);
		
		/***Then***/
		assertEquals(2, insertCnt);
	}
}







