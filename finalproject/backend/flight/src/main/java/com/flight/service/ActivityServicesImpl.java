package com.flight.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.model.Activity;
import com.flight.repository.ActivityRepository;

@Service
public class ActivityServicesImpl implements ActivityServices {

	private static final Logger logger = LogManager.getLogger(TicketServicesImpl.class);
	private String msg;

	@Autowired
	ActivityRepository activityrepo;

	public Activity insertActivity(Activity activity) throws ActivityAlreadyExists {
		if (!activityrepo.existsById(activity.getActivityId())) {
			activity = activityrepo.save(activity);
			msg="Activity created successfully with user id --- " + activity.getActivityId();
			logger.info(msg);
			return activity;
		} else {
			msg="activity already exist in the database " + activity.getActivityId();
			logger.warn(msg);
			throw new ActivityAlreadyExists("Activity Already Exists");
		}

	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityNotFoundException {

		if (activityrepo.existsById(activity.getActivityId())) {
			activity = activityrepo.save(activity);
			msg = "Activity updated successfully with user id --- " + activity.getActivityId();
			logger.info(msg);
			return (activity);
		} else {
			msg = "Activity does not exist in the database " + activity.getActivityId();
			logger.warn(msg);
			throw new ActivityNotFoundException();
		}
	}

	@Override
	public String deleteActivity(int activityId) throws ActivityNotFoundException {

		if (activityrepo.existsById(activityId)) {

			activityrepo.deleteById(activityId);
			msg = "Customer deleted successfully with user id --- " + activityId;
			logger.info(msg);
			return "Activity deleted succesfully";
		} else {
			msg = "Customer does not exist in the database " + activityId;
			logger.warn(msg);
			throw new ActivityNotFoundException();
		}
	}

	@Override
	public List<Activity> viewActivitiesOfCharges(Double charges) throws NoActivitiesFoundException {

		List<Activity> activities = activityrepo.findAllByCharges(charges);
		if (activities.size() > 0)
			return activities;
		else
			throw new NoActivitiesFoundException();
	}

	@Override
	public int countActivitiesOfCharges(Double charges) throws NoActivitiesFoundException {

		List<Activity> activities = activityrepo.findAllByCharges(charges);
		if (activities.size() > 0)
			return activities.size();
		else
			throw new NoActivitiesFoundException();
	}

	@Override
	public Activity retrieveActivity(int activityId) throws ActivityNotFoundException {
		Optional<Activity> activity = activityrepo.findById(activityId);
		if (activity.isPresent()) {
			return activity.get();
		} else
			throw new ActivityNotFoundException();
	}

	@Override
	public Boolean hasActivity(int activityId) {
		return activityrepo.existsById(activityId);
	}

}
