package ddit.or.kr.bean.javaconfig.cscan;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.bean.javaconfig.cscan.dao.MessageDao;
import ddit.or.kr.bean.javaconfig.cscan.service.MessageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={JavaConfig.class})
public class JavaConfigTest {

	//java config + java compononent scan
	
	@Resource(name="messageDao")
	private MessageDao messageDao;
	
	@Resource(name="messageService")
	private MessageService messageService;
	
	//messageDao, messageService null이 아니면 정상적으로 설정이 동작
	@Test
	public void javaconfigCscanTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertNotNull(messageDao);
		assertNotNull(messageService);
	}

}





