/**
 * An interface representing a generic stack data structure that allows pushing
 * and popping elements.
 * The stack has a specified capacity, and it supports checking if it's empty or
 * full.
 *
 * @param <E> the type of elements stored in the stack.
 */
public interface Stack<E> {
    /**
     * Returns the current size of the stack.
     *
     * @return the number of elements in the stack.
     */
    int size();

    /**
     * Pushes an element onto the stack.
     *
     * @param item the element to be pushed onto the stack.
     * @throws IllegalStateException if the stack is full.
     */
    void push(E item) throws IllegalStateException;

    /**
     * Pops the top element from the stack.
     *
     * @return the element that was removed from the top of the stack, or null if
     *         the stack is empty.
     */
    E pop();

    /**
     * Tops at the top element of the stack without removing it.
     *
     * @return the top element of the stack, or null if the stack is empty.
     */
    E top();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise.
     */
    boolean isFull();
}
