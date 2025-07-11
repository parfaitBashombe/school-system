public class Professor extends Person {
    private static int idCounter = 0;
    private final String employeeId;
    String courseToTeach;
    String department;

    Professor(String name, int age, String courseToTeach, String department) {
        super(name, age);
        this.employeeId = generateId();
        this.courseToTeach = courseToTeach;
        this.department = department;
    }

    private synchronized String generateId() {
        idCounter++;
        return "P" + String.format("%05d", idCounter);
    }

    public String getId() {
        return employeeId;
    }

    void displayProfessor() {
        displayInfo();
        System.out.println("Employee ID: " + employeeId + ", Teaching: " + courseToTeach + ", Department: " + department);
    }
}