package se.hig.aod.lab0;

public class LinkedList<T> implements PrintableList<T> {
    
    private class ListNode<T> {
        ListNode<T> next;
        T data;

        ListNode(T data, ListNode<T> next) {
            this.next = next;
            this.data = data;
        }

    }

    private ListNode<T> head;
    //maybe needed
    //Node<T> tail;
    int numOfElement;

    public LinkedList() {
        head = null;
        //tail = null;
        numOfElement = 0;
    }

    public boolean isEmpty() {
        // Implementation here
        return head == null;
    }

    public void clear() {
        // Implementation here
        head = null;
        numOfElement = 0;
    }


    public T getFirst() throws ListEmptyException {
        // Implementation here
        if (isEmpty()) {
            throw new ListEmptyException("List is empty");
        }

        return head.data; // Placeholder
    }

    public void insertLast(T item) {
        // Implementation here
        ListNode<T> newNode = new ListNode<>(item, null);
        if (isEmpty()) {
            head = newNode;
            numOfElement++;
        } else {
            ListNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            numOfElement++;
        }
    }

    public T removeLast() throws ListEmptyException {
        // Implementation here
        if(isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
        ListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T temp = current.data;
        current.next = null;
        return temp; // Placeholder
    }

    public int numberOfElements() {
        // Implementation here
        return numOfElement;
    }

    public void insertFirst(T item) {
        // Implementation here
        ListNode<T> newNode = new ListNode<>(item, head);
        head = newNode;
        numOfElement++;
    }

    public T removeFirst() throws ListEmptyException {
        // Implementation here
        return head.data; // Placeholder
    }

    public T getLast() throws ListEmptyException {
        // Implementation here
        
        if(isEmpty()) {
            throw new ListEmptyException("List is empty");
        }
        ListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        T temp = current.next.data;
        return temp; // Placeholder
    }
    
    public String toStringRecursive() {
        // Implementation here
        T current = head.data;
        String arryString[] = new String[numOfElement];
        String makeItString = current.toString();
        arryString[numOfElement] = makeItString;
        head = head.next;
        toStringRecursive();
        return arryString[numOfElement]; // Placeholder
    }

    public String toStringReverseRecursive() {
        // Implementation here
        return ""; // Placeholder
    }
    // Other methods...
}
