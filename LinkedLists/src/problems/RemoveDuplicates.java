package problems;

import utils.Node;

public class RemoveDuplicates {
    public static Node removeAllDuplicates(Node head)
    {
        if (head == null || head.next == null)
            return head;

        Node newHead = null;
        Node tail = null;
        int data = Integer.MIN_VALUE;
        Node temp = head;

        while (temp != null) {
            if (temp.next != null && temp.data == temp.next.data) {
                data = temp.data;
                temp = temp.next;
                continue;
            }

            if (temp.data != data) {
                if (newHead == null) {
                    newHead = temp;
                    tail = temp;
                } else {
                    tail.next = temp;
                    tail = temp;
                }
            }

            temp = temp.next;
        }

        if (tail != null) {
            tail.next = null;
        }

        return newHead;
    }

    public static Node uniqueLinkedlist(Node head) {
        Node prevNode=head;
        Node nextNode=prevNode.next;
        while (nextNode!=null){
            if(nextNode.data==prevNode.data){
                nextNode=nextNode.next;
                continue;
            }
            prevNode.next=nextNode;
            prevNode=nextNode;
            nextNode=nextNode.next;
        }
        prevNode.next=null;
        return head;
    }
}
