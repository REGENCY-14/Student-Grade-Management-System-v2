package com.studentgrade.ui;

import com.studentgrade.model.*;
import com.studentgrade.manager.GradeManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu class handles all user interactions and menu navigation.
 * Separated from Main for better separation of concerns.
 */
public class Menu {

    // Scanner for user input
    private Scanner scanner;

    // List to store all students
    private ArrayList<Student> students;

    // Counter for generating unique student IDs
    private int studentIdCounter;

    // Grade manager to handle grade-related operations
    private GradeManager gradeManager;

    // Constructor - initializes all dependencies
    public Menu(Scanner scanner, ArrayList<Student> students, 
                int initialStudentId, GradeManager gradeManager) {
        this.scanner = scanner;
        this.students = students;
        this.studentIdCounter = initialStudentId;
        this.gradeManager = gradeManager;
        
        // Set grade manager reference for all students
        for (Student student : students) {
            student.setGradeManager(gradeManager);
        }
    }

    // ---------------------- MAIN MENU LOOP ----------------------
    /**
     * Main menu loop that runs until user chooses to exit.
     * Handles all menu navigation and operations.
     */
    public void start() {
        boolean running = true;

        // Main loop for menu navigation
        while (running) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Menu options
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    recordGrade();
                    break;
                case 4:
                    viewGradeReport();
                    break;
                case 5:
                    running = false; // Exit program
                    System.out.println("Thank you for using grade management system!");
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    // ---------------------- MAIN MENU ----------------------
    /**
     * Displays the main menu options.
     */
    private void displayMainMenu() {
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

    // ---------------------- ADD STUDENT ----------------------
    /**
     * Prompts user to add a new student to the system.
     * Allows selection of student type (Regular or Honors).
     */
    private void addStudent() {
        System.out.println("-------------- ADD STUDENT ----------------");

        // Get student details from user
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();

        System.out.print("Enter student phone: ");
        String phone = scanner.nextLine();

        // Select student type: Regular or Honors
        System.out.println("Select student type:");
        System.out.println("1. Regular Student");
        System.out.println("2. Honors Student");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        // Assign unique ID to student
        int id = studentIdCounter++;

        // Add student based on type
        if (type == 1) {
            Student student = new RegularStudent(id, name, age, email, phone);
            student.setGradeManager(gradeManager);
            students.add(student);
            System.out.println("Regular student added!");
        } else if (type == 2) {
            Student student = new HonorsStudent(id, name, age, email, phone);
            student.setGradeManager(gradeManager);
            students.add(student);
            System.out.println("Honors student added!");
        } else {
            System.out.println("Invalid choice!");
        }

        System.out.println("--------------------------------------------");
    }

    // ---------------------- VIEW STUDENTS ----------------------
    /**
     * Displays all students in the system with their details and statistics.
     */
    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students have been added to the system.\n");
            return;
        }

        // Header for student list
        System.out.println("\nSTUDENT LIST");
        System.out.printf("%-6s %-20s %-10s %-12s %-10s %-10s %-12s\n",
                "ID", "NAME", "TYPE", "AVG GRADE", "SUBJECTS", "STATUS", "PASSING GRADE");
        System.out.println("----------------------------------------------------------------------------------------");

        double totalGrades = 0; // Sum of averages
        int countGrades = 0;    // Number of students with grades

        // Display first 5 students or all if less
        int displayCount = Math.min(students.size(), 5);
        for (int i = 0; i < displayCount; i++) {
            Student s = students.get(i);
            double avg = s.getAverageGrade();

            if (avg > 0) {
                totalGrades += avg;
                countGrades++;
            }

            // Print student info in formatted table
            System.out.printf("%-6d %-20s %-10s %-12.2f %-10d %-10s %-12d\n",
                    s.id,
                    s.name,
                    s.getType(),
                    avg,
                    s.getEnrolledSubjects(),
                    s.getStatus(),
                    s.getPassingGrade()
            );

            // Special check for Honors eligibility
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

    // ---------------------- RECORD GRADE ----------------------
    /**
     * Allows user to record a grade for a student in a subject.
     */
    private void recordGrade() {
        System.out.println("------------- RECORD GRADE ----------------");

        // Get student ID for grade
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Find student object
        Student selected = null;
        for (Student s : students) {
            if (s.id == id) {
                selected = s;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Student not found!");
            return;
        }

        // Select subject type: Core or Elective
        System.out.println("Select subject category:");
        System.out.println("1. Core Subject");
        System.out.println("2. Elective Subject");
        System.out.print("Enter choice: ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Subject subject = null;

        if (type == 1) { // Core subjects
            System.out.println("Select Core Subject:");
            System.out.println("1. Mathematics");
            System.out.println("2. English");
            System.out.println("3. Science");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) subject = new CoreSubject("Mathematics", "C-MATH");
            else if (choice == 2) subject = new CoreSubject("English", "C-ENG");
            else if (choice == 3) subject = new CoreSubject("Science", "C-SCI");
            else {
                System.out.println("Invalid subject!");
                return;
            }

        } else if (type == 2) { // Elective subjects
            System.out.println("Select Elective Subject:");
            System.out.println("1. Music");
            System.out.println("2. Art");
            System.out.println("3. Physical Education");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) subject = new ElectiveSubject("Music", "E-MUS");
            else if (choice == 2) subject = new ElectiveSubject("Art", "E-ART");
            else if (choice == 3) subject = new ElectiveSubject("Physical Education", "E-PE");
            else {
                System.out.println("Invalid subject!");
                return;
            }
        }

        // Enter grade value
        System.out.print("Enter grade (0 - 100): ");
        double g = scanner.nextDouble();
        scanner.nextLine();

        // Validate grade range
        if (g < 0 || g > 100) {
            System.out.println("Invalid grade! Must be between 0 and 100.");
            return;
        }

        // Create grade object and add to grade manager
        Grade newGrade = new Grade(id, subject, g);
        gradeManager.addGrade(newGrade);

        System.out.println("\n✔ Grade recorded successfully!");
        newGrade.displayGradeDetails();
    }

    // ---------------------- VIEW GRADE REPORT ----------------------
    /**
     * Displays grade report for a specific student.
     */
    private void viewGradeReport() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Delegate grade report display to GradeManager
        gradeManager.viewGradeByStudent(id);
    }
}
