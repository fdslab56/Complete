import java.util.Scanner;

/**
 * The Main class contains the main method for executing the program.
 *
 * <p>
 * This class provides a menu-driven interface for interacting with the
 * MyLongArray class.
 * </p>
 */
public class Main {
    /**
     * The main method is the entry point of the program.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        MyLongArray longArray = new MyLongArray(10);
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.print("\nMenu:\n" +
                    "1. Find an index\n" +
                    "2. Insert at an index\n" +
                    "3. Delete a value\n" +
                    "4. Insert a value\n" +
                    "5. Display the Array\n" +
                    "6. Get Element\n" +
                    "0. Exit\n" +
                    "Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to find: ");
                    long valueToFind = sc.nextLong();
                    int index = longArray.find(valueToFind);
                    if (index != -1) {
                        System.out.println("Value found at index: " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    longArray.display();
                    break;
                case 2:
                    System.out.print("Enter an index to insert at: ");
                    int insertIndex = sc.nextInt();
                    System.out.print("Enter a value to insert: ");
                    long valueToInsertAtIndex = sc.nextLong();
                    longArray.insert(insertIndex, valueToInsertAtIndex);
                    longArray.display();
                    break;
                case 3:
                    System.out.print("Enter a value to delete: ");
                    long valueToDelete = sc.nextLong();
                    boolean deleted = longArray.delete(valueToDelete);
                    if (deleted) {
                        System.out.println("Value deleted successfully.");
                    } else {
                        System.out.println("Value not found in the Array.");
                    }
                    longArray.display();
                    break;
                case 4:
                    System.out.print("Enter a value to insert: ");
                    long valueToInsert = sc.nextLong();
                    longArray.insert(valueToInsert);
                    longArray.display();
                    break;
                case 5:
                    longArray.display();
                    break;
                case 6:
                    System.out.print("Enter the Index: ");
                    int Index = sc.nextInt();
                    long element = longArray.getElem(Index);
                    if (element != -1) {
                        System.out.println("Element at index " + Index + ": " + element);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}