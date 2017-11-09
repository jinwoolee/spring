package kr.or.ddit.javaconfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

/*
 * <context:property-placeholder location="classpath:config/spring/db.properties" />	
 */
@Configuration
@PropertySource(value = { "classpath:config/spring/db.properties" })
@ImportResource("classpath:config/spring/context-transaction-annotation.xml")
public class ContextDatasource{
/*
 * <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<property name="url" value="jdbc:oracle:thin:@127.0.0.1:1521:orcl" />
		<property name="username" value="pc01" />
		<property name="password" value="java" />
		<property name="validationQuery" value="select 1 from dual" />
	</bean>
 */
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
		basicDataSource.setUsername("pc01");
		basicDataSource.setPassword("java");
		basicDataSource.setValidationQuery("select 1 from dual");
		
		return basicDataSource;
	}
	
	/*
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="configLocation" value="classpath:config/mybatis/sql-map-config.xml"/>
	</bean>

	<bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory" />
	</bean>
	*/
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("config/mybatis/sql-map-config.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		
		return sqlSessionTemplate;
	}
	
	//
	/*<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" />
	</bean>
	
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<tx:method name="*" propagation="REQUIRED" />
			<tx:method name="get*" read-only="true" />
			<tx:method name="retrieve*" read-only="true" />
			<tx:method name="select*" read-only="true" />
		</tx:attributes>
	</tx:advice>
	
	<aop:config>
		<aop:advisor advice-ref="txAdvice" pointcut="within(kr.or.ddit..service..*)" />
	</aop:config>
	*/
}