package ddit.or.kr.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.aop.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/aop/application-context-annotation.xml"})
public class AopAnnotationTest {
	
	//어노테이션, context component scan 정상동작 확인
	//servict
	@Resource(name="aopServiceImpl")		//AopServiceImpl implements AopService
	private AopService aopService;
	
	@Test
	public void aopServiceNotNullTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(aopService);
	}
	
	@Test
	public void annotationAopTest(){
		/***Given***/
		
		/***When***/

		/***Then***/
		//LogginAnnotationAdvice의 before 메소드만 설정된 상태
		aopService.getRangers();
	}
	

}










