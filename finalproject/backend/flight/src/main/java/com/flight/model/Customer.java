package com.flight.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flight.DTO.CustomerDTO;

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

@Table(name = "customers_details")
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// data members
	private int customerId;

	@Length(min = 5, max = 50, message = "Username must be between 5 and 15 characters")
	private String userName;

	@Length(min = 5, max = 50, message = "Password must be between 5 and 15 characters")
	private String password;

	@Length(min = 5)
	private String address;

	@Length(min = 10, max = 13, message = "Invalid mobile number")
	private String mobileNo;

	@Email(message = "given email is not if proper format")
	private String email;

	@OneToMany(cascade = {CascadeType.ALL},mappedBy = "customer")
	@Exclude
	@JsonIgnore
	private List<Ticket> tickets;
	
	private String role;

	public Customer(CustomerDTO cdto) {
		this.setAddress(cdto.getAddress());
		this.setCustomerId(cdto.getCustomerId());
		this.setEmail(cdto.getEmail());
		this.setMobileNo(cdto.getMobileNo());
		this.setPassword(cdto.getPassword());
		this.setUserName(cdto.getUserName());
		this.setRole("customer");
	}
}
