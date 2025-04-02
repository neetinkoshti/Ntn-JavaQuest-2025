package org.ntn.com.javaconcepts.comparator;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String location;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getLocation() {
        return location;
    }

    public Employee(int id, String name, double salary, String location) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
