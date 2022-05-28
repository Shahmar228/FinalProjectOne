package com.finalProject.Project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "computer_table")
@Data
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String brand;
    private String model;
    private String price;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_table")
    private Account theAccount;


}
