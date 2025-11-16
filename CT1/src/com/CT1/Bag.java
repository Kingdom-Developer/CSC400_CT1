package com.CT1;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Bag class that implements Iterable interface
public class Bag<T> implements Iterable<T> {
    // Declare private attributes
    private Node<T> head;
    private int numItems;

    // Getter method for numItems
    public int getNumItems() {
        return numItems;
    }

    // Getter method for head
    public Node<T> getHead() {
        return head;
    }

    // Constructor to initialize an empty Bag
    public Bag() {
        head = null;
        numItems = 0;
    }

    // Method to check if Bag is empty
    public boolean isEmpty() {
        // Return boolean value based on the number of items
        return numItems == 0;
    }

    // Method to add item to Bag
    public void add(T item) {
        // Store head to tempNode
        Node<T> tempNode = head;

        // Create a new empty node to be stored as the head
        head = new Node<T>(item);

        // Set the nextItem to be the original firstNode
        head.setNextItem(tempNode);

        // Increment numItems
        numItems += 1;
    }

    // Method to remove item from Bag
    public void remove(T item) {
        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Check if bag is empty
        if (isEmpty()) {
            return;
        }

        // Handle situation if the head is the item to be removed
        if (head.getItem().equals(item)) {
            head = head.getNextItem();
            numItems -= 1;
            return;
        }

        // Traverse through the linked list
        while (currentItem.getNextItem() != null) {

            // Check if item matches currentItem's next item
            if (currentItem.getNextItem().getItem().equals(item)) {

                // Remove the currentItem's next item
                currentItem.setNextItem(currentItem.getNextItem().getNextItem());

                // Decrement the numItems and return
                numItems -= 1;
                return;
            }

            // If no item was removed, continue through the linked list
            currentItem = currentItem.getNextItem();
        }
    }

    public boolean contains(T item) {
        // Create temporary node and set it equal to the head
        Node<T> currentItem = head;

        // Traverse through list to check if it contains item
        while (currentItem != null) {

            // Check if currentItem equals the item being searched for
            if (currentItem.getItem().equals(item)) {
                return true;
            }

            // If no match, continue through the linked list
            currentItem = currentItem.getNextItem();
        }

        // Return false to indicate no match in the linked list
        return false;
    }


    // Override iterator method
    @Override
    public Iterator<T> iterator() {
        // Return new BagIterator starting at the head
        return new BagIterator(head);
    }

    // Inner class to create BagIterator
    private class BagIterator implements Iterator<T> {
        // Declare private attribute
        private Node<T> currentItem;

        // Parameterized constructor
        public BagIterator(Node<T> head) {
            // Set currentItem to head of linked list
            currentItem = head;
        }

        @Override
        public boolean hasNext() {
            // Check if currentItem is the tail
            return currentItem != null;
        }

        @Override
        public T next() {
            // Check if there is next item
            if (!hasNext()) {
                // If no next item, throw exception
                throw new NoSuchElementException();
            }

            // Store current item to temporary variable
            T returnItem = currentItem.getItem();

            // Set currentItem to the next item of the linked list
            currentItem = currentItem.getNextItem();

            // Return the item that was stored in temporary variable
            return returnItem;
        }
    }
}