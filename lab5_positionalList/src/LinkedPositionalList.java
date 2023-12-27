/**
 * A generic linked list implementation of the PositionalList interface.
 * Allows the manipulation of elements within the list using positions.
 *
 * @param <E> The type of elements to be stored in the list.
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
    /**
     * Inner class representing a Node in the linked list.
     *
     * @param <E> The type of element stored in the Node.
     */
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        /**
         * Constructs a Node with the given element, previous, and next nodes.
         *
         * @param e The element to store in the Node.
         * @param p The previous Node in the list.
         * @param n The next Node in the list.
         */
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        /**
         * Returns the element stored in this Node.
         *
         * @return The element stored in the Node.
         * @throws IllegalStateException if the position is no longer valid.
         */
        public E getElement() {
            try {
                if (next == null)
                    throw new IllegalStateException("Position no longer valid");
                return element;
            } catch (IllegalStateException e) {
                e.printStackTrace();
                return null;

            }
        }

        /**
         * Returns the previous Node in the list.
         *
         * @return The previous Node.
         */
        public Node<E> getPrev() {
            return prev;
        }

        /**
         * Returns the next Node in the list.
         *
         * @return The next Node.
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the element of this Node.
         *
         * @param e The element to set in the Node.
         */
        public void setElement(E e) {
            element = e;
        }

        /**
         * Sets the previous Node of this Node.
         *
         * @param p The previous Node to set.
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /**
         * Sets the next Node of this Node.
         *
         * @param n The next Node to set.
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private final Node<E> header;
    private final Node<E> trailer;
    public int size = 0;

    /**
     * Constructs an empty LinkedPositionalList with a header and a trailer.
     */
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /**
     * Validates the provided position, ensuring it is of the correct type and still
     * within the list.
     * If the position is invalid, it throws an IllegalArgumentException.
     *
     * @param p The position to be validated.
     * @return The validated Node representing the position.
     * @throws IllegalArgumentException if the position is not of the expected type
     *                                  or is no longer in the list.
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        try {
            if (!(p instanceof Node))
                throw new IllegalArgumentException("Invalid Node");
            Node<E> node = (Node<E>) p;
            if (node.getNext() == null)
                throw new IllegalArgumentException("Position is no longer in the list");
            return node;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Inserts a new element between two existing nodes, prev and next, in the list.
     * The new node contains the given element.
     *
     * @param e    The element to be added to the list.
     * @param prev The previous Node in the list where the new element will be
     *             inserted after.
     * @param next The next Node in the list where the new element will be inserted
     *             before.
     * @return The newly created position representing the added element.
     */
    private Position<E> addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newest = new Node<>(e, prev, next);
        prev.setNext(newest);
        next.setPrev(newest);
        size++;
        return newest;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the position of the first element in the list.
     *
     * @return The position of the first element if the list is not empty, or null
     *         if the list is empty.
     */
    public Position<E> first() {
        if (size > 0)
            return header.next;
        return null;
    }

    /**
     * Returns the position of the last element in the list.
     *
     * @return The position of the last element if the list is not empty, or null if
     *         the list is empty.
     */
    public Position<E> last() {
        if (size > 0)
            return trailer.prev;
        return null;
    }

    /**
     * Returns the position of the element that comes before the given position.
     *
     * @param p The position for which the predecessor is sought.
     * @return The position of the element that comes before the given position.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return (Position<E>) n.getPrev();
    }

    /**
     * Returns the position of the element that comes after the given position.
     *
     * @param p The position for which the successor is sought.
     * @return The position of the element that comes after the given position.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return (Position<E>) n.getNext();
    }

    /**
     * Inserts a new element at the beginning of the list.
     *
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     */
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.next);
    }

    /**
     * Inserts a new element at the end of the list.
     *
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     */
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.prev, trailer);
    }

    /**
     * Inserts a new element after the specified position.
     *
     * @param p The position after which the new element will be added.
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return addBetween(e, n, n.next);
    }

    /**
     * Inserts a new element before the specified position.
     *
     * @param p The position before which the new element will be added.
     * @param e The element to be added to the list.
     * @return The newly created position representing the added element.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> n = validate(p);
        return addBetween(e, n.prev, n);
    }

    /**
     * Replaces the element at the specified position with the given element.
     *
     * @param p The position at which the element is to be replaced.
     * @param e The new element to set at the position.
     * @return The original element that was replaced.
     * @throws IllegalStateException if the provided position is no longer valid.
     */
    public E set(Position<E> p, E e) throws IllegalStateException {
        Node<E> n = validate(p);
        E answer = n.getElement();
        n.setElement(e);
        return answer;
    }

    /**
     * Removes the element at the specified position from the list.
     *
     * @param p The position of the element to be removed.
     * @return The element that was removed from the list.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        E answer = node.getElement();
        size--;
        node.setNext(null);
        node.setPrev(null);
        return answer;
    }

    /**
     * Retrieves the position of the first occurrence of a specific element in the
     * list.
     *
     * @param e The element to search for in the list.
     * @return The position of the first occurrence of the element, or null if not
     *         found.
     */
    public Position<E> getPosition(E e) {
        Position<E> pos = first();
        while (pos.getElement() != e) {
            pos = after(pos);
        }
        return pos;
    }

    /**
     * Displays the elements in the list, from the first element to the last
     * element.
     */
    public void display() {
        Node<E> currNode = header.next;
        System.out.print("Head<->");
        while (currNode != trailer) {
            System.out.print(currNode.getElement() + "<->");
            currNode = currNode.next;
        }
        System.out.println("Tail");
    }

    /**
     * Checks if the specified element is found in Positional List.
     *
     * @param element The element to check for existence in the list.
     * @return true if the element is found, false otherwise.
     */
    public boolean contains(E element) {
        try {
            Position<E> currentPosition = first();
            while (currentPosition != null) {
                if (currentPosition.getElement().equals(element)) {
                    return true;
                }
                currentPosition = after(currentPosition);
            }
            return false;
        } catch (Exception error) {
            return false;
        }
    }

    /**
     * Retrieves the position that follows the given position in the list.
     *
     * @param p The position for which the successor is sought.
     * @return The position of the element that comes after the provided position.
     * @throws IllegalArgumentException if the provided position is invalid.
     */
    public Position<E> getnext(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        node = node.next;
        return node;
    }
}
