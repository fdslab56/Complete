/**
 * The Faculty class represents a faculty member, extending the Human class
 * to inherit basic personal information. It includes additional attributes
 * such as salary and specialization. This class provides methods to access
 * and update faculty-specific information.
 *
 * @version 1.0
 */
public class Faculty extends Human {

    /** The salary of the faculty member. */
    private double salary;

    /** The specialization or field of expertise of the faculty member. */
    private String special;

    /**
     * Constructs a Faculty object with the specified name, age, gender,
     * salary, and specialization.
     *
     * @param name    The name of the faculty member.
     * @param age     The age of the faculty member.
     * @param gender  The gender of the faculty member.
     * @param salary  The salary of the faculty member.
     * @param special The specialization or field of expertise of the faculty
     *                member.
     */
    public Faculty(String name, int age, String gender, double salary, String special) {
        super(name, age, gender);
        this.salary = salary;
        this.special = special;
    }

    /**
     * Gets the salary of the faculty member.
     *
     * @return The salary of the faculty member.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the specialization or field of expertise of the faculty member.
     *
     * @return The specialization of the faculty member.
     */
    public String getSpecial() {
        return special;
    }

    /**
     * Overrides the getInfo method in the Human class to include faculty-specific
     * information such as salary and specialization.
     *
     * @return A string containing the faculty member's information.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + "\nSalary: " + getSalary() + "\nSpecialization: " + getSpecial();
    }
}
