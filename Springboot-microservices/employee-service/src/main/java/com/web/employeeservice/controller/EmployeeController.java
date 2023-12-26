package com.web.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.employeeservice.Service.EmployeeService;
import com.web.employeeservice.dto.ApiResponseDto;
import com.web.employeeservice.dto.EmployeeDto;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@GetMapping("{employeeId}")
	public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable Long employeeId) {
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}
}
