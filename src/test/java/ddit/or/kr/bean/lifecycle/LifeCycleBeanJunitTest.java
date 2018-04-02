package ddit.or.kr.bean.lifecycle;

import static org.junit.Assert.*;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//junit환경에서 스프링을 사용하기 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/bean/lifecycle/application-context.xml"})
public class LifeCycleBeanJunitTest {
	Logger logger = LoggerFactory.getLogger(LifeCycleBeanJunitTest.class);

	@Resource(name="lifeCycleBean")
	private LifeCycleBean lifeCycleBean;
	
	@Test
	public void lifeTest() {
		/***Given***/
		
		/***When***/
		Bean bean = lifeCycleBean.getBean();
		
		/***Then***/
		assertEquals("sayHello", bean.sayHello());
		assertNotNull(lifeCycleBean);
	}

}



