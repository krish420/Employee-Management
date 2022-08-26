package com.employeemanagement.employeeManagement.service;

import com.employeemanagement.employeeManagement.model.Admin;

import java.util.List;

public interface AdminService {
    String registerAdmin(Admin admin);
    List<Admin> findAdminList();
    Admin adminFromGivenOrg(String org);
}
