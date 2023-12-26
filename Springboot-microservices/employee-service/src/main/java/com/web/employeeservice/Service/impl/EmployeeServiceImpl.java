package com.web.employeeservice.Service.impl;

//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.web.employeeservice.Repository.EmployeeRepository;
import com.web.employeeservice.Service.APIClient;
import com.web.employeeservice.Service.EmployeeService;
import com.web.employeeservice.dto.ApiResponseDto;
import com.web.employeeservice.dto.DepartmentDto;
import com.web.employeeservice.dto.EmployeeDto;
import com.web.employeeservice.entity.Employee;
import com.web.employeeservice.mapper.EmployeeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
//	private WebClient webClient;
	
	private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmpoyeeDto(savedEmployee);
		
		return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId).get();
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/"+employee.getDepartmentCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();
		
//		DepartmentDto departmentDto = webClient.get()
//				 .uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
//				 .retrieve()
//				 .bodyToMono(DepartmentDto.class)
//				 .block();
		
		DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		System.out.println(departmentDto);
		
		EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmpoyeeDto(employee);
		
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		
		return apiResponseDto;
	}

}
