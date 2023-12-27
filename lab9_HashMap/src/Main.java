import java.util.*;

/**
 * The Main class allows the user to interactively choose and use different
 * implementations
 * of the HashMap data structure (ChainHashMap or ProbeHashMap).
 * It provides a menu-driven interface for performing basic operations like put,
 * get, remove,
 * and display all entries in the selected HashMap implementation.
 */
public class Main {

    /**
     * The main method serves as the entry point for the program.
     * It prompts the user to choose between ChainHashMap and ProbeHashMap,
     * and then provides a menu-driven interface for interacting with the selected
     * HashMap.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose HashMap implementation:");
        System.out.println("1. ChainHashMap");
        System.out.println("2. ProbeHashMap");
        System.out.print("Enter your choice (1 or 2): ");
        int mapTypeChoice = scanner.nextInt();

        AbstractHashMap<String, Integer> hashMap;

        if (mapTypeChoice == 1) {
            hashMap = new ChainHashMap<>();
        } else if (mapTypeChoice == 2) {
            hashMap = new ProbeHashMap<>();
        } else {
            System.out.println("Invalid choice");
            scanner.close();
            return;
        }

        int choice;

        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Put");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Display All Entries");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Put operation
                    System.out.print("Enter key: ");
                    String key = scanner.next();
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    hashMap.put(key, value);
                    System.out.println("Entry added successfully.");
                    break;
                case 2:
                    // Get operation
                    System.out.print("Enter key: ");
                    key = scanner.next();
                    Integer result = hashMap.get(key);
                    if (result != null) {
                        System.out.println("Value for key '" + key + "': " + result);
                    } else {
                        System.out.println("Key not found.");
                    }
                    break;
                case 3:
                    // Remove operation
                    System.out.print("Enter key: ");
                    key = scanner.next();
                    Integer removedValue = hashMap.remove(key);
                    if (removedValue != null) {
                        System.out.println("Removed entry with key '" + key + "' and value " + removedValue);
                    } else {
                        System.out.println("Key not found. No entry removed.");
                    }
                    break;
                case 4:
                    // Display all entries
                    System.out.println("All Entries:");
                    for (Entry<String, Integer> entry : hashMap.entrySet()) {
                        System.out.println("Key: " + entry.getKey() + ", Value:" + entry.getValue());
                    }
                    break;
                case 0:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
