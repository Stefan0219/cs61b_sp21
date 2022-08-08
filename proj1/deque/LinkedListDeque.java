package deque;

import java.util.Iterator;

public class LinkedListDeque<T> {
    private class Node {
        private Node next;
        private Node pre;
        T item;
        Node(T a ,Node _next , Node _pre){
            this.item = a;
            next = _next;
            pre = _pre;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setPre(Node pre){
            this.pre = pre;
        }
    }

    private int size;
    private Node sentinal;
    private Node last;


    public T get(int index){
        if(index<0||index > size()-1){
            return null;
        }
        Node a = sentinal.next;
        while (index>0){
            index-=1;
            a =a.next;
        }
        return a.item;
    }
    /*public Iterator<T> iterator(){}
    @Override
    public boolean equals(Object obj) {
    }*/
    LinkedListDeque(){
        size = 0;
        sentinal = new Node(null,null,null);
        sentinal.next = sentinal;
        sentinal.pre = sentinal;
        last = sentinal;
    }
    public void addFirst(T a){
        Node node = new Node(a,sentinal.next,sentinal);
        sentinal.next.pre = node;
        sentinal.next = node;
        if (size == 0){
            last = node;
            sentinal.pre = last;
        }
        size+=1;
    }

    public void addLast(T a){
        Node node = new Node(a,sentinal,last);
        last.next = node;
        sentinal.pre = node;
        last = node;
        size +=1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        Node delNode = sentinal.next;
        T retValue = delNode.item;
        sentinal.next = delNode.next;
        delNode.next.pre = sentinal;
        delNode = null;
        size-=1;
        return retValue;
    }
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        Node delNode = last;
        T retValue = delNode.item;
        last = delNode.pre;
        last.next = sentinal;
        sentinal.pre = last;
        size-=1;
        delNode = null;
        return retValue;
    }
    public void printDeque(){
        Node a = this.sentinal;
        while (a.next != sentinal){
            System.out.print(a.next.item + " ");
            a = a.next;
        }
        System.out.println("");
    }
    public T getRecursive(int index){
        if (index<0){
            return null;
        } else if (index==0){
            return sentinal.next.item;
        }else {
            return getNextNode(index,sentinal.next).item;
        }
    }
    private Node getNextNode(int index,Node node){
        if (index == 0){
            return node;
        } else {
            return getNextNode(index-1,node.next);
        }
    }
}
