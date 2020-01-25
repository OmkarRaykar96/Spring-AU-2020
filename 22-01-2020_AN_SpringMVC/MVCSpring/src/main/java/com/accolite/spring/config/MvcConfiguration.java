package com.accolite.spring.config;
 
import javax.sql.DataSource;     

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.accolite.spring.dao.EmployeeDAO;
import com.accolite.spring.dao.EmployeeDAOImpl;
 
@Configuration
@ComponentScan(basePackages="net.codejava.*")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	 
	@Bean
	public InternalResourceViewResolver resolver() {
	    InternalResourceViewResolver vr = new InternalResourceViewResolver();
	    vr.setPrefix("/WEB-INF/jsp/");
	    vr.setSuffix(".jsp");
	    return vr;
	}
	
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
 
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/employeedb");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
         
        return dataSource;
    }
     
    @Bean
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOImpl(getDataSource());
    }
}	