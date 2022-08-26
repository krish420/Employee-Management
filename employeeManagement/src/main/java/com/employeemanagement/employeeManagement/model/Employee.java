package com.employeemanagement.employeeManagement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String Name;
    private String email;
    private String userName;
    private String password;
    private String mobileNumber;
    private String dateOfBirth;
    private String designation;
    private String orgId;
    private Org organization;

}
