package com.sc.lambda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.lambda.beans.Customer;
import com.sc.lambda.dao.CustomerDAOImpl;
import com.sc.lambda.dao.ICustomerDAO;
import com.sc.lambda.exception.CustomerNotFoundException;
import com.sc.lambda.exception.DuplicateIdException;

@Service
public class CustomerServiceImpl implements ICustomer {
	
	@Autowired
	ICustomerDAO dao ;

	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return dao.getCustomers();
	}

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return dao.getCustomerById(customerId);
	}
	
	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return dao.getCustomerByName(customerName);
	}

	public Customer deleteCustomerById(int customerId) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		return dao.deleteCustomerById(customerId);
	}

	public Customer updateCustomerName(int customerId, Customer c) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		return dao.updateCustomerName(customerId, c);
	}

	public Customer addCustomer(Customer c) throws DuplicateIdException{
		// TODO Auto-generated method stub
		
		return dao.addCustomer(c);
	}


}
