/**
 * An interface representing an array of long values with sorting operations.
 *
 * @version 1.0
 */
public interface SortableLongArray extends LongArray {
    /**
     * Sorts the array using the bubble sort algorithm.
     */
    void bubbleSort();

    /**
     * Sorts the array using the selection sort algorithm.
     */
    void selectionSort();

    /**
     * Sorts the array using the insertion sort algorithm.
     */
    void insertionSort();
}
