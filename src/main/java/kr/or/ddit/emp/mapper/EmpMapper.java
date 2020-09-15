package kr.or.ddit.emp.mapper;

import java.util.List;
import java.util.Map;

public interface EmpMapper {
	List<Map<String, String>> getList(int employee_id);
}
