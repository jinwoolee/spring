package ddit.or.kr.bean.collection;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
	
	//spring container 생성
	ApplicationContext context = new ClassPathXmlApplicationContext("ddit/or/kr/bean/collection/application-context.xml");
	
	
	@Test
	public void verifyPropertyTest() {
		/***Given***/
		//CollectionBean collectionBean = (CollectionBean)context.getBean("collectionBean");
		CollectionBean collectionBean = context.getBean("collectionBean", CollectionBean.class);
		
		/***When***/
		List list = collectionBean.getLists();
		Set set= collectionBean.getSets();
		Map map= collectionBean.getMaps();
		Properties properties= collectionBean.getPros();
		String msg = collectionBean.getMsg();
		
		/***Then***/
		assertNotNull(list);
		assertNotNull(set);
		assertNotNull(map);
		assertNotNull(properties);
		assertNotNull(msg);
		
		assertEquals(3, list.size());
		assertEquals(3, set.size());
		assertEquals(3, map.size());
		assertEquals(3, properties.size());
		assertEquals("hello", msg);
	}

}






