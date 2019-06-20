package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.user.model.UserVo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/ioc/application-ioc-type-convert.xml")
public class ApplicationIocTypeConvertTest {
	
	//userVo라는 이름의 스프링 빈이 정상적으로 생성 되었는지 확인
	@Resource(name="userVo")
	private UserVo userVo;
	
	@Test
	public void typeInjectionTest() {
		/***Given***/
		
		/***When***/
		Date birth = userVo.getBirth();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String birth_str = sdf.format(birth);
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals("2019-08-08", birth_str);
	}

}






