package model;

public class OfficeWorker extends Employee {

    private String position;

    public OfficeWorker(int id, String firstName, String lastName, double salary, String position ) {

        super(id, firstName, lastName, salary);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
