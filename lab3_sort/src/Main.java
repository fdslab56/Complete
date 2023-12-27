import java.util.*;

/**
 * The Main class contains the main method for executing the program.
 * 
 * <p>
 * This class provides a menu-driven interface for interacting with the
 * Mysorter class.
 * </p>
 */

public class Main {
    public static void main(String[] args) {
        // Mysorter sorter = new Mysorter(10);
        Sort sorter = new Sort(10);

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.print("\nMenu:\n" +
                    "1. Find an index\n" +
                    "2. Delete a value\n" +
                    "3. Insert at an index\n" +
                    "4. Delete at an index\n" +
                    "5. Bubble Sort\n" +
                    "6. Selection Sort\n" +
                    "7. Insertion Sort\n" +
                    "8. Create a Random Array\n" +
                    "9. Display the Array\n" +
                    "10. Get Element\n" +
                    "0. Exit\n" +
                    "Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a value to find: ");
                    long valueToFind = sc.nextLong();
                    int index = sorter.find(valueToFind);
                    if (index != -1) {
                        System.out.println("Value found at index: " + index);
                    } else {
                        System.out.println("Value not found.");
                    }
                    sorter.display();
                    break;
                case 2:
                    System.out.print("Enter a value to delete: ");
                    long valueToDelete = sc.nextLong();
                    boolean deleted = sorter.delete(valueToDelete);
                    if (deleted) {
                        System.out.println("Value deleted successfully.");
                    } else {
                        System.out.println("Value not found in the Array.");
                    }
                    sorter.display();
                    break;
                case 3:
                    System.out.print("Enter an index to insert at: ");
                    int insertIndex = sc.nextInt();
                    System.out.print("Enter a value to insert: ");
                    long valueToInsertAtIndex = sc.nextLong();
                    sorter.insert(insertIndex, valueToInsertAtIndex);
                    sorter.display();
                    break;
                case 4:
                    System.out.print("Enter an index to delete: ");
                    int deleteIndex = sc.nextInt();
                    sorter.deleteAtIndex(deleteIndex);
                    sorter.display();
                    break;
                case 5:
                    System.out.println("Random Array before Bubble Sort:");
                    sorter.display();
                    sorter.bubbleSort();
                    System.out.println("After Bubble Sort:");
                    sorter.display();
                    break;
                case 6:
                    System.out.println("Random Array before Selection Sort:");
                    sorter.display();
                    sorter.selectionSort();
                    System.out.println("After Selection Sort:");
                    sorter.display();
                    break;
                case 7:
                    System.out.println("Random Array before Insertion Sort:");
                    sorter.display();
                    sorter.insertionSort();
                    System.out.println("After Insertion Sort:");
                    sorter.display();
                    break;
                case 8:
                    sorter.initArray(1, 100);
                    System.out.println("Created Random Array");
                    sorter.display();
                    break;
                case 9:
                    sorter.display();
                    break;
                case 10:
                    System.out.print("Enter the Index: ");
                    int Index = sc.nextInt();
                    long element = sorter.getElem(Index);
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