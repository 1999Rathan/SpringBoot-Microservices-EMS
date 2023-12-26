package com.web.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.departmentservice.Service.DepartmentService;
import com.web.departmentservice.dto.DepartmentDto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/department")
public class DepartmentController {
	
	private DepartmentService departmentService;

//	public DepartmentController(DepartmentService departmentService) {
//		super();
//		this.departmentService = departmentService;
//	}
//	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	
	@GetMapping("{departmentCode}")
	public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode) {
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
}
