package com.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.flight.exception.AdminAlreadyExists;
import com.flight.exception.AdminNotFoundException;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoAdminsFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.model.Activity;
import com.flight.model.Admin;

public interface AdminServices {
	
  public Admin insertAdmin(Admin admin) throws AdminAlreadyExists;
  
  public Admin updateAdmin(Admin admin) throws AdminNotFoundException;
  
  public Admin retrieveAdmin(int adminId) throws AdminNotFoundException;  
  
  public String deleteAdmin(int adminId) throws AdminNotFoundException;
  
  public Map<String, Activity> getAllActivitiesbyCustomerId(int customerId) throws NoActivitiesFoundException, NoTicketsFoundException, CustomerNotFoundException;
  
  public List<Activity> getAllActivities() throws NoActivitiesFoundException;
  
  
  public Map<LocalDate, List<Activity>> getActivitieForDays(int	CustomerId,LocalDate startDate,LocalDate endDate) throws NoActivitiesFoundException, CustomerNotFoundException;

public List<Admin> retieveAllAdmins() throws NoAdminsFoundException;

Admin login(String email, String password) throws InvalidPasswordException, AdminNotFoundException;

Admin setPassword(String email, String pass) throws AdminNotFoundException;
  
}
