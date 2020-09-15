package kr.or.ddit.emp.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import kr.or.ddit.emp.mapper.EmpMapper;
import kr.or.ddit.emp.model.EmpVo;

@ActiveProfiles("prd")
@SpringBootTest
class EmpMapperTest {
	
	Logger logger = LoggerFactory.getLogger(EmpMapperTest.class);

	@Autowired
	private EmpMapper employeesMapper;
	
	@Test
	void getListTest() {
		int empno = 9999;
		List<Map<String, String>> empVoList =employeesMapper.getList(empno);
		logger.debug("empVoList : {}", empVoList);
		
		assertNotNull(employeesMapper);
	}

}
