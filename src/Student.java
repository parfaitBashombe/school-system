public class Student extends Person {
    private static int idCounter = 0;
    private final String studentId;
    private final String course;
    private final int year;

    public Student(String name, int age, String course, int year) {
        super(name, age);
        this.studentId = generateId();
        this.course = course;
        this.year = year;
    }


    private synchronized String generateId() {
        idCounter++;
        return "S" + String.format("%05d", idCounter);
    }

    public String getId() {
        return studentId;
    }

    public void displayStudent() {
        displayInfo();
        System.out.println("Student ID: " + studentId + ", Course: " + course + ", Year: " + year);
    }
}
