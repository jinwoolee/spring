package ddit.or.kr.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.aop.service.AopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopAnnotationConfig.class)
public class AopAnnotationConfigTest {

	@Resource
	private AopService aopService;
	
	//java config aop 어노테이션 component scan test
	@Test
	public void javaConfigAopCscanTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		aopService.getRangers();
		assertNotNull(aopService);
	}

}
