package linkedlist;

public class CircularLinkedList<T>{

    /*This will be the main node class*/
    private static class Node<T>{
        T data;
        Node<T> next;
        //Constructor to create the new node
        Node (T d){data = d;}
    }

    private Node<T> tail = null;
    private int size = 0;
    public CircularLinkedList(){}

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T first(){
        if(isEmpty()){
            return null;
        }
        return tail.next.data;
    }

    public T last(){
        if(isEmpty()){
            return null;
        }
        return tail.data;
    }

    //Rotate the list
    public void rotate(){
        if(tail != null){
            tail = tail.next;
        }
    }

    //Add an element to the head of the list
    public void addFirst(T data){
        if(size == 0){
            tail = new Node<T>(data);
            tail.next = tail;
        } else{
            Node<T> newest = new Node<T>(data);
            newest.next = tail.next;
            tail.next = newest;
        }
        size++;
    }

    //Add an element to the last position of
    //the list
    public void addLast(T data){
        addFirst(data);
        tail = tail.next;
    }

    //Remove the first element of the list
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }

        Node<T> head = tail.next;
        if(head==tail){
            tail = null;
        } else{
            tail.next = head.next;
        }
        size--;
        return head.data;
    }

    //Console log the nodes from the start
    public void show(){
        Node<T> temp = tail;
        while(temp != null && temp != temp.next){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args){
        CircularLinkedList<Integer> List = new CircularLinkedList<Integer>();
        List.addFirst(1);
        List.addFirst(2);
    }
}
