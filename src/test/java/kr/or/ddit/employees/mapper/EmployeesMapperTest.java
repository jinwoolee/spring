package kr.or.ddit.employees.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.or.ddit.employees.model.EmployeesVo;

@SpringBootTest
class EmployeesMapperTest {
	
	Logger logger = LoggerFactory.getLogger(EmployeesMapperTest.class);

	@Autowired
	private EmployeesMapper employeesMapper;
	
	@Autowired
	private EmployeesVo employeesVo;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	void getListTest() {
		int employees_id = 100;
		List<Map<String, String>> employeesList =employeesMapper.getList(employees_id);
		logger.debug("employeesList : {}", employeesList);
		
		assertNotNull(employeesMapper);
		assertNotNull(employeesVo);
		assertNotNull(dataSource);
	}

}
