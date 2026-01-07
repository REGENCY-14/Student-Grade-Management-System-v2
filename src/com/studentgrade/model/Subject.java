package com.studentgrade.model;

/**
 * Abstract base class representing a Subject.
 * Defines the common properties and behaviors for all subjects.
 * Subclasses like CoreSubject and ElectiveSubject will implement specific behavior.
 */
public abstract class Subject {

    // ------------------ FIELDS ------------------
    private final String subjectName; // Name of the subject (e.g., Mathematics, Music)
    private final String subjectCode; // Unique code for the subject (e.g., C-MATH, E-ART)

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new Subject with a name and code.
     * @param subjectName Name of the subject
     * @param subjectCode Unique code for the subject
     */
    public Subject(String subjectName, String subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    // ------------------ GETTERS ------------------
    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    // ------------------ ABSTRACT METHODS ------------------
    /**
     * Display the details of the subject.
     * Must be implemented by subclasses.
     */
    public abstract void displaySubjectDetails();

    /**
     * Returns the type of subject (Core or Elective).
     * Must be implemented by subclasses.
     * @return Subject type as String
     */
    public abstract String getSubjectType();

    /**
     * Determines if the subject is mandatory.
     * Must be implemented by subclasses.
     * @return true if mandatory, false if optional
     */
    public abstract boolean isMandatory();
}
