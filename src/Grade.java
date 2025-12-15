import java.time.LocalDate;

/**
 * Represents a Grade for a student in a specific subject.
 * Each grade has a unique ID, numeric value, and date.
 */
public class Grade {

    // ------------------ STATIC FIELDS ------------------
    private static int gradeCounter = 5000; // Counter to generate unique grade IDs

    // ------------------ INSTANCE FIELDS ------------------
    private int gradeId;      // Unique grade ID
    private int studentId;    // ID of the student who received this grade
    private Subject subject;  // Subject associated with the grade
    private double grade;     // Numeric grade (0-100)
    private LocalDate date;   // Date when the grade was recorded

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new Grade object for a student and subject.
     * Automatically assigns a unique grade ID and sets the date to today.
     * @param studentId ID of the student
     * @param subject Subject for which the grade is recorded
     * @param grade Numeric grade value (0-100)
     */
    public Grade(int studentId, Subject subject, double grade) {
        this.gradeId = gradeCounter++; // Assign unique grade ID
        this.studentId = studentId;
        this.subject = subject;
        this.grade = grade;
        this.date = LocalDate.now(); // Set current date
    }

    // ------------------ GETTERS ------------------
    public int getGradeId() { return gradeId; }

    public int getStudentId() { return studentId; }

    public Subject getSubject() { return subject; }

    public double getGrade() { return grade; }

    public LocalDate getDate() { return date; }

    // ------------------ HELPER METHODS ------------------
    /**
     * Converts numeric grade to letter grade.
     * @return Letter grade as a String
     */
    public String getLetterGrade() {
        if (grade >= 80) return "A";
        if (grade >= 70) return "B";
        if (grade >= 60) return "C";
        if (grade >= 50) return "D";
        return "F";
    }

    /**
     * Displays all grade details in a readable format.
     */
    public void displayGradeDetails() {
        System.out.println("Grade ID: " + gradeId);
        System.out.println("Student ID: " + studentId);
        System.out.println("Subject: " + subject.getSubjectName());
        System.out.println("Numeric Grade: " + grade);
        System.out.println("Letter Grade: " + getLetterGrade());
        System.out.println("Date: " + date);
    }
}
