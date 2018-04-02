package ddit.or.kr.bean.javaconfig.cscan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ddit.or.kr.bean.javaconfig.cscan.dao.MessageDao;
import ddit.or.kr.bean.javaconfig.cscan.service.MessageService;

//bean : annotation을 통한 빈 설정
//javaconfig : annotation scan

//xml <context:component-scan base-package="ddit.or.kr.bean.scan.dao, ddit.or.kr.bean.scan.service">
//</context:component-scan>

//<context:component-scan --> @ComponentScan
//base-package --> basePackages
@Configuration
//@ComponentScan(basePackages={"ddit.or.kr.bean.javaconfig.cscan.dao", "ddit.or.kr.bean.javaconfig.cscan.service"})
@ComponentScan(basePackageClasses={MessageDao.class, MessageService.class})
public class JavaConfig {

}









