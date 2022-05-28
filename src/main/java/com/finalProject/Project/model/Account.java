package com.finalProject.Project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account_table")
@Data
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Computer> computerList;
}
