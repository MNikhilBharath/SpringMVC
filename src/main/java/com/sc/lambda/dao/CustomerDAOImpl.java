package com.sc.lambda.dao;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sc.lambda.beans.Customer;
import com.sc.lambda.exception.CustomerNotFoundException;
import com.sc.lambda.exception.DuplicateIdException;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {

	@Autowired
	JdbcTemplate template;

	public List<Customer> getCustomers() {
		String sql = "select cust_id,cust_name,cust_contact,cust_account from customers";
		return template.query(sql, new CustomerRowMapper());

	}

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from customers where cust_id=?";
		List<Customer> list = template.query(sql, new CustomerRowMapper(), customerId);
		if (list.size() == 0)
			throw new CustomerNotFoundException("Customer Not found");
		else
			return list.get(0);

	}

	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		String sql = "select * from customers where cust_name=?";
		return template.query(sql, new CustomerRowMapper(), customerName).get(0);

	}

	public Customer deleteCustomerById(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

		Customer cust = getCustomerById(customerId);
		if (cust != null) {
			String sql = "delete from customers where cust_id=?";
			template.update(sql, customerId);
		}
		return cust;

	}

	public Customer updateCustomerName(int customerId, Customer c) throws CustomerNotFoundException {
		// TODO Auto-generated method stub

		Customer cust = getCustomerById(customerId);
		if (cust != null) {
			String sql = "update customers set cust_name=?, cust_contact=?, cust_account=? where cust_id=?";
			template.update(sql, c.getName(), c.getContact(), c.getAccountType(), customerId);
		}
		return getCustomerById(customerId);
	}

	public Customer addCustomer(Customer c) throws DuplicateIdException {
		try {
			if (getCustomerById(c.getCustomerId()) != null)
				throw new DuplicateIdException("Id already exists");
			else {
				String sql = "insert into customers values(?,?,?,?)";
				template.update(sql, c.getCustomerId(), c.getName(), c.getContact(), c.getAccountType());
			}
		} catch (CustomerNotFoundException e1) {
			e1.printStackTrace();
		}

		return c;

	}

}
