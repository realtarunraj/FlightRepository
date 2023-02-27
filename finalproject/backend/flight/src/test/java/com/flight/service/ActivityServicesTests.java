package com.flight.service;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.model.Activity;
import com.flight.repository.ActivityRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivityServicesTests {
	
	@Mock
	private ActivityRepository arepo;
	@InjectMocks
	private ActivityServicesImpl actimpl;
	
	@Autowired
	private  ActivityServices activityser;

	@Test
	public void testInsertActivity() throws ActivityAlreadyExists {
		Activity act = new Activity();
		act.setDescription("Hellicopter");
		when(arepo.save(act)).thenReturn(act);
		Activity act1 = actimpl.insertActivity(act);
		assertEquals(act, act1);
	}
	@Test
	public void testDeleteActivity() throws ActivityNotFoundException{
		ActivityNotFoundException thrown = assertThrows("Activity Not Found",ActivityNotFoundException.class,()->{ activityser.deleteActivity(-1);});
		assertEquals(ActivityNotFoundException.class,thrown.getClass());
	}

	
}