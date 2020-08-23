package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value= {"classpath:kr/or/ddit/config/spring/root-context.xml"})
public class IUserTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUser user;
	
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactory;
	
	@Autowired
	private UserVo userVo;
	
	@Test
	public void getNumberTest() {
		logger.debug("getNumberTest");
		
		assertNotNull(userVo);
		assertNotNull(sqlSessionFactory);
		assertNotNull(user);
		int result = user.getNumber(5);
		assertEquals(7, result);
	}

}
