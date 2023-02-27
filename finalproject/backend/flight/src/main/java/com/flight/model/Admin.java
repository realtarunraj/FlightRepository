package com.flight.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.flight.DTO.AdminDTO;

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

@Table(name = "admin_details")
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Length(min=5,max=50,message="Username must be between 5 and 15 characters")
	private String userName;
	

	@Length(min = 5,max=50,message="Password must be between 5 and 15 characters")
	private String password;
	

	@Length(min = 5)
	private String address;
	
	@Length(min = 10,max=13,message= "Invalid mobile number")
	private String mobileNo;
	
	@Email(message = "given email is not if proper format")
	private String email;
	
	private String role;
	
	public Admin(AdminDTO adto) {
		this.setAddress(adto.getAddress());
		this.setAdminId(adto.getAdminId());
		this.setEmail(adto.getEmail());
		this.setMobileNo(adto.getMobileNo());
		this.setPassword(adto.getPassword());
		this.setUserName(adto.getUserName());
		this.setRole("admin");
	}
}
