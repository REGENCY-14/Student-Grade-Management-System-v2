import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static int studentIdCounter = 1000;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            mainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                running = false;
                System.out.println("Thank you for using grade management system!");
                System.out.println("Goodbye");
            }
        }
    }

    public static void mainMenu() {
        System.out.println("============================================");
        System.out.println("||    STUDENT GRADE MANAGEMENT SYSTEM     ||");
        System.out.println("============================================");

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Record Grade");
        System.out.println("4. View Grade Report");
        System.out.println("5. Exit");

        System.out.print("Enter choice: ");
    }

    public static void addStudent() {
        System.out.println("-------------- ADD STUDENT ----------------");

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student phone: ");
        String phone = scanner.nextLine();

        System.out.println("Select student type:");
        System.out.println("1. Regular Student");
        System.out.println("2. Honors Student");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        int id = studentIdCounter++;

        if (type == 1) {
            students.add(new RegularStudent(id, name, age, email, phone));
            System.out.println("Regular student added!");
        } else {
            students.add(new HonorsStudent(id, name, age, email, phone));
            System.out.println("Honors student added!");
        }

        System.out.println("--------------------------------------------");
    }

    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students have been added to the system.\n");
            return;
        }

        System.out.println("\nSTUDENT LIST");
        System.out.printf("%-6s %-20s %-10s %-12s %-10s %-10s %-12s\n",
                "ID", "NAME", "TYPE", "AVG GRADE", "SUBJECTS", "STATUS", "PASSING GRADE");
        System.out.println("----------------------------------------------------------------------------------------");

        double totalGrades = 0;
        int countGrades = 0;

        int displayCount = Math.min(students.size(), 5);
        for (int i = 0; i < displayCount; i++) {
            Student s = students.get(i);
            double avg = s.getAverageGrade();

            if (avg > 0) {
                totalGrades += avg;
                countGrades++;
            }

            System.out.printf("%-6d %-20s %-10s %-12.2f %-10d %-10s %-12d\n",
                    s.id,
                    s.name,
                    s.getType(),
                    avg,
//                    s.getEnrolledSubjects(),
                    s.getStatus(),
                    s.getPassingGrade()
            );

            if (s instanceof HonorsStudent && avg >= s.getPassingGrade()) {
                System.out.println("Honors Eligible!");
            }
        }

        System.out.println("----------------------------------------------------------------------------------------");

        System.out.println("Total Students: " + students.size());

        if (countGrades > 0) {
            System.out.printf("Class Average Grade: %.2f\n", (totalGrades / countGrades));
        } else {
            System.out.println("Class Average Grade: N/A");
        }

        System.out.println();
    }
}
