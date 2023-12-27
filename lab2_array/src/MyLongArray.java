/**
 * The MyLongArray class represents an array of long values with various
 * operations.
 *
 * <p>
 * This class provides methods for finding elements, inserting and deleting
 * elements,
 * sorting the array, and displaying the array.
 * </p>
 *
 * @version 1.0
 */
public class MyLongArray {
    private long[] a;
    private int currentIndex;

    /**
     * Constructs a MyLongArray object with the specified size.
     *
     * @param size The size of the array.
     */
    public MyLongArray(int size) {
        a = new long[size];
        currentIndex = 0;
    }

    /**
     * Finds the index of a specified value in the array.
     *
     * @param searchKey The value to search for.
     * @return The index of the value if found; otherwise, -1.
     */
    public int find(long searchKey) {
        for (int i = 0; i < currentIndex; i++) {
            if (a[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Inserts a value into the array.
     *
     * @param value The value to insert.
     */
    public void insert(long value) {
        if (currentIndex < a.length) {
            a[currentIndex] = value;
            currentIndex++;
        } else {
            System.out.println("Array is full, cannot insert.");
        }
    }

    /**
     * Gets the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index, or -1 if the index is out of
     *         bounds.
     */
    public long getElem(int index) {
        if (index >= 0 && index < currentIndex) {
            return a[index];
        } else {
            return -1;
        }
    }

    /**
     * Deletes a value from the array.
     *
     * @param value The value to delete.
     * @return true if the value was deleted successfully; otherwise, false.
     */
    public boolean delete(long value) {
        int index = find(value);
        if (index != -1) {
            for (int i = index; i < currentIndex - 1; i++) {
                a[i] = a[i + 1];
            }
            currentIndex--;
            return true;
        }
        return false;
    }

    /**
     * Deletes all occurrences of a value from the array.
     *
     * @param value The value to delete.
     * @return The number of elements deleted.
     */
    public int dupDelete(long value) {
        int count = 0;
        boolean deleted;
        do {
            deleted = delete(value);
            if (deleted) {
                count++;
            }
        } while (deleted);
        return count;
    }

    /**
     * Inserts a value at the specified index.
     *
     * @param index The index at which to insert the value.
     * @param value The value to insert.
     */
    public void insert(int index, long value) {
        if (currentIndex < a.length && index >= 0 && index <= currentIndex) {
            for (int i = currentIndex; i > index; i--) {
                a[i] = a[i - 1];
            }
            a[index] = value;
            currentIndex++;
        } else {
            System.out.println("Invalid index or Array is full, cannot insert.");
        }
    }

    /**
     * Displays the elements of the array.
     */
    public void display() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}