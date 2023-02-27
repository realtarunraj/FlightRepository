package com.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.DTO.ActivityDTO;
import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.model.Activity;
import com.flight.service.ActivityServices;

@RestController
@RequestMapping("/activity")
@CrossOrigin
public class ActivityController {
	
	@Autowired
	ActivityServices services;
	
	@PostMapping("/add")
	public Activity addActivity(@RequestBody ActivityDTO activitydto) throws ActivityAlreadyExists {
			Activity activity=new Activity(activitydto);
			return services.insertActivity(activity);
	}
	
	@GetMapping("/get/{id}")
	public Activity getActivity(@PathVariable int id) throws ActivityNotFoundException {
		return services.retrieveActivity(id);
	}
	
	@PostMapping("/update")
	public Activity getActivity(@RequestBody ActivityDTO activitydto) throws ActivityNotFoundException {
		Activity activity=new Activity(activitydto);
		return services.updateActivity(activity);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteActivity(@PathVariable int id) throws ActivityNotFoundException {
		return services.deleteActivity(id);
	}
	
	@GetMapping("/count/{charges}")
	public int countActivitiesByCharges(@PathVariable Double charges) throws NoActivitiesFoundException{
		return services.countActivitiesOfCharges(charges);
	}
	
	@GetMapping("/viewall/{charges}")
	public List<Activity> viewActivitiesByCharges(@PathVariable Double charges) throws NoActivitiesFoundException{
		return services.viewActivitiesOfCharges(charges);
	}
}
