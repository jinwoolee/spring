package kr.or.ddit.jdbc.dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@PropertySource(value={"classpath:/config/spring/db.properties"})
@EnableTransactionManagement(mode=AdviceMode.PROXY, proxyTargetClass=false)
@MapperScan(basePackages="kr.or.ddit.jdbc.dao", annotationClass=MyBatis.class)
@ComponentScan(basePackages = {"kr.or.ddit.jdbc.dao"} ,useDefaultFilters = true, includeFilters = {@Filter(Repository.class)})
public class ApplicationConfig implements TransactionManagementConfigurer {
	

	@Autowired
    private Environment env;
	
	@Bean
	public DataSource dataSource() {	
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		ds.setValidationQuery("select 1 from dual");
		return ds;
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionfactoryBean = new SqlSessionFactoryBean();
		sqlSessionfactoryBean.setConfigLocation(new ClassPathResource("config/mybatis/sql-map-config.xml"));
		sqlSessionfactoryBean.setDataSource(dataSource());
		return sqlSessionfactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		return new SqlSessionTemplate(sqlSessionFactory());
	}
}