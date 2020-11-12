package kr.or.ddit.config.spring;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

//<context:property-placeholder location="classpath:kr/or/ddit/config/db/db.properties"/>
// ${key} ==> key
@PropertySource("classpath:kr/or/ddit/config/db/db.properties")
@Configuration
public class DataSourceContext {
	
	@Autowired
	private Environment env;
	
	/*
	 <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
	 	<property name="url" value="${jdbc.url}"/>
	 	<property name="driverClassName" value="${jdbc.driver}"/>
	 	<property name="username" value="${jdbc.username}"/>
	 	<property name="password" value="${jdbc.password}"/>
	 </bean>
	 */
	// <bean> ==> @Bean method
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = 
				new BasicDataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	/*
	 * SqlSessionFactoryBean.getObject()
	 <bean id="sqlSessionFactoryBean" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="configLocation" value="classpath:kr/or/ddit/config/db/mybatis-config.xml"/>
		<property name="dataSource" ref="dataSource"/>	 	
	 </bean>
	 */
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean factoryBean = 
				new SqlSessionFactoryBean();
		
		factoryBean.setConfigLocation(new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xml"));
		factoryBean.setDataSource(dataSource());
		
		return factoryBean.getObject();
	}
	
	/*
	  <bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
	 	<constructor-arg ref="sqlSessionFactoryBean"/>
	  </bean>
	 */
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate =
					new SqlSessionTemplate(sqlSessionFactoryBean());
		
		return sqlSessionTemplate;
	}
	
}









