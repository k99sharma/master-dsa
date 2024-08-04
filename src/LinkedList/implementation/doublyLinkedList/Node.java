package LinkedList.implementation.doublyLinkedList;

import java.util.Objects;

public class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return "Node data: " + this.data;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(! (o instanceof Node))
            return false;

        // type casting
        Node<T> node = (Node<T>) o;
        if(node.data != this.data)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(data);
    }
}
