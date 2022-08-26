package com.employeemanagement.employeeManagement.repo;

import com.employeemanagement.employeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {}
