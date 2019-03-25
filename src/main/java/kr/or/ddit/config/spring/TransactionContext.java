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


@Import(value={DatasourceContext.class})
@Configuration
public class TransactionContext implements TransactionManagementConfigurer{
	private Logger logger = LoggerFactory.getLogger(TransactionContext.class);
	
	@Resource(name="datasource")
	private DataSource datasource;
	
	@Bean
	public PlatformTransactionManager trasnsactionManager(){
		logger.debug("trasnsactionManager : {}", datasource);
		
		DataSourceTransactionManager transactionManager =
				new DataSourceTransactionManager();
			transactionManager.setDataSource(datasource);
		return transactionManager;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return trasnsactionManager();
	}
	
//	<bean id="transactionManager"
//		 	class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
//		 	<property name="dataSource" ref="datasource"/>
//		 </bean>
//		 
//		 <!--
//		 	<tx:method rollback-for : ""/>
//		 	기본설적으로 RuntimeExcpetion이 발생할 경우 자동 rollback처리  
//		 	RuntimeException이 아닌 다른 예외 발생시 rollback 을 처리 하고 싶을 때 설정하는 옵션
//		 
//		  -->
//		 <tx:advice id="txAdvice" transaction-manager="transactionManager">
//		 	<tx:attributes>
//		 		<tx:method name="*" propagation="REQUIRED"/>
//		 	</tx:attributes>
//		 </tx:advice>
//		 
//		 <aop:config>
//		 	<aop:advisor advice-ref="txAdvice" 
//		 				 pointcut="within(kr.or.ddit..service.*)"/>
//		 </aop:config>
