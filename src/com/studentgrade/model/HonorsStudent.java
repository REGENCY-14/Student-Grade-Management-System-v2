package com.studentgrade.model;

/**
 * Represents an Honors Student in the system.
 * Inherits from the base Student class.
 * Honors students have a higher passing grade threshold of 60.
 */
public class HonorsStudent extends Student {

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new HonorsStudent with the given information.
     * @param id Unique student ID
     * @param name Student's name
     * @param age Student's age
     * @param email Student's email
     * @param phone Student's phone number
     */
    public HonorsStudent(int id, String name, int age, String email, String phone) {
        super(id, name, age, email, phone); // Call base class constructor
    }

    // ------------------ OVERRIDDEN METHODS ------------------

    /**
     * Returns the type of student.
     * @return "Honors"
     */
    @Override
    public String getType() {
        return "Honors";
    }

    /**
     * Returns the passing grade threshold for Honors students.
     * @return 60
     */
    @Override
    public int getPassingGrade() {
        return 60;
    }

    /**
     * Returns the current performance status based on average grade.
     * @return "Passing" if averageGrade >= 60, otherwise "Failing"
     */
    @Override
    public String getStatus() {
        return (averageGrade >= 60) ? "Passing" : "Failing";
    }
}
