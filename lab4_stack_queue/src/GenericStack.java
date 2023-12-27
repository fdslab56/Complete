
/**
 * A generic stack data structure that allows pushing and popping elements.
 * The stack has a specified capacity, and it supports checking if it's empty or
 * full.
 *
 * @param <E> the type of elements stored in the stack.
 */
public class GenericStack<E> implements Stack<E> {
    /**
     * An array to store the elements in the stack.
     */
    private final E[] elements;

    /**
     * Index pointing to the top element of the stack.
     */
    private int top;

    /**
     * Creates a new GenericStack with the specified capacity.
     *
     * @param capacity the maximum number of elements the stack can hold.
     */
    public GenericStack(int capacity) {
        elements = (E[]) new Object[capacity];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param item the element to be pushed onto the stack.
     * @throws IllegalStateException if the stack is full.
     */
    public void push(E item) throws IllegalStateException {
        try {
            if (size() == elements.length) {
                throw new IllegalStateException("Stack is Full");
            }
            top++;
            elements[top] = item;
        } catch (IllegalStateException error) {
            System.err.println("Exception while pushing: " + error.getMessage());

        }

    }

    /**
     * Pops the top element from the stack.
     *
     * @return the element that was removed from the top of the stack.
     */
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E ans = elements[top];
        elements[top] = null;
        top--;
        return ans;
    }

    /**
     * Tops at the top element of the stack without removing it.
     *
     * @return the top element of the stack.
     */
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return elements[top];
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return top == elements.length - 1;
    }

}
