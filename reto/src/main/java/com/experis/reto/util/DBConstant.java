package com.experis.reto.util;

public class DBConstant {

	public static final String SELECT_CUSTOMER_ALL = new StringBuilder()
			.append("SELECT id, ")
			.append("first_name firstName, ")
			.append("last_name lastName, ")
			.append("birth_date birthDate, ")
			.append("age, ")
			.append("DATE(DATE_ADD(birth_date, INTERVAL ").append(ConstansUtil.AVERAGE_LIFE).append(" YEAR)) deathDateprob ")
			.append("FROM customers").toString();

	public static final String SELECT_CUSTOMER_STATISTICS = "SELECT AVG(age) average, STD(age) desv  FROM customers";
	public static final String INSERT_CUSTOMER = "INSERT INTO customers(first_name, last_name, birth_date, age) VALUES(?, ?, ?, TIMESTAMPDIFF(YEAR,?,NOW()))";

}
