package ddit.or.kr.bean.lifecycle;

import org.junit.Test; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleBeanTest {
	Logger logger = LoggerFactory.getLogger(LifeCycleBeanTest.class);
	
	//spring 컨테이너를 생성
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ddit/or/kr/bean/lifecycle/application-context.xml");

	@Test
	public void lifeTest() {
		/***Given***/
		
		/***When***/
		LifeCycleBean lifeCycleBean = context.getBean("lifeCycleBean", LifeCycleBean.class);

		/***Then***/
		
		context.close();
	}

}







