package com.flight.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.DTO.TicketDTO;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.exception.TicketAlreadyExists;
import com.flight.exception.TicketNotFoundException;
import com.flight.model.Activity;
import com.flight.model.Customer;
import com.flight.model.Ticket;
import com.flight.service.ActivityServices;
import com.flight.service.CustomerServices;
import com.flight.service.TicketServices;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*")
public class TicketController {

	@Autowired
	TicketServices service;
	@Autowired
	CustomerServices cusServices;
	
	@Autowired
	ActivityServices aser;

	@PostMapping("/create")
	public Ticket addTicket(@RequestBody TicketDTO ticketdto)
			throws TicketAlreadyExists, CustomerNotFoundException, TicketNotFoundException, ActivityNotFoundException {
		if (!String.valueOf(ticketdto.getCustomer().getCustomerId()).equals("0")
				&& cusServices.hasCustomer(ticketdto.getCustomer().getCustomerId())) {
			if (!service.hasTicket(ticketdto.getTicketId())) {
				Activity a=aser.retrieveActivity(ticketdto.getActivities().getActivityId());
				Customer c = (cusServices.viewCustomer(ticketdto.getCustomer().getCustomerId()));
				Ticket ticket = new Ticket(ticketdto, c);
				ticket.setActivities(a);
				return service.insetTicket(ticket);
			} else
				throw new TicketAlreadyExists();
		} else
			throw new CustomerNotFoundException();
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable int id) throws TicketNotFoundException {
		return service.deleteTicket(id);
	}

	@GetMapping("/get/{id}")
	public Ticket getTicket(@PathVariable int id) throws TicketNotFoundException {
		return service.retrieveTicket(id);
	}

	@PostMapping("/update")
	public Ticket updateTicket(@RequestBody TicketDTO ticketdto)
			throws CustomerNotFoundException, TicketNotFoundException, ActivityNotFoundException {
		if (cusServices.hasCustomer(ticketdto.getCustomer().getCustomerId())) {
			if (service.hasTicket(ticketdto.getTicketId())) {
				Customer c = (cusServices.viewCustomer(ticketdto.getCustomer().getCustomerId()));
				Activity a=aser.retrieveActivity(ticketdto.getActivities().getActivityId());
				
				Ticket ticket = new Ticket(ticketdto, c);
				ticket.setActivities(a);
				return service.updateTicket(ticket);
			} else {
				throw new TicketNotFoundException();
			}
		}
		throw new CustomerNotFoundException();
	}

	@GetMapping("/viewall/{customerid}")
	public List<Ticket> viewAll(@PathVariable int customerid)
			throws NoTicketsFoundException, CustomerNotFoundException {
		if (!cusServices.hasCustomer(customerid)) {
			throw new CustomerNotFoundException();
		}
		List<Ticket> tickets = service.viewCustomerTickets(customerid);
		if (tickets.size() > 0 || tickets.equals(null))
			return tickets;
		else
			throw new NoTicketsFoundException();
	}

	@GetMapping("/calculatebill/{customerid}")
	public Map<String, Double> calculateBill(@PathVariable int customerid)
			throws NoTicketsFoundException, CustomerNotFoundException {
		if (!cusServices.hasCustomer(customerid))
			throw new CustomerNotFoundException();
		return service.calculateCustomerBill(customerid);
	}

	@GetMapping("/getAllTickets")
	public List<Ticket> getAll() throws NoTicketsFoundException {
		return service.getAllTickets();
	}
	
	@GetMapping("/getTicketsOfDate/{activityId}/{start}/{end}")
	public List<Ticket> getTicketsOfDate(@PathVariable int activityId,@PathVariable String start,@PathVariable String end) throws ActivityNotFoundException, NoActivitiesFoundException{
		return service.getTicketsOfDates(activityId, LocalDate.parse(start), LocalDate.parse(end));
	}

}
