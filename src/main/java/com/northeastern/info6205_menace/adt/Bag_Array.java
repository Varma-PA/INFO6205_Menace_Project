package com.northeastern.info6205_menace.adt;

import java.util.Iterator;
import java.util.Random;

public class Bag_Array<Item> implements BagInterface<Item> {

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

    public void add(Item item) {
        if (full()) grow(items, 2 * capacity());
        items[count++] = item;
    }

    @Override
    public Item grab(){

        if(count == 0){
            throw new RuntimeException("Bag is Empty!!");
        }

        Random random = new Random();

        int randomNumber = random.nextInt(size());

        return items[randomNumber];

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
