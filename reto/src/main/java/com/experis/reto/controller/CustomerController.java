package com.experis.reto.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.experis.reto.entity.Customer;
import com.experis.reto.service.CustomerService;
import com.experis.reto.util.ResponseObject;
import com.experis.reto.util.ConstansUtil;
import com.experis.reto.util.Estado;
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
		ResponseObject response = new ResponseObject();
		try {
			int resultado = customerService.insert(customer);
		if(customerService.getError() == null) {			
			response.setEstado(Estado.OK);
			response.setResultado(resultado);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		}else {			
			response.setEstado(Estado.ERROR);
			response.setError(this.customerService.getError());
			return new ResponseEntity<ResponseObject>(response, HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			response.setEstado(Estado.ERROR);
			response.setError(ConstansUtil.CODE_SERVER_ERROR, ConstansUtil.MESSAGE_SERVER_ERROR, e.getMessage());			
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@ApiOperation("Customer List")
	@GetMapping("/customers")
	public ResponseEntity searchAll() {
		LOGGER.info("searchAll()");
		ResponseObject response = new ResponseObject();
		try {
			List<Customer> listCutomers = customerService.findAll();
		if(customerService.getError() == null) {			
			response.setEstado(Estado.OK);
			response.setResultado(listCutomers);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		}else {			
			response.setEstado(Estado.ERROR);
			response.setError(this.customerService.getError());
			return new ResponseEntity<ResponseObject>(response, HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			response.setEstado(Estado.ERROR);
			response.setError(ConstansUtil.CODE_SERVER_ERROR, ConstansUtil.MESSAGE_SERVER_ERROR, e.getMessage());			
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@ApiOperation("Statistical reports")
	@GetMapping("/customers/statistics")
	public ResponseEntity statistics() {
		LOGGER.info("statistics()");
		ResponseObject response = new ResponseObject();
		try {
			Map dataStatistics = customerService.getStatistics();
		if(customerService.getError() == null) {			
			response.setEstado(Estado.OK);
			response.setResultado(dataStatistics);
			return new ResponseEntity<ResponseObject>(response, HttpStatus.OK);
		}else {			
			response.setEstado(Estado.ERROR);
			response.setError(this.customerService.getError());
			return new ResponseEntity<ResponseObject>(response, HttpStatus.NOT_FOUND);
		}
		}catch(Exception e) {
			response.setEstado(Estado.ERROR);
			response.setError(ConstansUtil.CODE_SERVER_ERROR, ConstansUtil.MESSAGE_SERVER_ERROR, e.getMessage());			
			return new ResponseEntity<ResponseObject>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
