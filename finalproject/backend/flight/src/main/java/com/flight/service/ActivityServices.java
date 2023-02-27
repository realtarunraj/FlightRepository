package com.flight.service;

import java.util.List;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.model.Activity;

public interface ActivityServices {
	
	public Activity insertActivity(Activity activity) throws ActivityAlreadyExists  ;
	
	public Activity updateActivity(Activity activity) throws ActivityNotFoundException;
	
	public Activity retrieveActivity(int  activityId) throws ActivityNotFoundException;
	
	public String deleteActivity(int activityId) throws ActivityNotFoundException;
	
	public List<Activity> viewActivitiesOfCharges(Double charges) throws NoActivitiesFoundException;
	
	public int countActivitiesOfCharges(Double charges) throws NoActivitiesFoundException;

	Boolean hasActivity(int activityId);
}
