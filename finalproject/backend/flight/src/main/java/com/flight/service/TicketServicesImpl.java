package com.flight.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.exception.TicketNotFoundException;
import com.flight.model.Activity;
import com.flight.model.Ticket;
import com.flight.repository.TicketBookingRepository;

@Service
public class TicketServicesImpl implements TicketServices {

	private static final Logger logger = LogManager.getLogger(TicketServicesImpl.class);

	@Autowired
	TicketBookingRepository ticketrepo;
	
	@Autowired
	ActivityServices acser;
	

	public Ticket insetTicket(Ticket ticket) throws TicketNotFoundException{
		if(!ticketrepo.existsById(ticket.getTicketId())) {
		ticket = ticketrepo.save(ticket);
		 logger.info("Ticket created successfully with user id --- " +
		 ticket.getTicketId());
		return ticket;}else {
			throw new TicketNotFoundException();
		}

	}
	
	@Override
	public boolean hasTicket(int ticketid) {
		return ticketrepo.existsById(ticketid);
	}
	
	@Override
	public Ticket updateTicket(Ticket ticket) throws TicketNotFoundException {
		
		if (ticketrepo.existsById(ticket.getTicketId())) {
			ticket = ticketrepo.save(ticket);
			 logger.info("Ticket updated successfully with user id --- " +
			 ticket.getTicketId());
			return (ticket);
		} else {
			 logger.warn("Customer does not exist in the database " +
			 ticket.getTicketId());
			throw new TicketNotFoundException();
		}
	}

	public Ticket retrieveTicket(int ticketId) throws TicketNotFoundException {
		if (ticketrepo.existsById(ticketId)) {
			return ticketrepo.findById(ticketId).get();
		} else {
			throw new TicketNotFoundException();
		}
	}

	@Override
	public String deleteTicket(int ticketId) throws TicketNotFoundException {
		
		if (ticketrepo.existsById(ticketId)) {

			ticketrepo.deleteById(ticketId);
			 logger.info("Ticket deleted successfully with user id --- " + ticketId);
			return "ticket deleted succesfully";
		} else {
			 logger.warn("Ticket does not exist in the database " + ticketId);
			throw new TicketNotFoundException();
		}
	}

	@Override
	public List<Ticket> viewCustomerTickets(int customerId) throws NoTicketsFoundException {
		
		List<Ticket> tickets = ticketrepo.getTicketsOfCustomer(customerId);
		if (tickets.size() > 0) {
			return tickets;
		} else
			throw new NoTicketsFoundException();
	}

	@Override
	public Map<String, Double> calculateCustomerBill(int customerId) throws NoTicketsFoundException {
		
		List<Ticket> tickets = ticketrepo.getTicketsOfCustomer(customerId);
		if (tickets.size() > 0) {
			Map<String, Double> recipt = new HashMap<>();
			Double cost;
			for (Ticket ticket : tickets) {
				cost = ticket.getActivities().getCharges();
				recipt.put("ticket id " + (ticket.getTicketId()), cost);
			}
			return recipt;
		} else
			throw new NoTicketsFoundException();
	}

	@Override
	public List<Ticket> getAllTickets() throws NoTicketsFoundException {
		List<Ticket> tickets = (List<Ticket>) ticketrepo.findAll();
		if(tickets.isEmpty()) {
			throw new NoTicketsFoundException();
		}
		return tickets;
	}
	
	@Override
	public List<Ticket> getTicketsOfDates(Integer id,LocalDate start,LocalDate end) throws ActivityNotFoundException, NoActivitiesFoundException{
		if(!acser.hasActivity(id)) {
			throw new ActivityNotFoundException();
		}
		else {
			List<Ticket> tickets= ticketrepo.getTicketsOfDates(id, start, end);
			if(tickets.isEmpty()) {
				throw new NoActivitiesFoundException();
			}
			return tickets;
		}
	}

}
