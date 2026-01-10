package service;

import model.Employee;
import model.Lecturer;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    public Employee findById(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findByName(String text) {
        return employees.stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(text)
                        || e.getLastName().equalsIgnoreCase(text))
                .toList();
    }

    public List<Employee> getAll() {
        return employees;
    }


    public List<Lecturer> findLecturersByCourse(String course) {
        return employees.stream()
                .filter(e -> e instanceof Lecturer)
                .map(e -> (Lecturer) e)
                .filter(l -> l.getCourses().contains(course))
                .toList();
    }

    public List<Lecturer> findLecturersByHours(int minHours) {
        return employees.stream()
                .filter(e -> e instanceof Lecturer)
                .map(e -> (Lecturer) e)
                .filter(l -> l.getHours() >= minHours)
                .toList();
    }
}
