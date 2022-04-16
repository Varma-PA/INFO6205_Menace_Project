package com.northeastern.info6205_menace.adt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Random;


public class Bag_Array<Item> implements BagInterface<Item> {

    Logger logger = LoggerFactory.getLogger(Bag_Array.class.getName());

    private int count = 0;

    private Item[] items = null;

    public Bag_Array() {
        grow((Item[]) new Object[0], 32);
    }

    private void grow(Item[] source, int size) {
        items = growFrom(source, size);
    }

    private static <T> T[] growFrom(T[] from, int size) {
        T[] result = (T[]) new Object[size];
        System.arraycopy(from, 0, result, 0, from.length);
        return result;
    }

    private int capacity(){
        return items.length;
    }

    private boolean full(){
        return size() == capacity();
    }

    @Override
    public void add(Item item) {
        if (full()) grow(items, 2 * capacity());
        items[count++] = item;
    }

    /**
     * http://cs.boisestate.edu/~cs221/projects/Clocks/files/Bag.java
     * @param element
     * @return
     */

    @Override
    public Item grab(Item element){

        Item targetElement = null;

        Boolean found = false;

        int i = 0;

        while(i < count && !found){

            if(items[i] == element){

                targetElement = items[i];

                // Picking up the last element and placing it to ith place
                items[i] = items[count - 1];

                items[count-1] = null;

                count--;

                found = true;
            }
            i++;
        }
        if(!found){
            throw new RuntimeException("Element not found");
        }

        return targetElement;

    }

    @Override
    public Item grabByIndex(int index){

        if(index > size() - 1){
            throw new RuntimeException("Index out of bounds");
        }

        Item retrievedItem = items[index];

        items[index] = items[count - 1];

        items[count - 1] = null;

        count--;

        return retrievedItem;

    }



    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
