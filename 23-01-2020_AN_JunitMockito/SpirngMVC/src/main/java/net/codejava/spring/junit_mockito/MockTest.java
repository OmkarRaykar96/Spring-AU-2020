package net.codejava.spring.junit_mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations.Mock;

import junit.framework.Assert;
import net.codejava.spring.dao.EmployeeDAO;
import net.codejava.spring.dao.EmployeeDAOImpl;
import net.codejava.spring.model.Employee;

import net.codejava.spring.model.*;

public class MockTest {

	@InjectMocks
	EmployeeDAOImpl empDaoMock = new EmployeeDAOImpl();

	@Mock
	EmployeeDAO empDaoService = mock(EmployeeDAO.class);

	Employee employeeTestObject_1 = new Employee("Omkar", "Raykar", "o.r@gmail.com", "9787879878");
	Employee employeeTestObject_2 = new Employee("Abhigyan", "Nayak", "a.n@gmail.com", "9787879870");

	@Test
	public void testEmpDao() throws EmployeeNotFoundException, SQLException {
		empDaoMock.saveOrUpdate(new Employee("Garuav", "Yadav", "g.y@gmail.com", "9787879871"));
		empDaoMock.saveOrUpdate(new Employee("Rohan", "Pawar", "r.p@gmail.com", "9787879872"));

		doAnswer(invocation -> {
			employeeTestObject_2 = (Employee) invocation;
			Assert.assertEquals(employeeTestObject_2.getF_name().length(), 8, 7);
			Assert.assertEquals(employeeTestObject_2.getId(), 10, 10);
			return null;
		}).when(empDaoService).saveOrUpdate(any(Employee.class));

		doAnswer(invocation -> {
			Employee t = (Employee) invocation;
			System.out.println("Updating Employee" + t);
			Assert.assertEquals(t.getId(), 0);
			employeeTestObject_1 = t;
			return null;
		}).when(empDaoService).saveOrUpdate(any(Employee.class));

		doAnswer(invocation -> {
			Assert.assertEquals(invocation, 0);
			System.out.println("Employee Deletion for id= " + invocation);
			return null;
		}).when(empDaoService).delete(3);

		when(empDaoService.get(0)).thenReturn(employeeTestObject_1);

		empDaoMock.saveOrUpdate(new Employee("Rohit", "Gonsalves", "r.g@gmail.com", "9787879873"));
		empDaoMock.saveOrUpdate(new Employee("Darshan", "Patil", "d.p@gmail.com", "9787879874"));
		Employee emp1 = empDaoMock.get(0);
		System.out.println(emp1);

		Employee data = empDaoMock.get(0);
		Assert.assertEquals(data, emp1);
	}
}