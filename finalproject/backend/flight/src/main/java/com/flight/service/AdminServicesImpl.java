package com.flight.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.exception.AdminAlreadyExists;
import com.flight.exception.AdminNotFoundException;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoAdminsFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.model.Activity;
import com.flight.model.Admin;
import com.flight.model.Customer;
import com.flight.model.Ticket;
import com.flight.repository.ActivityRepository;
import com.flight.repository.AdminRepository;

@Service
public class AdminServicesImpl implements AdminServices {

	 private static final Logger logger=
	 LogManager.getLogger(AdminServicesImpl.class);

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	ActivityRepository activityRepo ;

	@Autowired
	TicketServices ticketServices;

	@Autowired
	CustomerServices cusServices;

	@Override
	public Admin insertAdmin(Admin admin) throws AdminAlreadyExists {

		if (!adminRepo.existsByEmail(admin.getEmail())||!adminRepo.existsById(admin.getAdminId())) {
			admin = adminRepo.save(admin);
			 logger.info("Admin created successfully with user id ---"+admin.getAdminId());
			return admin;
		} else {
			 logger.warn("Admin already exist in the database "+admin.getUserName());
			throw new AdminAlreadyExists();
		}

	}

	
	@Override
	public Admin updateAdmin(Admin admin) throws AdminNotFoundException {

		if (adminRepo.existsById(admin.getAdminId())) {
			admin = adminRepo.save(admin);
			 logger.info("Admin updated successfully with user id ---"+admin.getAdminId());
			return admin;
		} else {
			 logger.warn("Admin does not exist in the database "+admin.getUserName());
			throw new AdminNotFoundException();
		}
	}

	@Override
	public String deleteAdmin(int adminId) throws AdminNotFoundException {

		if (adminRepo.existsById(adminId)) {

			adminRepo.deleteById(adminId);
			 logger.info("Admin deleted successfully with user id --- "+adminId);
			return "Admin deleted succesfully";
		} else {
			 logger.warn("Admin does not exist in the database "+adminId);
			throw new AdminNotFoundException();
		}
	}

	@Override
	public Map<String, Activity> getAllActivitiesbyCustomerId(int customerId)
			throws NoActivitiesFoundException, NoTicketsFoundException, CustomerNotFoundException {

		if (!cusServices.hasCustomer(customerId)) {
			throw new CustomerNotFoundException();
		} else {
			Map<String,Activity> activities = new HashMap<>();
			for (Ticket ticket : ticketServices.viewCustomerTickets(customerId)) {
				activities.put("Ticket Id: " + ticket.getTicketId(), ticket.getActivities());
			}
			return activities;
		}
	}

	@Override
	public List<Activity> getAllActivities() throws NoActivitiesFoundException {

		return (List<Activity>) activityRepo.findAll();
	}

	

	@Override
	public Map<LocalDate, List<Activity>> getActivitieForDays(int customerId, LocalDate startDate, LocalDate endDate)
			throws NoActivitiesFoundException, CustomerNotFoundException {

		if (!cusServices.hasCustomer(customerId)) {
			throw new CustomerNotFoundException();
		} else {
			List<Ticket> tickets = adminRepo.getTicketsBetweenDays(customerId, startDate, endDate);
			Map<LocalDate, List<Activity>> activities = new HashMap<>();
			for (Ticket ticket : tickets) {
				if (activities.containsKey(ticket.getDateTime())) {
					List<Activity> list = activities.get(ticket.getDateTime());
					list.add(ticket.getActivities());
					activities.put(ticket.getDateTime(), list);
				} else {
					List<Activity> list = new ArrayList<>();
					list.add(ticket.getActivities());
					activities.put(ticket.getDateTime(),list);
				}
			}
			if (activities.isEmpty()) {
				throw new NoActivitiesFoundException();
			}
			return activities;
		}
	}

	@Override
	public Admin retrieveAdmin(int adminId) throws AdminNotFoundException {

		if (adminRepo.existsById(adminId)) {
			return adminRepo.findById(adminId).get();
		} else
			throw new AdminNotFoundException();
	}
	
	@Override 
	public List<Admin> retieveAllAdmins() throws NoAdminsFoundException{
		List<Admin> admins=(List<Admin>) adminRepo.findAll();
		if(admins.isEmpty()) {
			throw new NoAdminsFoundException();
		}
		return admins;
	}
	
	@Override
	public Admin login(String email,String password) throws InvalidPasswordException, AdminNotFoundException {
		Admin c = adminRepo.findByEmail(email);
		if (c == null) {
			throw new AdminNotFoundException();
		} else {
			if (!c.getPassword().equals(password)) {
				throw new InvalidPasswordException();
			}
			return c;
		}
	}
	
	@Override
	public Admin setPassword(String email,String pass) throws AdminNotFoundException
	 {

		if(adminRepo.existsByEmail(email)) {
			Admin a=adminRepo.findByEmail(email);
			a.setPassword(pass);
			return this.updateAdmin(a);
		}else {
			throw new AdminNotFoundException();
		}
		
	}

}
