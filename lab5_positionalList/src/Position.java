/**
 * The Position interface represents a position within a data structure,
 * allowing access to an element.
 * Implementing classes must provide a way to retrieve the element stored at
 * this position.
 *
 * @param <E> The type of element stored at the position.
 */
public interface Position<E> {
    /**
     * Retrieves the element stored at this position.
     *
     * @return The element stored at this position.
     * @throws IllegalStateException if the position is no longer valid or the
     *                               element cannot be retrieved.
     */
    E getElement() throws IllegalStateException;
}
