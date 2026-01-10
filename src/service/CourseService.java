package service;

import model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    private final List<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
    }

    public void remove(int id) {
        courses.removeIf(c -> c.getId() == id);
    }

    public Course findById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Course> findByName(String name) {
        return courses.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .toList();
    }

    public List<Course> getAll() {
        return courses;
    }
}
