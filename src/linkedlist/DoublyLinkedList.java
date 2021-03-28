package linkedlist;

public class DoublyLinkedList<T> {
    private static class Node<T>{
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data,Node<T> prev,Node<T> next){
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        public T getData(){return data;}
        public Node<T> getPrev(){
            return prev;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setPrev(Node<T> prev){
            this.prev = prev;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }
    }

    private Node<T> header;
    private Node<T> trailer;
    private int size = 0;
    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,null,null);
        header.setNext(trailer);
    }
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    /*
     *Returns the first element of the list
     */
    public T first(){
        if(isEmpty()) return null;
        return header.getNext().getData();
    }
    /*
     *Returns the last element
     */
    public T last(){
        return  trailer.getPrev().getData();
    }

    public void addBetween(T data, Node<T> predecessor, Node<T> successor){
        Node<T> newest = new Node<>(data,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public void addFirst(T data){
        addBetween(data,header,header.getNext());
    }
    public void addLast(T data){
        addBetween(data,trailer.getPrev(), trailer);
    }

    public T remove(Node<T> node){
        Node<T> predecessor = node.getPrev();
        Node<T> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getData();
    }

    public T removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }

    public T removeLast(){
        if(isEmpty()) return  null;
        return remove(trailer.getPrev());
    }
}
