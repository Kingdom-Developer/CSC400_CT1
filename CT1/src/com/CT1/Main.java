package com.CT1;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main function.");

        Bag<Integer> newBag = new Bag<Integer>();

        newBag.add(5);

        System.out.println(newBag.getFirstItem().getItem());
    }
}