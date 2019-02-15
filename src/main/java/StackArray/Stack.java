package StackArray;

import java.util.Comparator;

public class Stack<T extends Comparable<T>> {

    private T[] stack;
    private int numOfItems;
    private T minItem;

    public Stack() {
        this.stack = (T[]) new Comparable[1];
    }

    // O(1) if no resize
    public void push(T newData) {
        if(numOfItems == this.stack.length) {
            resize(2*this.stack.length);
        }

        this.stack[numOfItems++] = newData;

        if (minItem == null) {
            minItem = newData;
        }
        else if (minItem.compareTo(newData) >  0) {
            minItem = newData;
        }
    }

    // O(1) if no resize
    public T pop() {
        T itemToPop = this.stack[--numOfItems];

        if (numOfItems > 0 && numOfItems == this.stack.length / 4) {
            resize(this.stack.length / 2);
        }

        return itemToPop;
    }

    public boolean isEmpty() {
        return this.numOfItems == 0;
    }

    public int size() {
        return this.numOfItems;
    }

    public T min() {
        return minItem;
    }

    // O(N) linear time capacity
    private void resize(int capacity) {
        T[] stackCopy = (T[]) new Comparable[capacity];

        for( int i=0; i<numOfItems; ++i) {
            stackCopy[i] = this.stack[i];
        }

        this.stack = stackCopy;
    }
}
