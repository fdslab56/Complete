/**
 * A generic queue data structure that allows enqueueing and dequeuing elements.
 * The queue has a specified capacity, and it supports checking if it's empty,
 * finding the first element, and retrieving its size.
 *
 * @param <E> the type of elements stored in the queue.
 */
public class GenericQueue<E> implements Queue<E> {
    /**
     * An array to store the elements in the queue.
     */
    private final E[] elements;

    /**
     * Index representing the front of the queue.
     */
    private int front = 0;

    /**
     * Index representing the rear of the queue.
     */
    private int rear = -1;

    /**
     * The current size of the queue.
     */
    private int size = 0;

    /**
     * Creates a new GenericQueue with the specified capacity.
     *
     * @param capacity the maximum number of elements the queue can hold.
     */
    public GenericQueue(int capacity) {
        elements = (E[]) new Object[capacity];
    }

    /**
     * Enqueues an element into the queue.
     *
     * @param e the element to be enqueued.
     * @throws IllegalStateException if the queue is full.
     */
    public void enqueue(E e) throws IllegalStateException {
        try {
            if (size == elements.length)
                throw new IllegalStateException("Queue is full");
            rear = (rear + 1) % elements.length;
            elements[rear] = e;
            size++;
        } catch (IllegalStateException error) {
            System.err.println("Exception while enquing element " + error.getMessage());
        }
    }

    /**
     * Dequeues and removes the element at the front of the queue.
     *
     * @return the element that was dequeued, or null if the queue is empty.
     */
    public E dequeue() {
        if (isEmpty())
            return null;
        E answer = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return answer;
    }

    /**
     * Retrieves the first element in the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty.
     */
    public E first() {
        if (isEmpty())
            return null;
        return elements[front];
    }

    /**
     * Gets the current size of the queue.
     *
     * @return the number of elements currently in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}