package com.CT1;

public class Node<T> {
    private T item;
    private Node<T> nextItem;

    // Constructor to initialize empty bag
    public Node(T item) {
        this.item = item;
        this.nextItem = null;
    }

    // Getter and setter methods for item
    public T getItem() {
        return this.item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    // Getter and setter methods of nextItem
    public Node<T> getNextItem() {
        return nextItem;
    }

    public void setNextItem(Node<T> nextItem) {
        this.nextItem = nextItem;
    }
}
