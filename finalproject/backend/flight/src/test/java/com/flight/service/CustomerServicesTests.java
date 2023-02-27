package com.flight.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.exception.CustomerAlreadyExists;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.TicketNotFoundException;
import com.flight.model.Customer;
import com.flight.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServicesTests {
	
	@Mock
	CustomerRepository cusRepo;
	
	@InjectMocks
	CustomerServicesImpl cusSer;
	
	@Test
	public void testInsertCustomer() throws CustomerAlreadyExists {
		Customer c=new Customer();
		c.setUserName("Deepak");
		c.setAddress("bangalore");
		when(cusRepo.save(c)).thenReturn(c);
		assertEquals(c, cusSer.insertCustomer(c));
	}
	
	@Test
	public void testDeleteCustomer() throws CustomerNotFoundException {
		Exception thrown =assertThrows("Customer Already Exists",Exception.class, ()->{cusSer.deleteCustomer(-1);});
		assertEquals(thrown.getClass(),CustomerNotFoundException.class);
	}
	
}
