import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    static Scanner scanner = new Scanner(System.in);


    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Professor> professors = new ArrayList<>();

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n*** Main Menu ***");
            System.out.println("1. Register");
            System.out.println("2. View All");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1 -> registerPerson();
                case 2 -> viewAll();
                case 3 -> deletePerson();
                case 4 -> {
                    isRunning = false;
                    System.out.println("Exiting the system.");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static void registerPerson() {
        System.out.println("\n*** Registration ***");
        System.out.println("1. Register Student");
        System.out.println("2. Register Professor");
        System.out.print("Enter your choice: ");
        int subChoice = scanner.nextInt();
        scanner.nextLine();

        switch (subChoice) {
            case 1 -> registerStudent();
            case 2 -> registerProfessor();
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void viewAll() {
        System.out.println("\n*** View All ***");
        System.out.println("1. View Professors");
        System.out.println("2. View Students");
        System.out.print("Enter your choice: ");
        int viewChoice = scanner.nextInt();
        scanner.nextLine();

        switch (viewChoice) {
            case 1 -> {
                if (professors.isEmpty()) {
                    System.out.println("No professors registered yet.");
                } else {
                    for (Professor p : professors) {
                        p.displayProfessor();
                        System.out.println();
                    }
                }
            }
            case 2 -> {
                if (students.isEmpty()) {
                    System.out.println("No students registered yet.");
                } else {
                    for (Student s : students) {
                        s.displayStudent();
                        System.out.println();
                    }
                }
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void deletePerson() {
        System.out.println("\n*** Delete ***");
        System.out.println("1. Delete Professor");
        System.out.println("2. Delete Student");
        System.out.print("Enter your choice: ");
        int deleteChoice = scanner.nextInt();
        scanner.nextLine();


        switch (deleteChoice) {
            case 1 -> deleteProfessor();
            case 2 -> deleteStudent();
            default -> System.out.println("Invalid choice.");
        }
    }

    public static void registerStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter course: ");
        String course = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(name, age, course, year);
        students.add(student);

        System.out.println("\nStudent registered successfully:");
        student.displayStudent();
    }

    public static void registerProfessor() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        Professor professor = new Professor(name, age, subject, department);
        professors.add(professor);

        System.out.println("\nProfessor registered successfully:");
        professor.displayProfessor();
    }

    public static void deleteProfessor() {
        System.out.println("Enter the Id to delete");
        String idToDelete = scanner.nextLine();

        boolean removed = false;

        for (int i = 0; i < professors.size(); i++) {
            if (professors.get(i).getId().equals(idToDelete)) {
                professors.remove(i);
                removed = true;
                System.out.println("Professor with Id " + idToDelete + "has been removed successfully");
                break;
            }
        }
        if (!removed) {
            System.out.println("Professor with Id " + idToDelete + " has not been found");
        }
    }

    public static void deleteStudent() {
        System.out.println("Enter the Id to delete");
        String idToDelete = scanner.nextLine();

        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(idToDelete)) {
                students.remove(i);
                removed = true;
                System.out.println("Student with Id " + idToDelete + "has been removed successfully");
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with Id " + idToDelete + " has not been found");
        }
    }


}
