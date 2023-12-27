/**
 * The Student class represents a student, extending the Human class
 * to inherit basic personal information. It includes additional attributes
 * such as roll number, division, semester, and Cumulative Performance Index
 * (CPI).
 * This class provides methods to access and update student-specific
 * information.
 *
 * @version 1.0
 */
public class Student extends Human {

    /** The roll number of the student. */
    private int roll;

    /** The division or class of the student. */
    private String div;

    /** The semester of the student. */
    private int sem;

    /** The Cumulative Performance Index (CPI) of the student. */
    private double cpi;

    /**
     * Constructs a Student object with the specified name, age, gender, roll
     * number,
     * division, semester, and Cumulative Performance Index (CPI).
     *
     * @param name   The name of the student.
     * @param age    The age of the student.
     * @param gender The gender of the student.
     * @param roll   The roll number of the student.
     * @param div    The division or class of the student.
     * @param sem    The semester of the student.
     * @param cpi    The Cumulative Performance Index (CPI) of the student.
     */
    public Student(String name, int age, String gender, int roll, String div, int sem, double cpi) {
        super(name, age, gender);
        this.roll = roll;
        this.div = div;
        this.sem = sem;
        this.cpi = cpi;
    }

    /**
     * Gets the roll number of the student.
     *
     * @return The roll number of the student.
     */
    public int getRoll() {
        return roll;
    }

    /**
     * Gets the division or class of the student.
     *
     * @return The division of the student.
     */
    public String getDiv() {
        return div;
    }

    /**
     * Gets the semester of the student.
     *
     * @return The semester of the student.
     */
    public int getSem() {
        return sem;
    }

    /**
     * Gets the Cumulative Performance Index (CPI) of the student.
     *
     * @return The CPI of the student.
     */
    public double getCpi() {
        return cpi;
    }

    /**
     * Overrides the getInfo method in the Human class to include student-specific
     * information such as roll number, division, semester, and CPI.
     *
     * @return A string containing the student's information.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + "\nRoll No: " + getRoll() + "\nClass: " + getDiv() + "\nSemester: " + getSem()
                + "\nCPI: " + getCpi();
    }
}
