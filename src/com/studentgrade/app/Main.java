package com.studentgrade.app;

import com.studentgrade.model.Student;
import com.studentgrade.manager.GradeManager;
import com.studentgrade.ui.Menu;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main entry point for the Student Grade Management System.
 * Initializes all dependencies and starts the menu.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize dependencies
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int initialStudentId = 1000;
        GradeManager gradeManager = new GradeManager(students);

        // Create and start menu
        Menu menu = new Menu(scanner, students, initialStudentId, gradeManager);
        menu.start();

        // Clean up resources
        scanner.close();
    }
}
