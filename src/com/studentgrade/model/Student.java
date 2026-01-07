package com.studentgrade.model;

import com.studentgrade.manager.GradeManager;

/**
 * Base class representing a generic student.
 * This class stores basic student information and provides methods
 * for accessing their grades and status.
 */
public class Student {

    // ------------------ FIELDS ------------------
    public int id;             // Unique student ID
    public String name;        // Student's full name
    public int age;            // Student's age
    public String email;       // Student's email address
    public String phone;       // Student's phone number
    protected String status = "Active"; // Student's status, default is Active
    protected double averageGrade;      // Average grade across all subjects

    // Reference to GradeManager (injected)
    protected GradeManager gradeManager;

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new student with basic information.
     * @param id Unique student ID
     * @param name Student's name
     * @param age Student's age
     * @param email Student's email
     * @param phone Student's phone
     */
    public Student(int id, String name, int age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.averageGrade = 0; // Initial average grade
    }

    // Setter for GradeManager (dependency injection)
    public void setGradeManager(GradeManager gradeManager) {
        this.gradeManager = gradeManager;
    }

    // ------------------ METHODS ------------------

    /**
     * Returns the type of student.
     * Subclasses like RegularStudent or HonorsStudent will override this.
     */
    public String getType() {
        return "Student";
    }

    /**
     * Returns the passing grade for this student.
     * Subclasses should override this with specific thresholds.
     */
    public int getPassingGrade() {
        return 0; // Default is 0 for base class
    }

    /**
     * Returns the current average grade for this student.
     */
    public double getAverageGrade() {
        return averageGrade;
    }

    /**
     * Updates the student's average grade.
     * @param grade New average grade to set
     */
    public void setAverageGrade(double grade) {
        this.averageGrade = grade;
    }

    /**
     * Returns the student's status (Active/Inactive).
     * Can be overridden by subclasses if needed.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns the number of subjects the student is enrolled in.
     * Retrieves the count from the GradeManager.
     */
    public int getEnrolledSubjects() {
        if (gradeManager != null) {
            return gradeManager.getSubjectCountForStudent(this.id);
        }
        return 0;
    }
}
