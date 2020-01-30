package net.codejava.spring.junit_mockito;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Employee Not Found")
public class EmployeeNotFoundException extends Exception {
	
	public EmployeeNotFoundException(){
		super("EmployeeNotFoundException");
	}
	
}