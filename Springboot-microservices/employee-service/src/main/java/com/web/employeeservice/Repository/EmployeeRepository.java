package com.web.employeeservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
