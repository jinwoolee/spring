package collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import board.dao.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class CollectionBeanTest {
	Logger logger = LoggerFactory.getLogger(CollectionBeanTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void defaultScopeTest() {
		logger.debug("start collectionBeanTest");
		
		//given
		CollectionBean collectionBean= applicationContext.getBean("collectionBean", CollectionBean.class);
		
		//when
		
		//then
		assertNotNull(collectionBean.getLists());
		assertNotNull(collectionBean.getMaps());
		assertNotNull(collectionBean.getPros());
		assertNotNull(collectionBean.getSets());
		logger.debug(collectionBean.toString());
		
		logger.debug("end collectionBeanTest");
	}
	
	@Test
	public void mapBeanTest() {
		logger.debug("start mapBeanTest");
		
		/***Given***/
		Map map = applicationContext.getBean("map", HashMap.class);
		
		/***When***/

		/***Then***/
		assertNotNull(map);
		logger.debug(map.toString());
		logger.debug("end mapBeanTest");
	}
}