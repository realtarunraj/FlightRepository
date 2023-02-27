package com.flight.DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class CustomerDTO {
	
	private int customerId;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String userName;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String password;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String address;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String mobileNo;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String email;
	
	@Exclude
	@JsonIgnore
	  private List<TicketDTO> tickets;

}
