package com.sc.lambda.comtroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sc.lambda.beans.*;
import com.sc.lambda.exception.CustomerNotFoundException;
import com.sc.lambda.exception.DuplicateIdException;
import com.sc.lambda.services.ICustomer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	ICustomer service;

	@ApiOperation("display all customers")
	@RequestMapping(method = RequestMethod.GET, value = "/displayAll")
	public ResponseEntity<List<Customer>> getCustomers() {

		return new ResponseEntity<List<Customer>>(service.getCustomers(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer custId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(service.getCustomerById(custId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCumstomerByName/{name}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable String name, @PathVariable int rmId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(service.getCustomerByName(name), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) throws DuplicateIdException {
		return new ResponseEntity<Customer>(service.addCustomer(c), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c, @PathVariable Integer id)
			throws CustomerNotFoundException {

		return new ResponseEntity<Customer>(service.updateCustomerName(id, c), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteCustomer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id) throws CustomerNotFoundException {

		return new ResponseEntity<Customer>(service.deleteCustomerById(id), HttpStatus.OK);
	}

}
