package com.CT1;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main function.");

        Bag<Integer> newBag = new Bag<Integer>();

        newBag.add(4);
        newBag.add(3);
        newBag.add(2);
        newBag.add(1);

        newBag.remove(1);

        for (Integer item : newBag) {
            System.out.println(item);
        }


        System.out.println(newBag.contains(1));
        System.out.println(newBag.getNumItems());

    }
}