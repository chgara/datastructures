package linkedlist;

public class LinkedList {
    Node head; //This will be the first node of the linked list

    /*This will be the main node class*/
    public static class Node{
        int data;
        Node next;
        //Constructor to create the new node
        Node (int d){data = d;}
    }
    /**
     * This function will push to the front of the
     * list de data given
     */
    public void push(int data){

        //Allocate the node and Put in the data
        Node new_node = new Node(data);
        //Make next of new Node as head
        new_node.next = head;
        //Make the new node to be the head
        head = new_node;

    }
    /**
     * This function will add a new Node to
     * the las node of the list
     */
    public void append(int data){
        //Allocate the node, put the data and set next as null
        Node new_node = new Node(data);
        //If the linkedList is Null, then make the new node as head
        if (head == null){ head = new_node; return; }
        //Else traverse until the last node
        Node last = head.next;
        while(last.next !=null){
            last = last.next;
        }
        //Change the next of the last node
        last.next = new_node;
    }


    /**
     * This function will add a node after
     * the given node
     */
    public void insertAfter(Node prev_node, int data){
        //Check if the given Node is Null
        if (prev_node == null){
            System.out.println("The given previous Node can't be Null");
            return;
        }
        //Allocate the node and put in the data
        Node new_node = new Node(data);

        //Make next of the New node to be the next of the given Node
        new_node.next = prev_node.next;

        //Make next node of the given node to be the new one
        prev_node.next = new_node;

    }
    /**
    * This function will delete the first node
    * that have the data given
    */
    public void deleteNode(int key){
        //Setting the head as the default node
        Node temp = head, prev_node = null;
        //If head have the value, delete it self
        if(temp != null && temp.data == key){
            head = temp.next;//Changed head
            temp = temp.next;
        }
        //Search for the key to be deleted
        while(temp != null && temp.data != key){
            prev_node = temp;
            temp = temp.next;
        }
        //If the key its no on the node list
        if(temp == null) return;

        //Unlink the given node
        assert prev_node != null;
        prev_node.next = temp.next;

    }

    /**
     * Delete a node given a position
     * starting at 0 that is the head
     */
    public void deleteByPosition(int position){
       //If the position is 0 delete the head
        if(position == 0){
            head = head.next;
            return;
        }

        //Initialize de position on 0
        int actualPosition = 0;
        Node actual = head;

        //Traversing till the node
       while(actualPosition < position-1){
           if(actual == null) return;
           actual = actual.next;
           actualPosition++;
       }

       //Deleting the node
       actual.next = actual.next.next;
    }

    /**
     * Delete the entire list
     */
    public void deleteList(){
        //The java garbage collector deletes it
        head = null;
    }

    /**
     * Returns the length of the list
     */
    public int listLength(){
        int counter = 0;
        Node actual = head;

        //Traversing till the last node
        while(actual != null){
            counter++;
            actual = actual.next;
        }
        return counter;
    }

    /**
     * Search a value in the linked list
     */
    public boolean searchValue(int val){
        Node actual = head;

        //Search till find the val
        while(actual != null && actual.data != val){
            actual = actual.next;
        }

        return actual != null;
    }

    /**
     * Return the nth node starting
     * in the 0 head
     */
    public int getNth(int position){
        //If the position is the head
        if(position == 0) return head.data;

        Node actual = head;
        int actualPosition = 0;

        //Search the node
        while(actual != null){
            if(actualPosition == position) return actual.data;
            actualPosition++;
            actual = actual.next;
        }
        assert(false);
        return 0;
    }

    /**
     * Return the data given and index,
     * starting by the tail
     */
    public int getInverseNth(int position){
        int length = this.listLength()-1;
        int realPosition = length - position;

        //If the realPosition is 0 return head
        if(realPosition == 0) return head.data;

        Node actual = head;
        int actualPosition = 0;

        while(actual != null){
            if(actualPosition == realPosition) return actual.data;
            actualPosition++;
            actual = actual.next;
        }
        assert(false);
        return 0;
    }

    /**
     * Returns the middle data of the list
     * if its even it will return the 2
     * middle
     */
    public int printMiddleList(){
        Node current = head;
        int length = this.listLength()-1;
        int position;
        if(length % 2 == 0){
            position = length/2;
        }else{
            position = (length+1)/2;
        }
        return this.getNth(position);
    }

    /**
     * Gives the number of times a item
     * appears in the list
     */
    public int timesOf(int value){
        Node current = head;
        int times = 0;

        while(current != null){
            if(current.data == value) times++;
            current = current.next;
        }
        return times;
    }

    /**
     * Erase the duplicates of a shorted
     * in non decreasing order
     */
    public void eraseDuplicatesInOrderedList(){
        Node current = head;
        //Little hack to initialize
        int last = head.data-1;
        int position = 0;
        while(current != null){
            if(last == current.data){
               this.deleteByPosition(position);
            }
            last = current.data;
            current = current.next;
            position++;
        }
    }

    /**
     * Push the tail node to the head
     */
    public void pushTailToHead(){
        if(head == null || head.next == null)return;

        Node actual = head;
        Node secActual = head;
        //find the last node
        while(actual.next != null) {
            secActual = actual;
            actual = actual.next;
        }
        actual.next = head;
        secActual.next = null;
        head = actual;
    }
    /**
     * Print the list
     */
    public void printList(){
        //The first time the first node will be the head
        //of the linked list
        Node actualNode = head;
        while(actualNode != null){
            //When the node have the direction to a new node
            System.out.println(actualNode.data);
            actualNode = actualNode.next;
        }

    }

    public static void main(String[] args){
        //Initializing the node list
        LinkedList linkedList = new LinkedList();

        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);
        linkedList.pushTailToHead();
        linkedList.printList();
    }
}
