package com.experis.reto.dao;

import com.experis.reto.entity.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerDao {

    List<Customer> findAll();

    Map getStatistics();

    void insert(Customer customer);
}
