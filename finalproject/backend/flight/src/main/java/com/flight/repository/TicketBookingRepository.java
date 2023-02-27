package com.flight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.Ticket;
@Repository
public interface TicketBookingRepository extends CrudRepository<Ticket, Integer> {
	@Query("select t from Ticket t where t.customer.customerId=:id")
	public List<Ticket> getTicketsOfCustomer(@Param("id") Integer customerId);
	
	@Query("select t from Ticket t where t.activities.activityId=:id and t.dateTime between :start and :end")
	public List<Ticket> getTicketsOfDates(@Param("id") Integer activityId,@Param("start") LocalDate start,@Param("end") LocalDate end);
	
}
