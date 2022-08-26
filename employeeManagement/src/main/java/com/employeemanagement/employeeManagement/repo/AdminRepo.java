package com.employeemanagement.employeeManagement.repo;

import com.employeemanagement.employeeManagement.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,Integer> {
    Admin findByOrg(String org);
}
