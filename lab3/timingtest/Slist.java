package timingtest;

public class Slist<Item> {
    private class Node {
        private Node next;
        private Node pre;
        Item item;
        Node(Item a ,Node _next , Node _pre){
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
    Slist(){
        size = 0;
        sentinal = new Node(null,null,null);
        sentinal.next = sentinal;
        sentinal.pre = sentinal;
        last = sentinal;
    }
    public void addFirst(Item a){
        Node node = new Node(a,sentinal.next,sentinal);
        sentinal.next.pre = node;
        sentinal.next = node;
        if (size == 0){
            last = node;
            sentinal.pre = last;
        }
        size+=1;
    }

    public void addLast(Item a){
        Node node = new Node(a,sentinal,last);
        last.next = node;
        sentinal.pre = node;
        last = node;
        size +=1;
    }

    public int getSize(){
        return size;
    }
    public void printBackward(){
        Node a = this.sentinal;
        while (a.pre!=sentinal){
            System.out.print(a.pre.item+ " ");
            a = a.pre;
        }
        System.out.println("");
    }

    public void printForward(){
        Node a = this.sentinal;
        while (a.next != sentinal){
            System.out.print(a.next.item + " ");
            a = a.next;
        }
        System.out.println("");
    }
    public Item getLast(){
        Node i = this.sentinal;
        int a =0;
        while (i.next!=this.sentinal){
            i = i.next;
            a++;
        }
        System.out.println("a "+ a);
        return i.item;
    }

}
