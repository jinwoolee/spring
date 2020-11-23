package kr.or.ddit.batch.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BasicBatchTaskApplication {

	public static void main(String[] args) {
		// task-scheduler-context.xml을 이용하여 스프링 컨테이너를 생성
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
						"classpath:kr/or/ddit/config/spring/batch-task-context.xml");
	}

}







