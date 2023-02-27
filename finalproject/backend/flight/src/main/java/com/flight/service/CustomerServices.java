package com.flight.service;

import java.util.List;

import com.flight.exception.CustomerAlreadyExists;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoCustomersFoundException;
import com.flight.model.Customer;

public interface CustomerServices {
	
public Customer insertCustomer(Customer customer) throws CustomerAlreadyExists;

public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

public String deleteCustomer(int customerid) throws CustomerNotFoundException;

public List<Customer> viewCustomers() throws NoCustomersFoundException;

public Customer viewCustomer(int CustomerId) throws CustomerNotFoundException ;

public Customer validateCustomer(String userName,String password) throws CustomerNotFoundException, InvalidPasswordException;

public Boolean hasCustomer(int customerId) throws CustomerNotFoundException;

Customer setPassword(String email, String pass) throws CustomerNotFoundException;
}
