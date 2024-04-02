package problems;

import utils.Node;

public class ReverseMergeSortLinkedLists {
    Node mergeResult(Node node1, Node node2)
    {
       return reverseList(sortedMerge(node1,node2));
    }
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node dummy = new Node(0);
        Node headNode=dummy;
        while (head1 != null &head2 != null) {
            if (head1.data < head2.data) {
                headNode.next = head1;
                headNode = headNode.next;
                head1 = head1.next;
            } else {
                headNode.next = head2;
                headNode = headNode.next;
                head2 = head2.next;
            }
        }
        while (head1 != null) {
            headNode.next = head1;
            headNode = headNode.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            headNode.next = head2;
            headNode = headNode.next;
            head2 = head2.next;
        }
        return dummy.next;
    }
}
