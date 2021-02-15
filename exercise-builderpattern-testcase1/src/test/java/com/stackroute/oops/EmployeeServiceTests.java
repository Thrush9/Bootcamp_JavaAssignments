package com.stackroute.oops;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.oops.Employee.EmployeeBuilder;

public class EmployeeServiceTests {
	
	private static final String MSG_01 = "create Employee Object with Basic Details";
	private static final String MSG_02 = "create Employee Object with Basic Details and Optional Addres";
	private static final String MSG_03 = "create Employee Object with Basic Details and Optional Age";
	private static final String MSG_04 = "create Employee Object with Basic Details and Optional Phone";
	private static final String MSG_05 = "create Employee Object with Basic Details and Optional Address,Age,Phone";
	
	private EmployeeService empService;
	
	@BeforeEach
	public void setUp() {
		empService = new EmployeeService();
	}

	@AfterEach
	public void tearDown() {
		empService = null;
	}

	@Test
	public void createBasicEmployeeSuccess() {
		EmployeeBuilder builder = new EmployeeBuilder(101, "Super", "Star");
		Employee emp = new Employee(builder);
		assertEquals(emp.toString(),empService.createBasicEmployee(101, "Super", "Star").toString(),MSG_01);
	}
	
	@Test
	public void createEmployeeWithAddressSuccess() {
		EmployeeBuilder builder = new EmployeeBuilder(101, "Power", "Star");
		builder.withOptionalAddress("Box Office");
		Employee emp = new Employee(builder);
		assertEquals(emp.toString(),empService.createEmployeeWithAddress(101, "Power", "Star", "Box Office").toString(),MSG_02);
	}
	
	@Test
	public void createEmployeeWithAgeSuccess() {
		EmployeeBuilder builder = new EmployeeBuilder(101, "Stylish", "Star");
		builder.withOptionalAge((short) 40);
		Employee emp = new Employee(builder);
		assertEquals(emp.toString(),empService.createEmployeeWithAge(101, "Stylish", "Star",(short) 40).toString(),MSG_03);
	}
	
	@Test
	public void createEmployeeWithPhoneSuccess() {
		EmployeeBuilder builder = new EmployeeBuilder(101, "Natural", "Star");
		builder.withOptionalPhone("9876543210");
		Employee emp = new Employee(builder);
		assertEquals(emp.toString(),empService.createEmployeeWithPhone(101, "Natural", "Star","9876543210").toString(),MSG_04);
	}
	
	@Test
	public void createEmployeeWithAgePhoneAndAddressSuccess() {
		EmployeeBuilder builder = new EmployeeBuilder(101, "Mega", "Star");
		builder.withOptionalAddress("Box Office");
		builder.withOptionalAge((short) 60);
		builder.withOptionalPhone("9876543210");
		Employee emp = new Employee(builder);
		assertEquals(emp.toString(),empService.createEmployeeWithAgePhoneAndAddress(101, "Mega", "Star",(short) 60, "9876543210", "Box Office").toString(),MSG_05);
	}
}
