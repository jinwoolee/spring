package kr.or.ddit.employees.mapper;

import java.util.List;
import java.util.Map;

public interface EmployeesMapper {
	List<Map<String, String>> getList(int employee_id);
}
