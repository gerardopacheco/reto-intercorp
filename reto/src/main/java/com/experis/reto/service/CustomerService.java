package com.experis.reto.service;

import com.experis.reto.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> findAll();

    Map getStatistics();

    void insert(Customer customer);
}
