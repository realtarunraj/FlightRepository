package com.flight.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class AdminDTO {

	private int adminId;
	
	@Length(min=5,max=15,message="Username must be between 5 and 15 characters")
	private String userName;
	

	@Length(min = 5,max=15,message="Password must be between 5 and 15 characters")
	private String password;
	

	@Length(min = 5)
	private String address;
	
	@Length(min = 10,max=13,message= "Invalid mobile number")
	private String mobileNo;
	
	@Email(message = "given email is not if proper format")
	private String email;
	
}

