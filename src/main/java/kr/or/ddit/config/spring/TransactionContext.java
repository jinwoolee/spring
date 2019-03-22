package kr.or.ddit.config.spring;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

//<tx:annotation-driven/>	transactionManger는 platformTransctionManger 타입의 빈을 자동으로 검색하여 사용
//<tx:adrvice> <aop>를 이용한 java config는 불가
@EnableTransactionManagement	
@Configuration
public class TransactionContext {
	private Logger logger = LoggerFactory.getLogger(TransactionContext.class);
	
	//@Resource(name="datasource")
	//private DataSource datasource;
	
	@Bean
	public PlatformTransactionManager trasnsactionManager(DataSource datasource){
		logger.debug("trasnsactionManager : {}", datasource);
		
		DataSourceTransactionManager transactionManager =
				new DataSourceTransactionManager();
			transactionManager.setDataSource(datasource);
		return transactionManager;
	}
}
