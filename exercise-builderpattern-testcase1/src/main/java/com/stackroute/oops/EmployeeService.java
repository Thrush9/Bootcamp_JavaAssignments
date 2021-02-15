package com.stackroute.oops;

public class EmployeeService {
    public Employee createBasicEmployee(int id, String firstName, String lastName) {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, firstName, lastName);
        return builder.buildEmployee();
    }

    public Employee createEmployeeWithAddress(int id, String firstName, String lastName, String address) {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, firstName, lastName);
        builder.withOptionalAddress(address);
        return builder.buildEmployee();
    }

    public Employee createEmployeeWithAge(int id, String firstName, String lastName, short age) {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, firstName, lastName);
        builder.withOptionalAge(age);
        return builder.buildEmployee();
    }

    public Employee createEmployeeWithPhone(int id, String firstName, String lastName, String phone) {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, firstName, lastName);
        builder.withOptionalPhone(phone);
        return builder.buildEmployee();
    }

    public Employee createEmployeeWithAgePhoneAndAddress(int id, String firstName, String lastName, short age, String phone, String address) {
        Employee.EmployeeBuilder builder = new Employee.EmployeeBuilder(id, firstName, lastName);
        builder.withOptionalAge(age);
        builder.withOptionalPhone(phone);
        builder.withOptionalAddress(address);
        return builder.buildEmployee();
    }
}
