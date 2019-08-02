package com.experis.reto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Customer {


    private int id;
    private int year;
    private String firstName;
    private String lastName;
    private Date birthDay;


    public Customer() {

    }


}
