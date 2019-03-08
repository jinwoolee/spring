package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.test.LogicTestConfig;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest extends LogicTestConfig{
	
	@Resource(name="userDao")
	private IUserDao userDao;

	@Test
	public void testGetAllUser() {
		/***Given***/
		
		/***When***/
		List<UserVo> userList = userDao.getAllUser();
		
		/***Then***/
		assertTrue(userList.size() > 100);
		
	}

}











