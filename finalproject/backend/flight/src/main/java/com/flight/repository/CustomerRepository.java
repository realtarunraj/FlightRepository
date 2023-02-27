package com.flight.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	public Boolean existsByEmail(String mobileNo);
	
	public Customer findByUserName(String username);
	
	public Customer findByEmail(String email);
}
