/**
 * An interface representing an array of long values with various operations.
 *
 * @version 1.0
 */
public interface LongArray {
    /**
     * Finds the index of a specified value in the array.
     *
     * @param searchKey The value to search for.
     * @return The index of the value if found; otherwise, -1.
     */
    int find(long searchKey);

    /**
     * Inserts a value into the array.
     *
     * @param value The value to insert.
     */
    void insert(long value);

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index, or -1 if the index is out of
     *         bounds.
     */
    long getElem(int index);

    /**
     * Deletes an element at the specified index.
     *
     * @param index The index of the element to delete.
     */
    void deleteAtIndex(int index);

    /**
     * Deletes a value from the array.
     *
     * @param value The value to delete.
     * @return true if the value was deleted successfully; otherwise, false.
     */
    boolean delete(long value);

    /**
     * Deletes all occurrences of a value from the array.
     *
     * @param value The value to delete.
     * @return The number of elements deleted.
     */
    int dupDelete(long value);

    /**
     * Inserts a value at the specified index.
     *
     * @param index The index at which to insert the value.
     * @param value The value to insert.
     */
    void insert(int index, long value);

    /**
     * Displays the elements of the array.
     */
    void display();

    /**
     * Initializes the array with random values within the specified range.
     *
     * @param min The minimum value for random generation.
     * @param max The maximum value for random generation.
     */
    void initArray(int min, int max);
}
