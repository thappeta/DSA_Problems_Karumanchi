package problems;

import utils.Node;

/*
Problem : Print Linked List elements

 */
public class DisplayLinkedList {
    void display(Node head) {
        if(head==null){
            return;
        }
        Node currentNode=head;
        while (currentNode!=null){
            System.out.printf(currentNode.data+" ");
            currentNode=currentNode.next;
        }
    }
}
