package se.hig.aod.lab0;

/**
 * A singly linked list implementation that supports basic list operations such as
 * inserting, removing, and retrieving elements from both the beginning and the end.
 *
 * @author Muqtada AlDebes
 * @param <T> The type of elements stored in the list.
 */
public class LinkedList<T> implements PrintableList<T> {

    /**
     * Internal node class used to represent individual elements in the linked list.
     *
     * @param <T> The type of data stored in the node.
     */
    private class ListNode<T> {
        ListNode<T> next;
        T data;

        /**
         * Creates a new ListNode with given data and reference to the next node.
         *
         * @param data The data stored in this node.
         * @param next Reference to the next node.
         */
        ListNode(T data, ListNode<T> next) {
            this.next = next;
            this.data = data;
        }
    }

    private ListNode<T> head;
    int numOfElement;
    String arrResult = "";

    /**
     * Creates an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        numOfElement = 0;
    }

    /**
     * Checks whether the list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Removes all elements from the list.
     * The list will become empty after calling this method.
     */
    public void clear() {
        head = null;
        numOfElement = 0;
    }

    /**
     * Retrieves (but does not remove) the first element in the list.
     *
     * @return The first element.
     * @throws ListEmptyException If the list is empty.
     */
    public T getFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
        return head.data;
    }

    /**
     * Inserts a new element at the end of the list.
     *
     * @param item The element to insert.
     */
    public void insertLast(T item) {
        ListNode<T> newNode = new ListNode<>(item, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        numOfElement++;
    }

    /**
     * Removes the last element from the list.
     *
     * @return The removed element.
     * @throws ListEmptyException If the list is empty.
     */
    public T removeLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        // If only one element
        if (head.next == null) {
            T temp = head.data;
            head = null;
            numOfElement--;
            return temp;
        }

        ListNode<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        T temp = current.next.data;
        current.next = null;
        numOfElement--;
        return temp;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return Number of elements.
     */
    public int numberOfElements() {
        return numOfElement;
    }

    /**
     * Inserts a new element at the beginning of the list.
     *
     * @param item The element to insert.
     */
    public void insertFirst(T item) {
        ListNode<T> newNode = new ListNode<>(item, head);
        head = newNode;
        numOfElement++;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws ListEmptyException If the list is empty.
     */
    public T removeFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        T temp = head.data;
        head = head.next;
        numOfElement--;
        return temp;
    }

    /**
     * Retrieves the last element in the list (without removing it).
     *
     * @return The last element.
     * @throws ListEmptyException If the list is empty.
     */
    public T getLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        ListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Converts the list to a string representation using recursion.
     *
     * @return A string containing all elements in forward order.
     */
    public String toStringRecursive() {
        arrResult = "[" + helpFunctionForRecursive(head) + "]";
        
        // Formatting output
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < arrResult.length(); i++) {
            char c = arrResult.charAt(i);
            if (c != '[' && c != ']' &&
                c != arrResult.charAt(0) && c != arrResult.charAt(arrResult.length() - 2)) {
                temp.append(c).append(", ");
            } else {
                temp.append(c);
            }
        }
        return temp.toString();
    }

    /**
     * Converts the list to a string representation in reverse order using recursion.
     *
     * @return A string containing all elements in reverse order.
     */
    public String toStringReverseRecursive() {
        arrResult = "[" + helpFunctionForReverseRecursive(head) + "]";

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < arrResult.length(); i++) {
            char c = arrResult.charAt(i);
            if (c != '[' && c != ']' &&
                c != arrResult.charAt(0) && c != arrResult.charAt(arrResult.length() - 2)) {
                temp.append(c).append(", ");
            } else {
                temp.append(c);
            }
        }
        return temp.toString();
    }

    /**
     * Helper method for recursive forward traversal.
     *
     * @param node The current node.
     * @return A string representation of the list from this node onward.
     */
    private String helpFunctionForRecursive(ListNode<T> node) {
        if (node == null)
            return "";
        return node.data.toString() + helpFunctionForRecursive(node.next);
    }

    /**
     * Helper method for recursive reverse traversal.
     *
     * @param node The current node.
     * @return A string representation of the list in reverse from this node backward.
     */
    private String helpFunctionForReverseRecursive(ListNode<T> node) {
        if (node == null)
            return "";
        return helpFunctionForReverseRecursive(node.next) + node.data.toString();
    }
}
