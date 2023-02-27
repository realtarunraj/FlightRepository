package com.flight.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.DTO.AdminDTO;
import com.flight.exception.AdminAlreadyExists;
import com.flight.exception.AdminNotFoundException;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoAdminsFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.model.Activity;
import com.flight.model.Admin;
import com.flight.service.AdminServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	@Autowired
	AdminServices service;
	
	
	@PostMapping("/create")
	public Admin addAdmin(@RequestBody AdminDTO admindto) throws AdminAlreadyExists {
		Admin admin= new Admin(admindto);
		return service.insertAdmin(admin);
	}
	
	
	@PostMapping("/update")
	public Admin updateAdmin(@RequestBody AdminDTO admindto) throws AdminNotFoundException {
		Admin admin= new Admin(admindto);
		return service.updateAdmin(admin);
	}
	
	@GetMapping("/getadmins")
	public  List<Admin> getAllAdmins() throws NoAdminsFoundException{
		return service.retieveAllAdmins();
	}
	
	@GetMapping("/get/{id}")
	public Admin getAdmin(@PathVariable int id) throws AdminNotFoundException {
		return service.retrieveAdmin(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAdmin(@PathVariable int id) throws AdminNotFoundException {
		return service.deleteAdmin(id);
	}
	
	@GetMapping("/getactivities/{customerid}")
	public Map<String,Activity> getActivitiesOfCustomer(@PathVariable int customerid) throws NoActivitiesFoundException, NoTicketsFoundException, CustomerNotFoundException{
		return service.getAllActivitiesbyCustomerId(customerid);
	}
	
	
	@GetMapping("/getCustomerActivities/{customerid}/{start}/{end}")
	public Map<LocalDate, List<Activity>> getCustomerActivitiesBetweenDates(@PathVariable("customerid") int customerid,@PathVariable("start") String start,@PathVariable("end") String end ) throws NoActivitiesFoundException, CustomerNotFoundException{
		return service.getActivitieForDays(customerid, LocalDate.parse(start), LocalDate.parse(end));
	}
	
	@GetMapping("/allctivities")
	public List<Activity> getAllActivities() throws NoActivitiesFoundException{
		return service.getAllActivities();
	}
	
	@GetMapping("/login/{email}/{password}")
	public Admin login(@PathVariable("email") String email,@PathVariable("password") String password) throws InvalidPasswordException, AdminNotFoundException {
		return service.login(email, password);
	}
	
	@PostMapping("/setpassword/{email}/{password}")
	public Admin setpass(@PathVariable("email") String email, @PathVariable("password") String password) throws AdminNotFoundException {
		return service.setPassword(email, password);
	}

}
