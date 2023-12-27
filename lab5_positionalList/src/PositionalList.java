/**
 * The PositionalList interface defines a list that allows the manipulation of
 * elements using positions.
 *
 * @param <E> The type of elements to be stored in the list.
 */
public interface PositionalList<E> {
    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the position of the first element in the list.
     *
     * @return The position of the first element if the list is not empty, or null
     *         if the list is empty.
     */
    Position<E> first();

    /**
     * Returns the position of the last element in the list.
     *
     * @return The position of the last element if the list is not empty, or null if
     *         the list is empty.
     */
    Position<E> last();

    /**
     * Returns the position of the element that comes before the specified position.
     *
     * @param p The position for which the predecessor is sought.
     * @return The position of the element that comes before the provided position.
     * @throws IllegalArgumentException if the provided position is no longer valid.
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the position of the element that comes after the specified position.
     *
     * @param p The position for which the successor is sought.
     * @return The position of the element that comes after the provided position.
     * @throws IllegalArgumentException if the provided position is no longer valid.
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Inserts a new element at the beginning of the list.
     *
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     */
    Position<E> addFirst(E e);

    /**
     * Inserts a new element at the end of the list.
     *
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     */
    Position<E> addLast(E e);

    /**
     * Inserts a new element before the specified position.
     *
     * @param p The position before which the new element will be added.
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     * @throws IllegalArgumentException if the operation cannot be performed.
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts a new element after the specified position.
     *
     * @param p The position after which the new element will be added.
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     * @throws IllegalArgumentException if the operation cannot be performed.
     */
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Replaces the element at the specified position with the given element.
     *
     * @param p The position at which the element is to be replaced.
     * @param e The new element to set at the position.
     * @return The original element that was replaced.
     * @throws IllegalArgumentException if the provided position is no longer valid.
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element at the specified position from the list.
     *
     * @param p The position of the element to be removed.
     * @return The element that was removed from the list.
     * @throws IllegalArgumentException if the provided position is no longer valid.
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}
