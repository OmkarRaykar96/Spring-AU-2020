package com.example.demo;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList; 
import java.util.List;



@Path("/apis")
public class Controller {
	
	private static List<Employee> employee = new ArrayList<Employee>(); //
	
	@GET
	@Produces("application/json")
	public List<Employee> displayAllEmployees() {
		return employee;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String[] addNewEmployee(Employee emp) {
		employee.add(emp);
		String [] arr= {"Employee","Added","Successfully!!!"};
		return arr;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update/{emp_id}")
	public List<Employee>  updateBoys(@PathParam("emp_id") int employeeId, Employee emp) {
		employee.set(employeeId, emp);
		return employee;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{emp_id}")
	public List<Employee>  deleteBoys(@PathParam("emp_id") int employeeId) {
		employeeId--;
		employee.remove(employeeId);
		return employee;
	}
    
}