package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements DequeApi<T>,Iterable<T>{
    private int size;
    private int capacity;
    private double loadFactor = 0.25;
    private int nextFirst;
    private int nextLast;
    T []items;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index<0||index>=size()){
            return null;
        }
        return items[index];
    }

    @Override
    public void printDeque() {
        for (int i = 0 ;i < size();i++){
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public T removeFirst() {
        if (size()==0){
            return null;
        }else {
            nextFirst = increment(nextFirst);
            T ret = items[nextFirst];
            items[nextFirst] = null;
            return ret;
        }
    }

    @Override
    public T removeLast() {
        if (size() == 0){
            return null;
        }else {
            nextLast = decrement(nextLast);
            T ret = items[nextLast];
            items[nextLast] = null;
            return ret;
        }
    }

    @Override
    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = decrement(nextFirst);
        size++;
    }

    @Override
    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = increment(nextLast);
        size++;
    }

    @Override
    public boolean euqals(Object other) {
        return false;
    }

    private int increment(int num){
        return (num + 1) % capacity;
    }

    private int decrement(int num){
        return (num - 1) % capacity;
    }
    private class ArrayDequeIterator implements Iterator<T>{
        public ArrayDequeIterator() {
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
