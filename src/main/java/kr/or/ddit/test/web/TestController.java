
package kr.or.ddit.test.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.test.dao.TestDao;

@RequestMapping("/test.do")
@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping(method=RequestMethod.GET)
	public String testPage() {
		
		TestDao testDao = applicationContext.getBean("testDao", TestDao.class);
		logger.debug(testDao.toString());
		
		return "test/test";
	}
}