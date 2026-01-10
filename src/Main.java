import model.*;
import service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final EmployeeService employeeService = new EmployeeService();
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> listStudents();
                case 3 -> addEmployee();
                case 4 -> listEmployees();
                case 5 -> addCourse();
                case 6 -> listCourses();
                case 0 -> running = false;
                default -> System.out.println("Niepoprawna opcja");
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
                
                === SYSTEM UCZELNI ===
                1. Dodaj studenta
                2. Lista studentów
                3. Dodaj pracownika
                4. Lista pracowników
                5. Dodaj kurs
                6. Lista kursów
                0. Wyjście
                """);
    }

    // ---------- STUDENT ----------
    private static void addStudent() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Imię: ");
        String firstName = scanner.nextLine();

        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.print("Średnia: ");
        double avg = scanner.nextDouble();

        studentService.add(new Student(id, firstName, lastName, avg));
        System.out.println("Student dodany");
    }

    private static void listStudents() {
        studentService.getAll()
                .forEach(s -> System.out.println(
                        s.getId() + " " +
                                s.getFirstName() + " " +
                                s.getLastName() + " | " +
                                s.getAverageGrade()
                ));
    }

    // ---------- PRACOWNIK ----------
    private static void addEmployee() {
        System.out.println("1. Wykładowca");
        System.out.println("2. Pracownik biurowy");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Imię: ");
        String firstName = scanner.nextLine();

        System.out.print("Nazwisko: ");
        String lastName = scanner.nextLine();

        System.out.print("Pensja: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Godziny: ");
            int hours = scanner.nextInt();
            scanner.nextLine();

            employeeService.add(
                    new Lecturer(id, firstName, lastName, salary, List.of("Java"), hours)
            );
        } else {
            System.out.print("Stanowisko: ");
            String position = scanner.nextLine();

            employeeService.add(
                    new OfficeWorker(id, firstName, lastName, salary, position)
            );
        }

        System.out.println("Pracownik dodany");
    }

    private static void listEmployees() {
        employeeService.getAll()
                .forEach(e -> System.out.println(
                        e.getId() + " " +
                                e.getFirstName() + " " +
                                e.getLastName() + " | " +
                                e.getSalary()
                ));
    }

    private static void addCourse() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nazwa: ");
        String name = scanner.nextLine();

        courseService.add(new Course(id, name));
        System.out.println("Kurs dodany");
    }

    private static void listCourses() {
        courseService.getAll()
                .forEach(c -> System.out.println(
                        c.getId() + " " + c.getName()
                ));
    }
}
