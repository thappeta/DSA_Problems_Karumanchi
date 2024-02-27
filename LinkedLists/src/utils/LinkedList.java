package utils;

import java.util.Objects;

public class LinkedList {

    public static Node head=null ;
    public static Node tail=null;

    public static Node insertAtStart( int data) {
        Node newNode = new Node(data);
        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void printData(){
        if(Objects.nonNull(head)){
            Node currentNode=head;
            while (Objects.nonNull(currentNode)){
                System.out.print(currentNode.data+"-->");
                currentNode=currentNode.next;
            }
        }
    }

    public static int getLinkedListLength(Node node) {
        int length = 0;
        Node currentNode = node;
        while (Objects.nonNull(currentNode)) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

}
