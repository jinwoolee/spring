package ddit.or.kr;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/ddit/or/kr/dummy.xml")
@WebAppConfiguration	//web 요청 테스트 활성화
public class SpringTestEnv {

	//@Autowired : type을 보고 bean injection --> 같은 interface 구현한 구현체가 2개 이상일경우 다른 @ 필요
	//@Qualified : 한정자를 통해 빈을 이름으로 제한할수 있다
	//위 두개의 조합은 @Resource(name="beanName")과 동일하다
	@Autowired
	//@Qualifier()
	protected WebApplicationContext webContext;
	
	protected MockMvc mockMvc;		//dispatcher Servlet역할
	
	@Before
	public void setUp(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}
	
	@Test
	public void dummy(){
		assertTrue(true);
	}
}
