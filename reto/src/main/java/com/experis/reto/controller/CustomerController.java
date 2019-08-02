package com.experis.reto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.experis.reto.entity.Customer;
import com.experis.reto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(value = "Customer_Maintenance", description = "Endpoint for maintenance customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private static final Gson GSON = new Gson();
		
	@Autowired
	private CustomerService customerService;

	@ApiOperation("Customer Registration")
	@PostMapping("/customers")
	public ResponseEntity save(@RequestBody Customer customer) {
		LOGGER.info("save() -> customer : {}", GSON.toJson(customer));
		customerService.insert(customer);
		return new ResponseEntity(HttpStatus.OK);
	}

	@ApiOperation("Customer List")
	@GetMapping("/customers")
	public ResponseEntity searchAll() {
		LOGGER.info("searchAll()");
		return new ResponseEntity(customerService.findAll(), HttpStatus.OK);
	}

	@ApiOperation("Statistical reports")
	@GetMapping("/customers/statistics")
	public ResponseEntity statistics() {
		LOGGER.info("statistics()");
		return new ResponseEntity(customerService.getStatistics(), HttpStatus.OK);
	}

}
