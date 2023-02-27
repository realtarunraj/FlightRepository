package com.flight.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flight.DTO.ActivityDTO;

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
@Table(name = "activity_details")
@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;
	
	@Length(min=4,max=100,message = "Description should be between 4 and 100 characters")
	private String description;
	
	@NotNull
	private double charges;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "activities")//owning side
	@Exclude
	@JsonIgnore
	private List<Ticket> ticket;
	
	public Activity(ActivityDTO adto) {
		this.setActivityId(adto.getActivityId());
		this.setCharges(adto.getCharges());
		this.setDescription(adto.getDescription());
		this.setTicket(adto.getTicket());
	}
}
