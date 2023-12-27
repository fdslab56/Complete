import java.util.*;

/**
 * The Main class serves as the entry point for the program and contains the
 * main method
 * for creating instances of Student and Faculty, as well as updating their
 * information.
 * It demonstrates the use of the Human, Student, and Faculty classes.
 *
 * @version 1.0
 */
public class Main {

    /**
     * The main method creates instances of Student and Faculty, displays their
     * initial
     * information, and then allows the user to input new information to update the
     * objects.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create initial instances of Student and Faculty
        Student st = new Student("Student1", 19, "Male", 99, "IT", 9, 9.99);
        Faculty fa = new Faculty("Dr. M. Shirole", 45, "Male", 2000000.0, "Information Technology");

        // Display initial information
        System.out.println("Initial Student Info:" + st.getInfo());
        System.out.println("\nInitial Faculty Info:" + fa.getInfo());

        // Allow user input to update information
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter new Name and CPI of student:");
        String newName = sc.next();
        double newCpi = sc.nextDouble();

        System.out.println("Enter Updated Faculty salary:");
        double newSalary = sc.nextDouble();

        // Update instances with user input
        st = new Student(newName, st.getAge(), st.getGender(), st.getRoll(), st.getDiv(), st.getSem(), newCpi);
        fa = new Faculty(fa.getName(), fa.getAge(), fa.getGender(), newSalary, fa.getSpecial());

        // Display updated information
        System.out.println("\nUpdated Student Info:" + st.getInfo());
        System.out.println("\nUpdated Faculty Info:" + fa.getInfo());
        sc.close();
    }
}
