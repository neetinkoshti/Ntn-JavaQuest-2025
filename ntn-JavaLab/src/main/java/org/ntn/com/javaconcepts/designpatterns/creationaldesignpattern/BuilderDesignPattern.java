package org.ntn.com.javaconcepts.designpatterns.creationaldesignpattern;

import java.util.Date;

public class BuilderDesignPattern {

    public static void main(String[] args) {

        Employee employee1 = new Employee.EmployeeBuilder()
                .setId(101)
                .setName("John")
                .setLocation("mumbai")
                .setSalary(10.124)
                .setDateOfJoin(new Date())
                .build();

        System.out.println(employee1);

        Employee employee2 = new Employee.EmployeeBuilder()
                .setId(101)
                .setName("rocky")
                .setLocation("london")
                .setDateOfJoin(new Date())
                .build();

        System.out.println(employee2);
    }

}

class Employee{

    private int id;
    private String name;
    private double salary;
    private String location;
    private Date dateOfBirth;
    private Date dateOfJoin;

    public Employee(int id, String name, double salary, String location, Date dateOfBirth, Date dateOfJoin) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.location = location;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfJoin=" + dateOfJoin +
                '}';
    }

    static class EmployeeBuilder{

        private int id;
        private String name;
        private double salary;
        private String location;
        private Date dateOfBirth;
        private Date dateOfJoin;

        public EmployeeBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public EmployeeBuilder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public EmployeeBuilder setDateOfJoin(Date dateOfJoin) {
            this.dateOfJoin = dateOfJoin;
            return this;
        }

        public Employee build(){
            return new Employee(id,name,salary,location,dateOfBirth,dateOfJoin);
        }

    }


}