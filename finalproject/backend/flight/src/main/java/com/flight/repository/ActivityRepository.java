package com.flight.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Activity;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	public List<Activity> findAllByCharges(Double charges);
 
}
