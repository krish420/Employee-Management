package com.employeemanagement.employeeManagement.controller;

import com.employeemanagement.employeeManagement.model.Admin;
import com.employeemanagement.employeeManagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /* admin registration */
    @PostMapping("/signup")
    public ResponseEntity<String> adminReg(@RequestBody Admin admin){
        String bodyMsg = "";
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            bodyMsg = adminService.registerAdmin(admin);
        }catch (NullPointerException exception){
            bodyMsg = "Registration Failed "+exception.getMessage();
            httpStatus = HttpStatus.BAD_GATEWAY;
        }
        return new ResponseEntity<>(bodyMsg,httpStatus);

    }

    /* get admin from a particular org */
    @GetMapping("/get-admin/{org}")
    public ResponseEntity<?> getAdmin(@PathVariable(value = "org") String org){
        Admin admin = adminService.adminFromGivenOrg(org);
        if(admin == null){
            return new ResponseEntity<>("Sorry we have no admin from your organization: [ "+org+" ]",HttpStatus.OK);
        }else {
            return new ResponseEntity<>(admin,HttpStatus.OK);
        }

    }

    /* list of all admins */
    @GetMapping("/get-admin-list")
    public ResponseEntity<List<Admin>> listOfAdmin(){
        return new ResponseEntity<>(adminService.findAdminList(),HttpStatus.OK);
    }

    /* Remove Admin */
    
    /* Update Admin Details */
}
