package com.studentgrade.manager;

import com.studentgrade.model.Grade;
import com.studentgrade.model.Student;
import java.util.ArrayList;
import java.util.Comparator;

public class GradeManager {

    // Array to store up to 200 grades
    private final Grade[] grades = new Grade[200];
    private int gradeCount = 0; // Number of grades currently stored
    
    // Reference to student list
    private ArrayList<Student> students;

    // Constructor with dependency injection
    public GradeManager(ArrayList<Student> students) {
        this.students = students;
    }

    // Alternative constructor for backwards compatibility
    public GradeManager() {
        this.students = new ArrayList<>();
    }

    // Setter for students list
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // ------------------ ADD GRADE ------------------
    /**
     * Adds a new grade to the system.
     * Updates the student's average after adding the grade.
     * @param grade Grade object to add
     */
    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade; // Add grade and increment count
            updateStudentAverage(grade.getStudentId()); // Recalculate student's average
        } else {
            System.out.println("Grade storage full!");
        }
    }

    // ------------------ UPDATE STUDENT AVERAGE ------------------
    /**
     * Calculates and updates the average grade for a student.
     * @param studentId ID of the student
     */
    private void updateStudentAverage(int studentId) {
        double total = 0;
        int count = 0;

        // Sum all grades for the student
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentId) {
                total += grades[i].getGrade();
                count++;
            }
        }

        // Find student object
        Student s = findStudentById(studentId);
        if (s != null && count > 0) {
            s.setAverageGrade(total / count); // Update student's average
        }
    }

    // ------------------ FIND STUDENT BY ID ------------------
    /**
     * Finds a student in the student list using student ID.
     * @param studentId ID to search
     * @return Student object if found, null otherwise
     */
    private Student findStudentById(int studentId) {
        for (Student s : students) {
            if (s.id == studentId) return s;
        }
        return null;
    }

    // ------------------ VIEW GRADES FOR A STUDENT ------------------
    /**
     * Displays all grades for a specific student in reverse chronological order.
     * Also shows averages for core, elective, and overall grades, plus performance status.
     * @param studentId ID of the student
     */
    public void viewGradeByStudent(int studentId) {
        ArrayList<Grade> studentGrades = new ArrayList<>();

        // Collect all grades for this student
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentId) {
                studentGrades.add(grades[i]);
            }
        }

        if (studentGrades.isEmpty()) {
            System.out.println("No grades recorded for this student.");
            return;
        }

        // Sort grades by date (latest first)
        studentGrades.sort(Comparator.comparing(Grade::getDate).reversed());

        // Display header
        System.out.println("\n--------- GRADE REPORT FOR STUDENT " + studentId + " ---------");
        System.out.printf("%-8s %-12s %-20s %-10s %-8s\n",
                "GradeID", "Date", "Subject", "Type", "Grade");
        System.out.println("-------------------------------------------------------------");

        // Print each grade
        for (Grade g : studentGrades) {
            System.out.printf("%-8d %-12s %-20s %-10s %-8.2f\n",
                    g.getGradeId(),
                    g.getDate(),
                    g.getSubject().getSubjectName(),
                    g.getSubject().getSubjectType(),
                    g.getGrade()
            );
        }

        System.out.println("-------------------------------------------------------------");

        // Calculate and display averages
        double coreAvg = calculateCoreAverage(studentId);
        double electAvg = calculateElectiveAverage(studentId);
        double overallAvg = calculateOverallAverage(studentId);

        System.out.println("Core Subjects Average: " +
                (coreAvg == -1 ? "N/A" : String.format("%.2f", coreAvg)));

        System.out.println("Elective Subjects Average: " +
                (electAvg == -1 ? "N/A" : String.format("%.2f", electAvg)));

        System.out.println("Current Average: " +
                (overallAvg == -1 ? "N/A" : String.format("%.2f", overallAvg)));

        // Show student's performance status
        Student student = findStudentById(studentId);
        String status = (student != null) ? student.getStatus() : "N/A";
        System.out.println("Student Performance Status: " + status);

        System.out.println("-------------------------------------------------------------\n");
    }

    // ------------------ CALCULATE CORE AVERAGE ------------------
    /**
     * Calculates average grade for core subjects only.
     * @param studentId ID of the student
     * @return average grade or -1 if no core grades
     */
    public double calculateCoreAverage(int studentId) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < gradeCount; i++) {
            Grade g = grades[i];
            if (g.getStudentId() == studentId &&
                    g.getSubject().getSubjectType().equals("Core")) {
                total += g.getGrade();
                count++;
            }
        }

        return count == 0 ? -1 : total / count;
    }

    // ------------------ CALCULATE ELECTIVE AVERAGE ------------------
    /**
     * Calculates average grade for elective subjects only.
     * @param studentId ID of the student
     * @return average grade or -1 if no elective grades
     */
    public double calculateElectiveAverage(int studentId) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < gradeCount; i++) {
            Grade g = grades[i];
            if (g.getStudentId() == studentId &&
                    g.getSubject().getSubjectType().equals("Elective")) {
                total += g.getGrade();
                count++;
            }
        }

        return count == 0 ? -1 : total / count;
    }

    // ------------------ CALCULATE OVERALL AVERAGE ------------------
    /**
     * Calculates overall average for all subjects.
     * @param studentId ID of the student
     * @return average grade or -1 if no grades
     */
    public double calculateOverallAverage(int studentId) {
        double total = 0;
        int count = 0;

        for (int i = 0; i < gradeCount; i++) {
            Grade g = grades[i];
            if (g.getStudentId() == studentId) {
                total += g.getGrade();
                count++;
            }
        }

        return count == 0 ? -1 : total / count;
    }

    // ------------------ GETTERS ------------------
    /**
     * Returns the total number of grades stored.
     */
    public int getGradeCount() {
        return gradeCount;
    }

    /**
     * Returns the number of subjects a student has grades for.
     * @param studentId ID of the student
     */
    public int getSubjectCountForStudent(int studentId) {
        int count = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentId) {
                count++;
            }
        }
        return count;
    }
}
