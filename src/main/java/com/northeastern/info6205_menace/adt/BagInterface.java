package com.northeastern.info6205_menace.adt;

import java.util.Arrays;
import java.util.Iterator;

public interface BagInterface<Item> extends Iterable<Item> {

    public boolean isEmpty();

    public int size();

    public Iterator<Item> iterator();

    public Item grab(Item item);

    public Item grabByIndex(int index);

    public void add(Item item);

}
