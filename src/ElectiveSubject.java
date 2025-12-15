/**
 * Represents an Elective Subject in the system.
 * Elective subjects are optional and can be chosen by the student.
 * Inherits from the abstract Subject class.
 */
public class ElectiveSubject extends Subject {

    // ------------------ FIELDS ------------------
    private final boolean mandatory = false; // Elective subjects are optional

    // ------------------ CONSTRUCTOR ------------------
    /**
     * Initializes a new ElectiveSubject with a name and code.
     * @param name Name of the elective subject (e.g., Music)
     * @param code Unique code for the subject (e.g., E-MUS)
     */
    public ElectiveSubject(String name, String code) {
        super(name, code); // Call base class constructor
    }

    // ------------------ OVERRIDDEN METHODS ------------------

    /**
     * Displays details of the elective subject in a readable format.
     */
    @Override
    public void displaySubjectDetails() {
        System.out.println("Elective Subject: " + getSubjectName() +
                " (" + getSubjectCode() + ")");
    }

    /**
     * Returns the type of this subject.
     * @return "Elective"
     */
    @Override
    public String getSubjectType() {
        return "Elective";
    }

    /**
     * Indicates whether this subject is mandatory.
     * @return false for elective subjects
     */
    @Override
    public boolean isMandatory() {
        return mandatory;
    }
}
