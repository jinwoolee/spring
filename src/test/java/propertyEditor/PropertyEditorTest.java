package propertyEditor;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import propertyEditor.model.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class PropertyEditorTest {
	Logger logger = LoggerFactory.getLogger(PropertyEditorTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void propertyEditorTest() {
		/***Given***/

		/***When***/

		/***Then***/
		BoardVo boardVo = applicationContext.getBean("boardVo", BoardVo.class);
		logger.debug(boardVo.getReg_dt().toString());
	}	
}