package com.web.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.web.employeeservice.dto.EmployeeDto;
import com.web.employeeservice.entity.Employee;

@Mapper
public interface EmployeeMapper {
	
	EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);
	
	Employee mapToEmployee(EmployeeDto employeeDto);
	
	EmployeeDto mapToEmpoyeeDto(Employee employee);

}
