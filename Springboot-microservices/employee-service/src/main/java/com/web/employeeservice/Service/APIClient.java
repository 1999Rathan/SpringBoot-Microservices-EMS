package com.web.employeeservice.Service;

import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.web.employeeservice.dto.ApiResponseDto;
import com.web.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
	
	@GetMapping("api/department/{departmentCode}")
	public DepartmentDto getDepartment(@PathVariable String departmentCode);
}
