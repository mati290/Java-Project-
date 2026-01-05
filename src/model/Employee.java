package model;

public abstract class Employee extends Person {

    protected double salary;

    public Employee(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
