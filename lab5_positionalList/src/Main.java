
/**
 * This is a simple interactive program that demonstrates the usage of a linked positional list
 * for managing a list of integers. Users can perform various operations on the list, such as
 * adding, replacing, and removing elements, as well as checking the list's size and emptiness.
 * The program provides a menu-driven interface for user interaction.
 * <p>
 * The following menu options are available:
 * 1. Add element at the beginning of the list.
 * 2. Add element at the end of the list.
 * 3. Add element before a specific element in the list.
 * 4. Add element after a specific element in the list.
 * 5. Replace an element in the list with another element.
 * 6. Remove the element at the current position.
 * 7. Get the size of the list.
 * 8. Check if the list is empty.
 * 9. Display the current state of the list.
 * 10. Remove the element at the next position in the list.
 * 11. Remove the element at the previous position in the list.
 * 0. Exit the program.
 *</p>
 * This program uses the LinkedPositionalList and Position classes to manage the list of integers.
 * The Position class represents a specific position in the list.
 *
 * @version 1.0
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Position<Integer> currentPosition = null;
        LinkedPositionalList<Integer> obj = new LinkedPositionalList<>();
        Scanner sc = new Scanner(System.in);
        char con = 'y';
        while (con == 'y') {
            System.out.println("Enter the choice: ");
            System.out.println(" 1:Add element at first");
            System.out.println(" 2:Add element at last");
            System.out.println(" 3:Add element before any element");
            System.out.println(" 4:Add element after any element");
            System.out.println(" 5:Replace any element with another element");
            System.out.println(" 6:Remove any element");
            System.out.println(" 7:Size of the list");
            System.out.println(" 8:Check if the list is empty");
            System.out.println(" 9:Display the list");
            System.out.println(" 10:Search for element");
            System.out.println(" 0: Exit");

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            // System.out.println(" ");

            if (ch == 0) {
                System.out.println("Exiting the loop.");
                con = 'n';
                continue;
            }

            switch (ch) {
                case 1: {
                    System.out.print("Enter the element: ");
                    int x1 = sc.nextInt();
                    currentPosition = obj.addFirst(x1);
                    obj.display();
                    break;
                }
                case 2: {
                    System.out.print("Enter the element: ");
                    int x2 = sc.nextInt();
                    currentPosition = obj.addLast(x2);
                    obj.display();
                    break;
                }
                case 3: {
                    System.out.print("Enter the element before which you want to add the new element: ");
                    int x3 = sc.nextInt();
                    System.out.print("Enter the new element: ");
                    int y3 = sc.nextInt();
                    Position<Integer> p3 = obj.getPosition(x3);
                    currentPosition = obj.addBefore(p3, y3);
                    System.out.println(p3);
                    obj.display();
                    break;
                }
                case 4: {
                    System.out.print("Enter the element after which you want to add the new element: ");
                    int x4 = sc.nextInt();
                    System.out.print("Enter the new element: ");
                    int y4 = sc.nextInt();
                    Position<Integer> p4 = obj.getPosition(x4);
                    currentPosition = obj.addAfter(p4, y4);
                    obj.display();
                    break;
                }
                case 5: {
                    System.out.print("Enter the element which you want to replace: ");
                    int x5 = sc.nextInt();
                    System.out.print("Enter the element which you want in that place: ");
                    int y5 = sc.nextInt();
                    Position<Integer> p5 = obj.getPosition(x5);
                    obj.set(p5, y5);
                    obj.display();
                    break;
                }
                case 6: {
                    System.out.println("The element at the current position is");
                    System.out.println(currentPosition.getElement());
                    obj.remove(currentPosition);
                    obj.display();
                    break;
                }
                case 7:
                    System.out.println("The size of the list is: " + obj.size());
                    break;
                case 8:
                    if (obj.isEmpty())
                        System.out.println("The list is Empty");
                    else
                        System.out.println("The list is not Empty");
                    break;
                case 9:
                    System.out.print("The list: ");
                    obj.display();
                    break;
                case 10: {
                    System.out.print("Enter the element to search for: ");
                    int searchElement = sc.nextInt();
                    if (obj.contains(searchElement)) {
                        System.out.println("Element " + searchElement + " found in the list.");
                    } else {
                        System.out.println("Element " + searchElement + " not found in the list.");
                    }
                    break;
                }
                default:
                    System.out.println("Invalid input");
            }
            System.out.println(" ");
        }
        sc.close();
    }
}
