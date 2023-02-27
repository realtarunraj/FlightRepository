package com.flight.DTO;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flight.model.Ticket;

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
public class ActivityDTO {

	private int activityId;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String description;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private double charges;
	
	@Exclude
	@JsonIgnore
	private List<Ticket> ticket;

}
