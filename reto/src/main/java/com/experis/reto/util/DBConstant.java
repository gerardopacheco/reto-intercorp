package com.experis.reto.util;

public class DBConstant {

    public static String SELECT_CUSTOMER_ALL = "SELECT * FROM customers";
    public static String SELECT_CUSTOMER_STATISTICS = "SELECT AVG(year_old) average, STD(year_old) desv  FROM customers";
    public static String INSERT_CUSTOMER = "INSERT INTO customers(year_old,first_name, last_name, birth_date)VALUES(TIMESTAMPDIFF(YEAR,?,NOW()) ,?,?,?)";

}
