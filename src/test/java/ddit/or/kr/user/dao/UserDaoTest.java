package ddit.or.kr.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/user/dao/application-context.xml",
								 "classpath:/ddit/or/kr/spring/config/context-datasource.xml",
								 "classpath:/ddit/or/kr/spring/config/context-transaction.xml"})


//bean 등록에 대한 설정 : application-context.xml
// datasouce / mybatis 설정 : context-datasource.xml
// 트랜잭션 : context-transaction.xml
public class UserDaoTest{
	private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void userListAllTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> list = userDao.userListAll();
		//for 문으로 logger를 이용한 출력

		/***Then***/
		assertTrue(list.size() > 0);
	}
	
	//사용자 추가
	@Test
	public void insertUser(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("BROWN2");
		userVo.setUserNm("BROWN2 name");
		userVo.setUserAlias("BROWN2 alias");
		
		/***When***/
		int insertCnt = userDao.insertUser(userVo); 

		/***Then***/
		assertEquals(1, insertCnt);
	}
	

}









