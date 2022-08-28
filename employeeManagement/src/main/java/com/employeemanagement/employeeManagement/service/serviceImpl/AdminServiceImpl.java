package com.employeemanagement.employeeManagement.service.serviceImpl;

import com.employeemanagement.employeeManagement.model.Admin;
import com.employeemanagement.employeeManagement.repo.AdminRepo;
import com.employeemanagement.employeeManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Override
    public String registerAdmin(Admin admin) {
        Admin existsAdmin = adminRepo.findByOrg(admin.getOrg());
        String msg = "Admin already there in our system";
        if (existsAdmin == null) {
            String name = admin.getName();
            String[] splitName = name.split(" ");
            String username = "";
            for (int i = 0; i < splitName.length; i++) {
                if (i == 0) username += splitName[i].toLowerCase();
                else username += splitName[i].toLowerCase().charAt(0);
            }
            admin.setEmail(username + "@" + admin.getOrg().toLowerCase() + ".com");
            admin.setUserName(username + "" + admin.getMobileNumber().substring(2, 5));
            adminRepo.save(admin);
            msg = "Admin registered";
        }
        return msg;

    }

    @Override
    public List<Admin> findAdminList() {
        return adminRepo.findAll();
    }

    @Override
    public Admin adminFromGivenOrg(String org) {
        return adminRepo.findByOrg(org);
    }

    @Override
    public Admin deleteAdminFromDB(int id) {
        Optional<Admin> admin = adminRepo.findById(id);
        Admin deletedAdmin=null;
        try{
            deletedAdmin = admin.get();
            adminRepo.delete(deletedAdmin);
        }catch(Exception exception){
            deletedAdmin = null;
        }
        return deletedAdmin;
    }
}
