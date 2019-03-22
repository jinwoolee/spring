package kr.or.ddit.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.config.spring.ApplicationContext;
import kr.or.ddit.config.spring.DatasourceContext;
import kr.or.ddit.config.spring.TransactionContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes= {ApplicationContext.class, DatasourceContext.class, TransactionContext.class}
//		{"classpath:kr/or/ddit/config/spring/application-context.xml",
//		 "classpath:kr/or/ddit/config/spring/context-datasource.xml",
//		 "classpath:kr/or/ddit/config/spring/context-transaction.xml"}
		)

public class LogicTestConfig {
	
}
