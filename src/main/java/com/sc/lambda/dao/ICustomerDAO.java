package com.sc.lambda.dao;

import java.util.List;

import com.sc.lambda.beans.Customer;
import com.sc.lambda.exception.CustomerNotFoundException;
import com.sc.lambda.exception.DuplicateIdException;

public interface ICustomerDAO {
	

	public List<Customer> getCustomers();
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;
	public Customer deleteCustomerById(int customerId) throws CustomerNotFoundException;
	public Customer updateCustomerName(int customerId, Customer c) throws CustomerNotFoundException;
	public Customer addCustomer(Customer c) throws  DuplicateIdException;
	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException;

}
