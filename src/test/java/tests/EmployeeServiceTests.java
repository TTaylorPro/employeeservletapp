package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeServiceTests {
	private EmployeeService eServ;
	private EmployeeDao mockdao;
	
	@Before
	public void setup() {
		mockdao = mock(EmployeeDao.class);
		eServ = new EmployeeService(mockdao);
	}
	
	@After
	public void teardown() {
		mockdao = null;
		eServ = null;
	}
	
	@Test
	public void testConfirmLogin_success() {
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(21, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		
		when(mockdao.findAll()).thenReturn(emps);
		
		Employee actual = eServ.confirmLogin("thehulk","green");
		
		Employee expected = e1;
		
		assertEquals(expected, actual);
	}
	
	public void testConfirmLogin_fail() {
		Employee e1 = new Employee(20, "Bruce", "Banner", "thehulk", "green");
		Employee e2 = new Employee(21, "Clint", "Barton", "hawkeye", "arrows");
		
		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		
		when(mockdao.findAll()).thenReturn(emps);
		
		Employee actual = eServ.confirmLogin("thehulk","blue");
		
		Employee expected = new Employee();
		
		assertEquals(expected, actual);
	}
}
