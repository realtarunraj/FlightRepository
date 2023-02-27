package com.flight.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.flight.DTO.TicketDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "ticket_details")
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// data members
	private int ticketId;
	

	@ManyToOne
	  @JoinColumn(name = "customer_id")
	  private Customer customer;
	
	@ManyToOne
	private Activity activities;
	
	
	private LocalDate dateTime;
	
	public Ticket(TicketDTO tdto,Customer c) {
		this.setActivities(tdto.getActivities());
		this.setCustomer(c);
		this.setDateTime(tdto.getDateTime());
		this.setTicketId(tdto.getTicketId());
	}
	
}
