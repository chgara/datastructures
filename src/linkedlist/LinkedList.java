package linkedlist;

public class LinkedList {

    public static void main(String[] args) throws CloneNotSupportedException {

       SinglyLinkedList List = new SinglyLinkedList();

       for(int i=0; i<5; i++){
           List.push(i);
       }
       List.printList();
       System.out.println("Start the new one");

       //Implementing the clone of the list
       SinglyLinkedList secondOne = List.clone();
       secondOne.append(1);
       secondOne.printList();

       //Showing that the original list haven't changed
       System.out.println("Start the new one");
       List.printList();
    }
}
