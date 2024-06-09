package LinkedList.implementation.singlyLinkedList;

import LinkedList.exception.InvalidPosition;

public class SinglyLinkedList<T> {
    private int size;
    private Node<T> head;

    public SinglyLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public int getSize(){
        return this.size;
    }

    private void setSize(int size){
        this.size = size;
    }

    public void addAtFront(T data){
        Node<T> node = new Node<>(data);

        if(head != null){
            Node<T> start = head;
            head = node;
            node.setNext(start);
        }else{
            head = node;
        }

        this.size++;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);

        if(head != null){
            Node<T> start = head;
            while(start.getNext() != null){
                start = start.getNext();
            }

            start.setNext(node);
        }else{
            head = node;
        }

        this.size++;
    }

    public void removeFirst(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }

        if(size == 1){
            this.head = null;
            return;
        }

        this.head = this.head.getNext();
        this.size--;
    }

    public void removeAtPos(int position) throws InvalidPosition {
        if(head == null){
            throw new InvalidPosition();
        }

        if(position > size){
            throw new InvalidPosition();
        }

        Node<T> start = head;
        for(int i=1; i<position-1; i++){
            start = start.getNext();
        }

        start.setNext(start.getNext().getNext());
        this.size--;
    }

    public void removeLast(){
        if(size == 0){
            System.out.println("List is empty");
            return;
        }

        if(size == 1){
            this.head = null;
            return;
        }

        Node<T> start = head;
        while(start.getNext() != null && start.getNext().getNext() != null){
            start = start.getNext();
        }

        start.setNext(null);
        this.size--;
    }

    public boolean contains(Node<T> node){
        Node<T> start = head;
        while(start != null){
            if(start.equals(node))
                return true;

            start = start.getNext();
        }

        return false;
    }

    public void display(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        Node<T> start = head;
        StringBuilder out = new StringBuilder("-- Singly Linked List --\n");
        out.append("head");
        while(start != null){
            out.append(" -> ").append(start.getData());

            if(start.getNext() == null)
                out.append(" -> END ");

            start = start.getNext();
        }

        return out.toString();
    }

    public static void main(String[] args) throws InvalidPosition {
        int size = 5;
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        // add elements in list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.display();

        // remove last 2 elements
        list.removeLast();
        list.removeLast();

        list.display();

        // remove first
        list.removeFirst();
        list.display();

        // remove pos 2
        list.removeAtPos(1);
        list.display();

        // check if 2 is present in list
        System.out.println(list.contains(new Node<>(2)));
    }
}
