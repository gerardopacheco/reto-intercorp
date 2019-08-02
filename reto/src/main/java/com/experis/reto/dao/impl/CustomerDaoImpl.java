package com.experis.reto.dao.impl;

import com.experis.reto.dao.CustomerDao;
import com.experis.reto.entity.Customer;
import com.experis.reto.util.DBConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Transactional
@Repository
@Configuration
public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

    @Autowired
    public CustomerDaoImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }


    @Override
    public List<Customer> findAll() {

        try {
            return Objects.requireNonNull(getJdbcTemplate()).query(DBConstant.SELECT_CUSTOMER_ALL, new RowMapper<Customer>() {
                @Override
                public Customer mapRow(ResultSet resultSet, int i) throws SQLException {


                    return new Customer(resultSet.getInt("id"),
                            resultSet.getInt("year_old"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getDate("birth_date"));
                }
            });
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }

        return null;
    }

    @Override
    public Map getStatistics() {

        try {

            return Objects.requireNonNull(getJdbcTemplate()).query(DBConstant.SELECT_CUSTOMER_STATISTICS, (ResultSet rs) -> {
                HashMap<String, String> results = new HashMap<>();
                while (rs.next()) {
                    results.put("average", rs.getString("average"));
                    results.put("desv", rs.getString("desv"));
                }
                return results;
            });


        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }

        return null;
    }

    @Override
    public void insert(Customer customer) {

        try {
            Objects.requireNonNull(getJdbcTemplate()).update(DBConstant.INSERT_CUSTOMER,
                    customer.getBirthDay(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getBirthDay());
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
        }

    }
}
