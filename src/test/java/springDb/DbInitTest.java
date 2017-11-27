package springDb;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import user.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springDb/application-context.xml",
								"/springDb/context-datasource.xml"})
public class DbInitTest {
	//Logger logger = LoggerFactory.getLogger(DbInitTest.class);
	
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void getUserlistTest() {
		List<Map<String, String>> userList =  userDao.getUserList();
		for(Map<String, String> map : userList)
			System.out.println(map);
			//logger.debug(map.toString());
	}

}
