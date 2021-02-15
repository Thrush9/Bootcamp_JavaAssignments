package com.stackroute.oops;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.oops.Employee.EmployeeBuilder;

public class EmployeeTests {
	
	private static final String MSG_01 = "should set all basic properties to Employee Object";
	private static final String MSG_02 = "should add Optional Age property to Employee Object";
	private static final String MSG_03 = "should add Optional Address property to Employee Object";
	private static final String MSG_04 = "should add Optional Phone property to Employee Object";
	private static final String MSG_05 = "should display all proprties added to Employee Object";
	private static final String MSG_06 = "should add zero as age, when invalid age added to Employee Object";
	private static final String MSG_07 = "should add 'Invalid' as phone,when invalid phone added to Employee Object";
	private static final String MSG_08 = "should display default values,when invalid data added to Employee Object";
	
	private Employee employee;
	private EmployeeBuilder empbuilder;
	
	@BeforeEach
	public void setUp() {
		empbuilder = new EmployeeBuilder(101, "John", "Doe");
		employee = new Employee(empbuilder);
	}

	@AfterEach
	public void tearDown() {
		empbuilder = null;
		employee = null;
	}
	
	@Test
	public void basicEmployeeObject() {
		assertEquals(101,employee.getId(),MSG_01);
		assertEquals("John",employee.getFirstName(),MSG_01);
		assertEquals("Doe",employee.getLastName(),MSG_01);
	}
	
	@Test
	public void addOptionalAgeSuccess() {
		empbuilder.withOptionalAge((short)50);
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		assertEquals(String.valueOf((short)50),String.valueOf(employee.getAge()),MSG_02);
	}
	
	@Test
	public void addOptionalAddressSuccess() {
		empbuilder.withOptionalAddress("Hollywood");
		employee = new Employee(empbuilder);
		assertEquals("Hollywood",employee.getAddress(),MSG_03);
	}
	
	@Test
	public void addOptionalPhoneSuccess() {
		empbuilder.withOptionalPhone("1029384756");
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		assertEquals("1029384756",employee.getPhone(),MSG_04);
	}
	
	@Test
	public void getEmployeeDetails() {
		empbuilder.withOptionalAge((short)50);
		empbuilder.withOptionalPhone("1029384756");
		empbuilder.withOptionalAddress("Hollywood");
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		String details = "Employee{id=101, firstName=John, lastName=Doe, age=50, phone=1029384756, address=Hollywood}";
		assertEquals(details,employee.toString(),MSG_05);
	}
	
	@Test
	public void getEmployeeDetailsWithInvaildAge() {
		empbuilder.withOptionalAge((short)65);
		empbuilder.withOptionalPhone("1029384756");
		empbuilder.withOptionalAddress("Hollywood");
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		assertEquals(0,employee.getAge(),MSG_06);
	}
	
	@Test
	public void getEmployeeDetailsWithInvaildPhone() {
		empbuilder.withOptionalAge((short)45);
		empbuilder.withOptionalPhone("1029384uop");
		empbuilder.withOptionalAddress("Hollywood");
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		assertEquals("Invalid",employee.getPhone(),MSG_07);
	}
	
	@Test
	public void getEmployeeDetailsWithInvaildAgeandPhone() {
		empbuilder.withOptionalAge((short)70);
		empbuilder.withOptionalPhone("1029384uiop");
		empbuilder.withOptionalAddress("Hollywood");
		empbuilder.buildEmployee();
		employee = new Employee(empbuilder);
		String details = "Employee{id=101, firstName=John, lastName=Doe, age=0, phone=Invalid, address=Hollywood}";
		assertEquals(details,employee.toString(),MSG_08);
	}
	
}
