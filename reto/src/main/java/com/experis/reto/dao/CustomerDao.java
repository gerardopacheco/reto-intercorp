package com.experis.reto.dao;

import com.experis.reto.entity.Customer;
import com.experis.reto.util.Error;

import java.util.List;
import java.util.Map;

public interface CustomerDao {

	Error getError();

	List<Customer> findAll();

	Map getStatistics();

	int insert(Customer customer);
}
