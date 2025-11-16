package com.CT1;

// Node class to be used in Bag class
public class Node<T> {

    // Declare private attributes
    private T item;
    private Node<T> nextItem;

    // Parameterized constructor
    public Node(T item) {
        this.item = item;
        this.nextItem = null;
    }

    // Getter method for item
    public T getItem() {
        return this.item;
    }

    // Getter method for nextItem
    public Node<T> getNextItem() {
        return nextItem;
    }

    // Setter method for nextItem
    public void setNextItem(Node<T> nextItem) {
        this.nextItem = nextItem;
    }
}
