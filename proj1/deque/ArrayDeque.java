package deque;

import java.util.Arrays;
import java.util.Iterator;

/*
addFirst
addLast
isEmpty
size
printDeque
removeFirst
removeLast
get
iterator
equals
 */
public class ArrayDeque<T> implements DequeApi<T>{
    private int capacity = 10;
    private int size;
    private double maxLoadFactor = 0.8;
    private double minLoadFactor = 0.2;
    private int nextFirst = 5;
    private int nextLast = 4;
    T []items;
    private int incrementOne(int a){
        return (a+1)%capacity;
    }
    private int decreaseOne(int a){
        return (a-1)%capacity;
    }
    private int getCapacity(){
        return capacity;
    }
    private double getLoadFactor(){
        return capacity/(double)size;
    }
    @Override
    public int size(){return size;}

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public boolean isEmpty(){
        return size() == 0;
    }
    @Override
    public void printDeque(){
        for (int i = 0 ; i < size(); i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }
    @Override
    public T removeLast(){
        if (size() == 0){
            return null;
        }
        T ret = items[size()-1];
        size--;
        return ret;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T removeFirst(){
        if (size==0){
            return null;
        }
        T ret = items[0];
        items = Arrays.copyOfRange(items,1,size()-1);
        size--;
        return ret;
    }

    @Override
    public Iterator<T> iterator(){
        return null;
    }

    @Override
    public boolean euqals(Object other) {
        return false;
    }


    ArrayDeque(){
        size = 0;
        items = (T[])new Object[capacity];
    }


}
