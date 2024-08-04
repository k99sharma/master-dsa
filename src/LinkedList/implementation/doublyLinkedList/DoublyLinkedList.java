package LinkedList.implementation.doublyLinkedList;

import LinkedList.exception.InvalidPosition;

public class DoublyLinkedList<T> {
    private int size;
    private Node<T> head;

    public DoublyLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void addAtFront(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null)
            this.head = node;

        else{
            node.setNext(this.head);
            this.head.setPrev(node);
            this.head = node;
        }

        this.size++;
    }

    public void add(T data){
        Node<T> node = new Node<>(data);

        if(this.head == null){
            this.head = node;
        }else{
            Node<T> start = head;
            while(start.getNext() != null){
                start = start.getNext();
            }

            start.setNext(node);
            node.setPrev(start);
        }

        this.size++;
    }

    public void addAtPosition(T data, int position) throws InvalidPosition {
        Node<T> node = new Node<>(data);

        if (position > this.size)
            throw new InvalidPosition();

        else if (position == this.size){
            add(data);
            this.size++;
        }

        else{
            Node<T> start = head;
            for(int i=0; i<position-1; i++){
                start = start.getNext();
            }

            node.setNext(start.getNext());
            start.setNext(node);
            node.setPrev(start);
            node.getNext().setPrev(node);

            this.size++;
        }
    }

    public void deleteFromFront(){
        if(this.size == 0){
            System.out.println("List is empty!");
        }else if(this.size == 1){
            this.head = null;
            this.size--;
        }else{
            this.head = this.head.getNext();
            this.size--;
        }
    }

    public boolean contains(T data){
        Node<T> start = this.head;
        while(start != null){
            if(start.getData() == data)
                return true;

            start = start.getNext();
        }

        return false;
    }

    public boolean contains(Node<T> node){
        Node<T> start = this.head;
        while(start != null){
            if(start.equals(node))
                return true;

            start = start.getNext();
        }

        return false;
    }

    @Override
    public String toString(){
        Node<T> start = head;
        StringBuilder out = new StringBuilder("-- Doubly Linked List --\n");
        out.append("head");
        while(start != null){
            out.append(" -> ").append(start.getData());

            if(start.getNext() == null)
                out.append(" -> END ");

            start = start.getNext();
        }

        return out.toString();
    }

    public void display(){
        if(size == 0)
            System.out.println("List is empty!");

        else
            System.out.println(toString());
    }

    public static void main(String[] args) throws InvalidPosition {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);

        list.display();
        list.deleteFromFront();
        list.display();

        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.display();

        list.addAtFront(10);
        list.display();

        list.addAtPosition(12, 3);
        list.addAtPosition(13, list.getSize());
        list.display();

        list.deleteFromFront();
        list.display();
    }
}
