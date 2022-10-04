package com.sc.lambda.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sc.lambda.beans.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setCustomerId(rs.getInt(1));
		c.setName(rs.getString(2));
		c.setContact(rs.getInt(3));
		c.setAccountType(rs.getString(4));		
		return c;
	}

}
