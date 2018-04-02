package ddit.or.kr.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.aop.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/aop/application-context-profile.xml"})
public class AopProfileTest {
	
	Logger logger = LoggerFactory.getLogger(AopProfileTest.class);
	@Resource(name="AopService")
	private AopService aopService;
	
	@Test
	public void aopTimeTest() {
		/***Given***/
		/***When***/
		/***Then***/
		
		aopService.getkakaoFriends();
		

	}

}
