package com.studentgrade.model;

/**
 * Represents a Core Subject in the system.
 * Core subjects are mandatory and part of the student's core curriculum.
 * Inherits from the abstract Subject class.
 */
public class CoreSubject extends Subject {

    // ------------------ FIELDS ------------------
    private final boolean mandatory = true; // Core subjects are always mandatory

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new CoreSubject with a name and code.
     * @param name Name of the core subject (e.g., Mathematics)
     * @param code Unique code for the subject (e.g., C-MATH)
     */
    public CoreSubject(String name, String code) {
        super(name, code); // Call base class constructor
    }

    // ------------------ OVERRIDDEN METHODS ------------------

    /**
     * Displays details of the core subject in a readable format.
     */
    @Override
    public void displaySubjectDetails() {
        System.out.println("Core Subject: " + getSubjectName() +
                " (" + getSubjectCode() + ")");
    }

    /**
     * Returns the type of this subject.
     * @return "Core"
     */
    @Override
    public String getSubjectType() {
        return "Core";
    }

    /**
     * Indicates whether this subject is mandatory.
     * @return true for core subjects
     */
    @Override
    public boolean isMandatory() {
        return mandatory;
    }
}
