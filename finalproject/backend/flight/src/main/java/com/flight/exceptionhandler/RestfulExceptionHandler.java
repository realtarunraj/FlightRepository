package com.flight.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flight.exception.ActivityAlreadyExists;
import com.flight.exception.ActivityNotFoundException;
import com.flight.exception.AdminAlreadyExists;
import com.flight.exception.AdminNotFoundException;
import com.flight.exception.CustomerAlreadyExists;
import com.flight.exception.CustomerNotFoundException;
import com.flight.exception.InvalidPasswordException;
import com.flight.exception.NoActivitiesFoundException;
import com.flight.exception.NoAdminsFoundException;
import com.flight.exception.NoCustomersFoundException;
import com.flight.exception.NoTicketsFoundException;
import com.flight.exception.TicketAlreadyExists;
import com.flight.exception.TicketNotFoundException;

@RestControllerAdvice
public class RestfulExceptionHandler {
	
	@ExceptionHandler(ActivityNotFoundException.class)
	public ResponseEntity<String> ActivityNotFoundException() {
		return new ResponseEntity<String>("Activity Not Found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NoActivitiesFoundException.class)
	public ResponseEntity<String> NoActivitiesFoundException() {
		return new ResponseEntity<String>("no Activities found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(ActivityAlreadyExists.class)
	public ResponseEntity<String> ActivityAlreadyExists() {
		return new ResponseEntity<String>("Activity already exists", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<String> AdminNotFoundException() {
		return new ResponseEntity<String>("Admin Not found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NoAdminsFoundException.class)
	public ResponseEntity<String> NoAdminsFoundException() {
		return new ResponseEntity<String>("no admins found exceptions", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(AdminAlreadyExists.class)
	public ResponseEntity<String> AdminAlreadyExists() {
		return new ResponseEntity<String>("Admin already exists", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> CustomerNotFoundException() {
		return new ResponseEntity<String>("Customer not found exception", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NoCustomersFoundException.class)
	public ResponseEntity<String> NoCustomersFoundException() {
		return new ResponseEntity<String>("no customers found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(CustomerAlreadyExists.class)
	public ResponseEntity<String> CustomerAlreadyExists() {
		return new ResponseEntity<String>("customer already exists", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(TicketNotFoundException.class)
	public ResponseEntity<String> TicketNotFoundException() {
		return new ResponseEntity<String>("ticket not found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NoTicketsFoundException.class)
	public ResponseEntity<String> NoTicketsFoundException() {
		return new ResponseEntity<String>("no tickets found", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(TicketAlreadyExists.class)
	public ResponseEntity<String> TicketAlreadyExists() {
		return new ResponseEntity<String>("tickets already exists", HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<String> InvalidPasswordException() {
		return new ResponseEntity<String>("Wrong password", HttpStatus.NOT_FOUND) ;
	}
}
