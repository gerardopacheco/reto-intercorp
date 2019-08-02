package com.experis.reto.controller;

import com.experis.reto.entity.Customer;
import com.experis.reto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity save(@RequestBody Customer customer) {

        customerService.insert(customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity list() {

        return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/customers/statistics")
    public ResponseEntity statistics() {

        return new ResponseEntity(customerService.getStatistics(), HttpStatus.OK);
    }

}
