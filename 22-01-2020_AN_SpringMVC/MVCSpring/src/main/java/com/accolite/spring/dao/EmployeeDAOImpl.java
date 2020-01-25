package com.accolite.spring.dao;

import java.sql.*; 
import java.util.*;
import javax.sql.*;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.spring.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;
	 
    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void saveOrUpdate(Employee employee) {
    	if (employee.getId() > 0) {
            String sql = "UPDATE employee SET first_name=?, last_name=?, email=?, contact=? WHERE employee_id=?";
            jdbcTemplate.update(sql, employee.getF_name(), employee.getL_name(), employee.getEmail(),  employee.getTelephone(),  employee.getId());
        } else {
            String sql = "INSERT INTO employee (first_name, last_name, email, contact)"
                        + " VALUES (?, ?, ?, ?)";
            jdbcTemplate.update(sql, employee.getF_name(), employee.getL_name(), employee.getEmail(),  employee.getTelephone());
        }
    }
    
    @Override
    public void delete(int employeeId) {
    	String sql = "DELETE FROM employee WHERE employee_id=?";
        jdbcTemplate.update(sql, employeeId);
    }
    
    @Override
    public List<Employee> list() {
    	String sql = "SELECT * FROM employee";
        List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
     
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            	Employee employee_obj = new Employee();
     
            	employee_obj.setId(rs.getInt("employee_id"));
            	employee_obj.setF_name(rs.getString("first_name"));
            	employee_obj.setL_name(rs.getString("last_name"));
            	employee_obj.setEmail(rs.getString("email"));
            	employee_obj.setTelephone(rs.getString("contact"));
     
                return employee_obj;
            }
     
        });
        return listEmployee;
    }
    
    @Override
    public Employee get(int employeeId) {
    	String sql = "SELECT * FROM employee WHERE employee_id=" + employeeId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
     
            @Override
            public Employee extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Employee employee_obj = new Employee();
                    employee_obj.setId(rs.getInt("employee_id"));
                    employee_obj.setF_name(rs.getString("first_name"));
                    employee_obj.setL_name(rs.getString("last_name"));
                    employee_obj.setEmail(rs.getString("email"));
                    employee_obj.setTelephone(rs.getString("contact"));
                    return employee_obj;
                }
                return null;
            }
        });
    }	
}