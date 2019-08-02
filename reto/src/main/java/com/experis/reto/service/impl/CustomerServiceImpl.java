package com.experis.reto.service.impl;

import com.experis.reto.dao.CustomerDao;
import com.experis.reto.entity.Customer;
import com.experis.reto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Map getStatistics() {
        return customerDao.getStatistics();
    }

    @Override
    public void insert(Customer customer) {
        customerDao.insert(customer);
    }
}
