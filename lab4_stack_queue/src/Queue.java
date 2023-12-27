/**
 * A generic queue data structure that allows enqueueing and dequeuing elements.
 * The queue has a specified capacity, and it supports checking if it's empty,
 * finding the first element, and retrieving its size.
 *
 * @param <E> the type of elements stored in the queue.
 */
public interface Queue<E> {
    /**
     * Enqueues an element into the queue.
     *
     * @param e the element to be enqueued.
     * @throws IllegalStateException if the queue is full.
     */
    void enqueue(E e) throws IllegalStateException;

    /**
     * Dequeues and removes the element at the front of the queue.
     *
     * @return the element that was dequeued, or null if the queue is empty.
     */
    E dequeue();

    /**
     * Retrieves the first element in the queue without removing it.
     *
     * @return the first element in the queue, or null if the queue is empty.
     */
    E first();

    /**
     * Gets the current size of the queue.
     *
     * @return the number of elements currently in the queue.
     */
    int size();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();
}
