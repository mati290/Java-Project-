package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public void remove(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> findByName(String text) {
        return students.stream()
                .filter(s -> s.getFirstName().equalsIgnoreCase(text)
                        || s.getLastName().equalsIgnoreCase(text))
                .toList();
    }

    public List<Student> findByAverage(double minAverage) {
        return students.stream()
                .filter(s -> s.getAverageGrade() >= minAverage)
                .toList();
    }

    public List<Student> getAll() {
        return students;
    }
}
