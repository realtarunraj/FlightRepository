package com.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.exception.TicketNotFoundException;
import com.flight.model.Ticket;

public interface TicketServices {

	public Ticket insetTicket(Ticket ticket) throws TicketNotFoundException;
	
	public Ticket updateTicket(Ticket ticket) throws TicketNotFoundException;
	
	public String deleteTicket(int ticketId) throws TicketNotFoundException;
	
	public Ticket retrieveTicket(int ticketId) throws TicketNotFoundException;
	
	public List<Ticket> viewCustomerTickets(int customerId) throws NoTicketsFoundException;
	
	public Map<String, Double> calculateCustomerBill(int customerId) throws NoTicketsFoundException;
	

	List<Ticket> getAllTickets() throws NoTicketsFoundException;

	boolean hasTicket(int ticketid);

	List<Ticket> getTicketsOfDates(Integer id, LocalDate start, LocalDate end) throws ActivityNotFoundException, NoActivitiesFoundException;
}
