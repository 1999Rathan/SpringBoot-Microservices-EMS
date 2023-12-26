package com.web.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.web.departmentservice.dto.DepartmentDto;
import com.web.departmentservice.entity.Department;

@Mapper
public interface DepartmentMapper {
	
	DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);
	
	DepartmentDto mapToDepartmentDto(Department department);
	
	Department mapToDepartment(DepartmentDto departmentDto);

}
