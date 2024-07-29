import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}

public class StudentRecordManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Student Record Management System");
            System.out.println("1. Create Student");
            System.out.println("2. Read All Students");
            System.out.println("3. Read Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    readAllStudents();
                    break;
                case 3:
                    readStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    static void createStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        students.add(new Student(id, name, email));
        System.out.println("Student created successfully!");
    }

    static void readAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("+---------------+---------------+---------------+");
            System.out.println("|      ID       |      Name      |      Email     |");
            System.out.println("+---------------+---------------+---------------+");
            for (Student student : students) {
                System.out.printf("| %-12d | %-12s | %-12s |%n", student.id, student.name, student.email);
            }
            System.out.println("+---------------+---------------+---------------+");
        }
    }

    static void readStudentById() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Student student : students) {
            if (student.id == id) {
                System.out.println();
                System.out.println();
                System.out.println("+---------------+---------------+---------------+");
                System.out.println("|      ID       |      Name      |      Email     |");
                System.out.println("+---------------+---------------+---------------+");
                System.out.printf("| %-12d | %-12s | %-12s |%n", student.id, student.name, student.email);
                System.out.println("+---------------+---------------+---------------+");
                return;
            }
        }
        System.out.println();
        System.out.println(" ---------- >>>>>> Student not found.!!!!!!");
        System.out.println();
        System.out.println();
    }

    static void updateStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Student student : students) {
            if (student.id == id) {
                System.out.print("Enter new student name: ");
                student.name = scanner.nextLine();
                System.out.print("Enter new student email: ");
                student.email = scanner.nextLine();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Student student : students) {
            if (student.id == id) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}