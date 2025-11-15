package com.CT1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 com.CT1.Bag data structure
 */
public class Bag<T> implements Iterable<T> {
    private Node<T> firstItem;
    private int numItems;


    // Constructor to initialize an empty com.CT1.Bag
    public Bag() {
        firstItem = null;
        numItems = 0;
    }

    // Method to check if com.CT1.Bag is empty
    public boolean isEmpty() {
        // Return boolean value based on the number of items
        return numItems == 0;
    }

    // Method to add T type item to bag
    public void add(T item) {

        // Store firstItem to tempNode
        Node<T> tempNode = firstItem;

        // Create a new empty node to be stored as the firstItem
        firstItem = new Node<T>(item);

        // Set the nextItem to be the original firstNode
        firstItem.setNextItem(tempNode);

        // Increment numItems
        numItems += 1;
    }

    //
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = firstItem;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T item = current.getItem();
                current = current.getNextItem();
                return item;
            }
        };
    }

    public Node<T> getFirstItem() {
        return firstItem;
    }
}
