package com.employeemanagement.employeeManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String org;
    private String name;
    private String userName;
    private String email;
    private String mobileNumber;
    private String password;
}
