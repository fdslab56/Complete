/**
 * The Human class represents a basic human entity with attributes such as name,
 * age, and gender.
 * This class provides methods to access and retrieve information about a human
 * entity.
 *
 * @version 1.0
 */
public class Human {

    /** The name of the human entity. */
    private String name;

    /** The age of the human entity. */
    private int age;

    /** The gender of the human entity. */
    private String gender;

    /**
     * Constructs a Human object with the specified name, age, and gender.
     *
     * @param name   The name of the human entity.
     * @param age    The age of the human entity.
     * @param gender The gender of the human entity.
     */
    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * Gets the age of the human entity.
     *
     * @return The age of the human entity.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the name of the human entity.
     *
     * @return The name of the human entity.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the gender of the human entity.
     *
     * @return The gender of the human entity.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Generates and returns a formatted string containing information about the
     * human entity.
     *
     * @return A string containing the human entity's information.
     */
    public String getInfo() {
        return "\nName:" + getName() + "\nAge: " + getAge() + "\nGender: " + getGender();
    }
}
