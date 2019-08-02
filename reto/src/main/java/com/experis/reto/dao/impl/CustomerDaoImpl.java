package com.experis.reto.dao.impl;

import com.experis.reto.controller.CustomerController;
import com.experis.reto.dao.CustomerDao;
import com.experis.reto.entity.Customer;
import com.experis.reto.util.ConstansUtil;
import com.experis.reto.util.DBConstant;
import com.experis.reto.util.Error;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Transactional
@Repository
@Configuration
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);	
	private static final Gson GSON = new Gson();
	
	private Error error;
	
	public Error getError() {
		return this.error;
	}
	
	
    @Autowired
    public CustomerDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
	public List<Customer> findAll() {
		LOGGER.info("findAll()");
		this.error = null;
		List<Customer> listCustomer = null;
		try {
			RowMapper<Customer> customerMapper = ParameterizedBeanPropertyRowMapper.newInstance(Customer.class);
			listCustomer = getJdbcTemplate().query(DBConstant.SELECT_CUSTOMER_ALL, customerMapper);
		} catch (Exception ex) {
			this.error = new Error(ConstansUtil.CODE_ERROR_EXECUTE_QRY, 
								   ConstansUtil.MESSAGE_ERROR_EXECUTE_QRY,
					               ex.getMessage());
		}
		return listCustomer;
	}
        
	@Override
	public Map getStatistics() {
		LOGGER.info("getStatistics()");
		this.error = null;
		Map data = null;
		try {
			data = getJdbcTemplate().query(DBConstant.SELECT_CUSTOMER_STATISTICS, (ResultSet rs) -> {
				HashMap<String, String> results = new HashMap<>();
				while (rs.next()) {
					results.put("average", rs.getString("average"));
					results.put("desv", rs.getString("desv"));
				}
				return results;
			});
		} catch (Exception ex) {
			this.error = new Error(ConstansUtil.CODE_ERROR_EXECUTE_QRY, 
								   ConstansUtil.MESSAGE_ERROR_EXECUTE_QRY,
								   ex.getMessage());
		}
		return data;
	}

	@Override
	public int insert(Customer customer) {
		LOGGER.info("insert() -> customer : {}", GSON.toJson(customer));
		this.error = null;
		int resultado = 0;
		try {
			resultado = getJdbcTemplate().update(DBConstant.INSERT_CUSTOMER, 
					customer.getFirstName(), 
					customer.getLastName(),
					customer.getBirthDate(), 
					customer.getBirthDate());
		} catch (Exception ex) {			
			this.error = new Error(ConstansUtil.CODE_ERROR_EXECUTE_QRY, 
								   ConstansUtil.MESSAGE_ERROR_EXECUTE_QRY, 
								   ex.getMessage());			
		}
		return resultado;
	}
}
