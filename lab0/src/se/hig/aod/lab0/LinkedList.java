package se.hig.aod.lab0;
import java.lang.reflect.Array;

import org.w3c.dom.NodeList;

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
    String arrResult = "";
    //private ListNode<T> prev;

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
        T temp = current.data;
        return temp; // Placeholder
    }
    
    public String toStringRecursive() {
        // Implementation here
        arrResult = "[" + helpFunctionForRecursive(head) + "]";
        char firstNum = arrResult.charAt(0);
        char lastNum = arrResult.charAt(arrResult.length() - 2);

        int size = arrResult.length();
        String temp = "";
        for(int x = 0; x < size; x++) {
            if(arrResult.charAt(x) != '[' && arrResult.charAt(x) != ']' &&
            arrResult.charAt(x) != firstNum && arrResult.charAt(x) != lastNum)
                temp = temp + arrResult.charAt(x) +  ", ";
            else
                temp = temp + arrResult.charAt(x);
        }
        return temp;
    }

    public String toStringReverseRecursive() {
        // Implementation here
        arrResult = "[" + helpFunctionForReverseRecursive(head) + "]";
        char firstNum = arrResult.charAt(0);
        char lastNum = arrResult.charAt(arrResult.length() - 2);
        int size = arrResult.length();
        String temp = "";
        for(int x = 0; x < size; x++) {
            if(arrResult.charAt(x) != '[' && arrResult.charAt(x) != ']' &&
            arrResult.charAt(x) != firstNum && arrResult.charAt(x) != lastNum)
                temp = temp + arrResult.charAt(x) +  ", ";
            else
                temp = temp + arrResult.charAt(x);
        }
        return temp;
    }
    // Other methods...

    private String helpFunctionForReverseRecursive(ListNode<T> node) {
        if (node == null) 
            return "";
        else 
            return helpFunctionForReverseRecursive(node.next) + node.data.toString();
    }   

    private String helpFunctionForRecursive(ListNode<T> node) {
        if (node == null) 
            return "";
        else 
            return node.data.toString() + helpFunctionForRecursive(node.next);
    }
}


 