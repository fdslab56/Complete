/**
 * The `Sort` class extends the `MyLongArray` class and provides methods for
 * sorting
 * arrays using three different sorting algorithms: bubble sort, selection sort,
 * and insertion sort.
 * These algorithms operate on arrays of long integers.
 *
 */
public class Sort extends MyLongArray {

    /**
     * Constructs a `Sort` object with the specified size.
     *
     * @param size The size of the array to be sorted.
     */
    public Sort(int size) {
        super(size);
    }

    /**
     * Sorts the array using the bubble sort algorithm.
     * This method iteratively compares adjacent elements in the array and swaps
     * them
     * if they are in the wrong order. The process is repeated until the entire
     * array is sorted.
     */
    public void bubbleSort() {
        for (int i = 0; i < currentIndex - 1; i++) {
            for (int j = 0; j < currentIndex - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    long temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the array using the selection sort algorithm.
     * This method repeatedly selects the minimum element from the unsorted portion
     * of the array and swaps it with the first unsorted element.
     */
    public void selectionSort() {
        for (int i = 0; i < currentIndex - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < currentIndex; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            long temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    /**
     * Sorts the array using the insertion sort algorithm.
     * This method builds the sorted array one element at a time by repeatedly
     * taking elements from the unsorted part and inserting them into their correct
     * position.
     */
    public void insertionSort() {
        for (int i = 1; i < currentIndex; i++) {
            long key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
