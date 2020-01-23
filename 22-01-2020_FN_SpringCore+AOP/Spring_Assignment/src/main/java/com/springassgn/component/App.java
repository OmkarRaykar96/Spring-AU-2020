package com.springassgn.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springassgn.service.EmployeeService;
import com.springassgn.config.AppConfig;
import com.springassgn.model.*;

@ComponentScan
public class App {
		public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
			
			EmployeeService empService = (EmployeeService) context.getBean("employeeService");
			empService.getAllEmployees();
			
			ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
			Employee emp= context2.getBean(Employee.class);
			
			System.out.println("\n\nAnnotation based way to inject variable from application.properties file in Employee object \n"+emp);
			
			((ClassPathXmlApplicationContext) context).close();
			((AnnotationConfigApplicationContext) context2).close();
		}
}
