package com.studentgrade.model;

/**
 * Represents a Regular Student in the system.
 * Inherits from the base Student class.
 * Regular students have a passing grade threshold of 50.
 */
public class RegularStudent extends Student {

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new RegularStudent with the given information.
     * @param id Unique student ID
     * @param name Student's name
     * @param age Student's age
     * @param email Student's email
     * @param phone Student's phone number
     */
    public RegularStudent(int id, String name, int age, String email, String phone) {
        super(id, name, age, email, phone); // Call base class constructor
    }

    // ------------------ OVERRIDDEN METHODS ------------------

    /**
     * Returns the type of student.
     * @return "Regular"
     */
    @Override
    public String getType() {
        return "Regular";
    }

    /**
     * Returns the passing grade threshold for Regular students.
     * @return 50
     */
    @Override
    public int getPassingGrade() {
        return 50;
    }

    /**
     * Returns the current performance status based on average grade.
     * @return "Passing" if averageGrade >= 50, otherwise "Failing"
     */
    @Override
    public String getStatus() {
        return (averageGrade >= 50) ? "Passing" : "Failing";
    }
}
