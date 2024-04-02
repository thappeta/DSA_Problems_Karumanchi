package problems;

import utils.Node;

public class MergeSortedLinkedLists {
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
