package LinkedList.implementation.singlyLinkedList;

import java.util.Objects;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    @Override
    public String toString(){
        return "Node data: " + data;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        
        if(! (o instanceof Node))
            return false;

        // type casting
        Node<T> node = (Node<T>) o;
        if(node.data != data)
            return false;

        return true;
    }
    
    @Override
    public int hashCode(){
        return Objects.hashCode(data);
    }
}
