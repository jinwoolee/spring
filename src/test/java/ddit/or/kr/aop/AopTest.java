package ddit.or.kr.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.aop.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/aop/application-context.xml"})
public class AopTest {

	@Resource(name="aopService")
	private AopService aopService;
	
	//aop 적용여부 확인(logging 결과를 눈으로 확인한다.)
	@Test
	public void aopTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		//aopService.getkakaoFriends();
		aopService.getRangers();
		assertNotNull(aopService);
	}

	//after throwing 이 정상적으로 실행되는지 테스트
	@Test
	public void afterThrowingTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		try {
			aopService.throwException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}








