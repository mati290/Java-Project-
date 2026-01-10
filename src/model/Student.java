package model;

public class Student extends Person {
    private double averageGrade;

    public Student(int id, String firstName, String lastName, double averageGrade) {
        super(id, firstName, lastName);
        this.averageGrade = averageGrade;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
