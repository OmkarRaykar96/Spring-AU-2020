package com.springassgn.service;

import java.util.ArrayList; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springassgn.model.Employee;


@Component
public class EmployeeService {

	public Map<Integer,Employee> empMap;

	public EmployeeService() {
	}

	public void getAllEmployees() {
		
		System.out.println("\n\nMethod getAllEmployees() called - Data Source (Spring.xml ----(Dependency Injection)----> Hashmap ---(Values copied in)---> list and printed)");
		
		ArrayList<Employee> allEmployees = new ArrayList<Employee>(empMap.values());
		
		System.out.println(allEmployees);
	}
	
	public EmployeeService(Map<Integer, Employee> empMap) {
		this.empMap = empMap;
	}

	@Override
	public String toString() {
		return "AllEmployee [empMap=" + empMap + "]";
	}
}