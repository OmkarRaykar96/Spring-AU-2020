package com.springassgn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.springassgn.model.Employee;



@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan(basePackages = "com.*")
public class AppConfig {
	@Autowired
	public Environment env;
	
	@Bean
	public Employee getEmployee() {
		return new Employee(Integer.parseInt(env.getProperty("id")),env.getProperty("name"),env.getProperty("pos"));
	}
	
}