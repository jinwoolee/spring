package kr.or.ddit.test.dao;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.test.model.TestVo;

@Repository
public class TestDao {
	
	public List<TestVo> getUserList(){
		
		List<TestVo> userList = new ArrayList<TestVo>();
		
		userList.add(new TestVo("brown", 500, new GregorianCalendar(2017, 10, 3).getTime()));
		userList.add(new TestVo("cony", 600, new GregorianCalendar(2017, 10, 4).getTime()));
		userList.add(new TestVo("sally", 700, new GregorianCalendar(2017, 10, 5).getTime()));
		
		return userList;
	}

	@Override
	public String toString() {
		return "TestDao []";
	}
}