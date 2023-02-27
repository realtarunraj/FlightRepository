package com.flight.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.exception.TicketNotFoundException;
import com.flight.model.Ticket;
import com.flight.repository.TicketBookingRepository;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketServicesTests {
	
	@Mock
	private TicketBookingRepository trepo;
	
	@InjectMocks
	private TicketServicesImpl tser;
	
	@Autowired
	private TicketServices ticketser;
	
	@Test
	public void testInsertTicket() throws TicketNotFoundException {
		Ticket t=new Ticket();
		t.setDateTime(LocalDate.parse("1050-12-11"));
		when(trepo.save(t)).thenReturn(t);
		Ticket t1=tser.insetTicket(t);
		assertEquals(t, t1);	
	}
	

	
	@Test
	public void tetsDeleteTicket1() throws TicketNotFoundException 
	{
		TicketNotFoundException thrown = assertThrows("Ticket Not Found",TicketNotFoundException.class, ()->{ticketser.deleteTicket(-1);});
		assertEquals(TicketNotFoundException.class, thrown.getClass());	
	}
}
