package conversion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import conversion.model.FormattVo2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context-formatting.xml"})
public class FormattingConversionServiceTest {
	Logger logger = LoggerFactory.getLogger(FormattingConversionServiceTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void formattingConversionServiceTest() {
		/***given***/
		FormattVo2 formattVo2 = applicationContext.getBean("formattVo2", FormattVo2.class);
		
		/***when***/

		/***then***/
		logger.debug("{} : {}", "formattVo2.getAmount()",  formattVo2.getAmount());
	}	
}