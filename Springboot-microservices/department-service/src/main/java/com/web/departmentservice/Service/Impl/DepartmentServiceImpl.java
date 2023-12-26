package com.web.departmentservice.Service.Impl;

import org.springframework.stereotype.Service;

import com.web.departmentservice.Service.DepartmentService;
import com.web.departmentservice.dto.DepartmentDto;
import com.web.departmentservice.entity.Department;
import com.web.departmentservice.mapper.DepartmentMapper;
import com.web.departmentservice.repository.DepartmentRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
		
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
		
		return savedDepartmentDto;
		
	}

	@Override
	public DepartmentDto getDepartmentByCode(String code) {
		
		Department department = departmentRepository.findByDepartmentCode(code);
		
		return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
	}

}
