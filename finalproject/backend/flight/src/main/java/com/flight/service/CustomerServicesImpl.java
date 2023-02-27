package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.exception.CustomerAlreadyExists;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoCustomersFoundException;
import com.flight.model.Customer;
import com.flight.repository.CustomerRepository;

@Service
public class CustomerServicesImpl implements CustomerServices {
	private static final Logger logger = LogManager.getLogger(CustomerServicesImpl.class);
	
	private String msg;

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Boolean hasCustomer(int customerId) throws CustomerNotFoundException {
		if (customerRepo.existsById(customerId))
			return true;
		else
			return false;
	}

	@Override
	public Customer insertCustomer(Customer customer) throws CustomerAlreadyExists {

		if (!customerRepo.existsByEmail(customer.getEmail())
				&&! customerRepo.existsById(customer.getCustomerId())) {
			customer = customerRepo.save(customer);
			msg="Customer created successfully with user id --- " + customer.getCustomerId();
			logger.info(msg);
			return customer;
		} else {
			msg="Customer already exist in the database " + customer.getUserName();
			logger.warn(msg);
			throw new CustomerAlreadyExists("Customer Already Exists");
		}

	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {

		if (customerRepo.existsById(customer.getCustomerId())) {
			customer = customerRepo.save(customer);
			msg="Customer updated successfully with user id --- " + customer.getCustomerId();
			logger.info(msg);
			return (customer);
		} else {
			msg="Customer does not exist in the database " + customer.getUserName();
			logger.warn(msg);
			throw new CustomerNotFoundException();
		}
	}

	@Override
	public String deleteCustomer(int customerId) throws CustomerNotFoundException {

		if (customerRepo.existsById(customerId)) {

			customerRepo.deleteById(customerId);
			msg="Customer deleted successfully with user id --- " + customerId;
			logger.info(msg);
			return "Customer deleted succesfully";
		} else {
			msg="Customer does not exist in the database " + customerId;
			logger.warn(msg);
			throw new CustomerNotFoundException("");
		}
	}

	@Override
	public List<Customer> viewCustomers() throws NoCustomersFoundException {

		List<Customer> customers = (List<Customer>) customerRepo.findAll();
		if (customers.size() > 0)
			return customers;
		else
			throw new NoCustomersFoundException();
	}

	@Override
	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {

		if (!customerRepo.existsById(customerId)) {
			logger.warn("Customer does not exist in the database " + customerId);
			throw new CustomerNotFoundException();
		} else {
			Optional<Customer> customer = customerRepo.findById(customerId);
			return customer.get();
		}
	}

	@Override
	public Customer validateCustomer(String email, String password)
			throws CustomerNotFoundException, InvalidPasswordException {
		Customer c = customerRepo.findByEmail(email);
		if (c == null) {
			throw new CustomerNotFoundException();
		} else {
			if (!c.getPassword().equals(password)) {
				throw new InvalidPasswordException();
			}
			return c;
		}
	}
	
	@Override
	public Customer setPassword(String email,String pass) throws CustomerNotFoundException
	 {

		if(customerRepo.existsByEmail(email)) {
			Customer c=customerRepo.findByEmail(email);
			c.setPassword(pass);
			return this.updateCustomer(c);
		}else {
			throw new CustomerNotFoundException();
		}
		
	}

}
