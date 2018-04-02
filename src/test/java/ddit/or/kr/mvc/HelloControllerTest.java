package ddit.or.kr.mvc;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import ddit.or.kr.SpringTestEnv;

@ContextConfiguration("classpath:/ddit/or/kr/mvc/application-context.xml")
public class HelloControllerTest extends SpringTestEnv{
	
	@Resource(name="helloController")
	private HelloController helloController;
	
	//junit @Before : @Test 어노테이션이 적용된 테스트 메소드가 호출되기전, 각 메소드 마다 매번 호출
	//junit @After : @Test 어노테이션이 적용된 테스트 메소드가 실행된 이후, 각 메소드 마다 매번 호출
	
	//junit @BeforeClass : 해당 테스트 클래스 초기화시 한번 실행 (제한 사항 : static method로 선언해야함)
	//junit @AfterClass : 해당 테스트 클래스 종료시 한번 실행 (제한 사항 : static method로 선언해야함)
	
	@After
	public void tearDown(){
		
	}
	
	//helloController bean 정상적으로 생성되었는지 테스트 (생성 여부는 지금까지 해온 방법 : assertNotNull)
	@Test
	public void helloControllerNotNulltest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(helloController);
	}
	
	// /sayHello.do 요청 테스트
	@Test
	public void sayHelloRequestTest() throws Exception{
		//1. url 요청 http method :post, get
		mockMvc.perform(get("/hello/sayHello.do").param("userId", "brownId"))
		.andExpect(view().name("sayHello.jsp"))					//반환된 view 이름이 sayHello.jsp
		//.andExpect(model().attributeExists("userName"))		//model에 userName 속성이 존재
		.andExpect(request().attribute("userName", "brown"))	//userName 속성의 값은 brown
		.andExpect(request().attribute("userId", "brownId"));	//userId 속성의 값은 brownId
		
	}
	
	// /hello.do 요청 테스트 ( /hello/sayHello.do, /hello/hello.do는 
	//같은 controller의 같은 메소드 (sayHello)에서 처리된다
	@Test
	public void helloRequestTest() throws Exception{
		//1. url 요청 http method :post, get
		mockMvc.perform(get("/hello/hello.do").param("userId", "brownId"))
		.andExpect(view().name("sayHello.jsp"))					//반환된 view 이름이 sayHello.jsp
		//.andExpect(model().attributeExists("userName"))		//model에 userName 속성이 존재
		.andExpect(request().attribute("userName", "brown"))	//userName 속성의 값은 brown
		.andExpect(request().attribute("userId", "brownId"));	//userId 속성의 값은 brownId
	}

}







