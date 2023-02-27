package com.flight.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.exception.AdminAlreadyExists;
import com.flight.exception.AdminNotFoundException;
import com.flight.model.Admin;
import com.flight.repository.AdminRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServicesTests {
	
	@Mock
	private AdminRepository arepo;
	
	@InjectMocks
	private AdminServicesImpl aser;
	
	@Autowired
	private AdminServices adminser;
	
	@Test
	public void testInsertAdmin() throws AdminAlreadyExists {
		Admin admin = new Admin();
		admin.setAddress("Banglore");
		admin.setEmail("admin123@gmail.com");
		admin.setMobileNo("564122345");
		when(arepo.save(admin)).thenReturn(admin);
		Admin admin1 = aser.insertAdmin(admin);
		assertEquals(admin, admin1);	
	}
	
	@Test
	public void testDeleteAdmin1() throws AdminNotFoundException 
	{
		AdminNotFoundException thrown = assertThrows("Admin Not Found", AdminNotFoundException.class, ()-> {adminser.deleteAdmin(-1);});
		assertEquals(AdminNotFoundException.class, thrown.getClass());	
	}	
}