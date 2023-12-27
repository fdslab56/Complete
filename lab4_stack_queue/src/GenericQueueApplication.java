import java.util.Scanner;

/**
 * An application for the GenericQueue class, allowing the user to interact with
 * a queue.
 */
public class GenericQueueApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Define the limit for the queue: ");
        int capacity = sc.nextInt();
        GenericQueue<Integer> queue = new GenericQueue<>(capacity);
        int select;
        do {
            System.out.print(
                    """
                            Menu:
                            1. Enqueue Element
                            2. Dequeue Element
                            3. First Element
                            4. Check if Empty
                            5. Size of Queue
                            0. Exit Program
                            Enter Sr. No. of Operation:\s""");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.print("Please input the element you wish to enqueue: ");
                    int temp = sc.nextInt();
                    queue.enqueue(temp);
                    break;

                case 2:
                    System.out.println("The dequeued element is: " + queue.dequeue());
                    break;

                case 3:
                    System.out.println("The element at the front is: " + queue.first());
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("The Queue is Empty");
                    } else {
                        System.out.println("The Queue is not Empty");
                    }
                    break;

                case 5:
                    System.out.println("Size of Queue is: " + queue.size());
                    break;
                case 0:
                    System.out.println("Exited program successfully");
                    break;

                default:
                    throw new IllegalArgumentException("Invalid Option");
            }
        } while (select != 0);
        sc.close();
    }
}
