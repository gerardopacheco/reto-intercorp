package com.experis.reto.util;

public class DBConstant {

    public static final String SELECT_CUSTOMER_ALL = "SELECT * FROM customers";
    public static final String SELECT_CUSTOMER_STATISTICS = "SELECT AVG(age) average, STD(age) desv  FROM customers";
    public static final String INSERT_CUSTOMER = "INSERT INTO customers(first_name, last_name, birth_date, age)VALUES(?, ?, ?, TIMESTAMPDIFF(YEAR,?,NOW()))";

}
