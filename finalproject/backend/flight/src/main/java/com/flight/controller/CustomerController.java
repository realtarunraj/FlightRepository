package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.DTO.CustomerDTO;
import com.flight.exception.AdminNotFoundException;
import com.flight.exception.CustomerAlreadyExists;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoCustomersFoundException;
import com.flight.model.Admin;
import com.flight.model.Customer;
import com.flight.service.CustomerServices;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	CustomerServices services;
	
	@PostMapping("/create")
	public Customer createCustomer(@RequestBody CustomerDTO customerdto) throws CustomerAlreadyExists
	{
		Customer customer=new Customer(customerdto);
		return services.insertCustomer(customer);
	}
	
	@PostMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerDTO customerdto) throws CustomerNotFoundException{
		Customer customer =new Customer(customerdto);
		return services.updateCustomer(customer);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable int id) throws CustomerNotFoundException {
		return services.deleteCustomer(id);
	}
	
	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable int id) throws CustomerNotFoundException {
		return services.viewCustomer(id);
	}
	
	@GetMapping("/getall")
	public List<Customer> getCustomers() throws NoCustomersFoundException{
		return services.viewCustomers();
	}
	
	@GetMapping("/login/{email}/{password}")
	public Customer login(@PathVariable("email") String username,@PathVariable("password") String password) throws CustomerNotFoundException, InvalidPasswordException {
		return services.validateCustomer(username, password);
	}
	
	@PostMapping("/setpassword/{email}/{password}")
	public Customer setpass(@PathVariable("email") String email, @PathVariable("password") String password) throws CustomerNotFoundException{
		return services.setPassword(email, password);
	}
}
