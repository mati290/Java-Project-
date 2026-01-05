package model;

import java.util.List;


public class Lecturer extends Employee {
    private final List<String> courses;
    private final int hours;

    public Lecturer(int  id, String firstName, String lastName, double salary, List<String> courses,  int hours) {
        super(id, firstName, lastName, salary);
        this.courses = courses;
        this.hours = hours;
    }
    public List<String> getCourses() {
        return courses;
    }

    public int getHours() {
        return hours;
    }
}
