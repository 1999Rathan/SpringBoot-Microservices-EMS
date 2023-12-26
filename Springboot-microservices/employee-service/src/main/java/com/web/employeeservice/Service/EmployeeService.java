package com.web.employeeservice.Service;

import com.web.employeeservice.dto.ApiResponseDto;
import com.web.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto getEmployeeById(Long employeeId);

}
