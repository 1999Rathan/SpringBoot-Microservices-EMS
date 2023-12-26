package com.web.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

	Department findByDepartmentCode(String departmentCode);
	
}
