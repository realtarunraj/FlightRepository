package com.flight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.Admin;
import com.flight.model.Ticket;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
	public Boolean existsByEmail(String email);
	
	@Query("select t from Ticket t order by t.dateTime")
	public List<Ticket> getTicketsDateWise();
	
	@Query("select t from Ticket t where t.customer.customerId=:id and t.dateTime between :start and :end")
	public List<Ticket> getTicketsBetweenDays(@Param("id") int id,@Param("start") LocalDate start,@Param("end") LocalDate end);

	@Query("select t from Ticket t Order by t.customer.userName")
	public List<Ticket> getTicketsCustomerWise();
	
	public Admin findByEmail(String email);

}
