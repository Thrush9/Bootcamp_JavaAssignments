package com.stackroute.oops;

public class Employee {
    /*
    Employee class is having six fields where id, firstName and lastName are required fields.
    But age,phone and address are optional fields.
     */
    private int id;
    private String firstName;
    private String lastName;
    private short age;
    private String phone;
    private String address;

    /*
    Constructor accepting EmployeeBuilder as argument while creating employee object
     */

    public Employee(EmployeeBuilder employeeBuilder) {
        this.id = employeeBuilder.id;
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;

        this.age = employeeBuilder.age;
        this.phone = employeeBuilder.phone;
        this.address = employeeBuilder.address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public short getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /*
    Employee details are returned as string by overriding toString() method
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ", phone=" + phone +
                ", address=" + address +
                '}';
    }

    /*
    static nested class for building employee object with optional values
     */
    public static class EmployeeBuilder {

        private int id;
        private String firstName;
        private String lastName;
        private short age;
        private String phone;
        private String address;

        public EmployeeBuilder(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public EmployeeBuilder withOptionalAge(short age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder withOptionalPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder withOptionalAddress(String address) {
            this.address = address;
            return this;
        }

        /*
        Employee object is created after validating age and phone fields if they are provided
         */
        public Employee buildEmployee() {
            if (!isValidEmployeeAge()) {
                age = 0;
            }
            if (!isValidEmployeePhone()) {
                phone = "Invalid";
            }
            return new Employee(this);
        }

        /*
        Age of the employee should be between 18 and 60 if provided
        Phone number should be a 10 digit number if provided
         */
        private boolean isValidEmployeeAge() {
            boolean valid = false;
            if (age >= 18 && age <= 60) {
                valid = true;
            }
            return valid;
        }

        private boolean isValidEmployeePhone() {
            boolean valid = false;
            if (phone == null) {
                return true;
            }

            if (phone.length() == 10) {
                for (int j = 0; j < phone.length(); j++) {
                    valid = Character.isDigit(phone.charAt(j));
                    if (!valid) {
                        break;
                    }
                }
            }
            return valid;
        }
    }
}
