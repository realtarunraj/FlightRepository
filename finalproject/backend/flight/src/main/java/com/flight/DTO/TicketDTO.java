package com.flight.DTO;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.flight.model.Activity;

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

public class TicketDTO {
	
	private int ticketId;
	
	private CustomerDTO customer;
	
	@Exclude
	private Activity activities;
	
	
	private LocalDate dateTime;

}
