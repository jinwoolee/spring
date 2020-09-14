package kr.or.ddit.employees.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("employeesVo")
@Data
public class EmployeesVo {
	private int employee_id;
	private String first_name;
	private String last_name;
}
