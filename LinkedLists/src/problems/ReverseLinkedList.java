package problems;

import utils.Node;

import java.util.Objects;

public class ReverseLinkedList {
    Node tail = null;
    Node newhead = null;

    /*
     Time Complexity: O(N) - due to the single pass through the linked list.
     Space Complexity: O(N) - due to the creation of new nodes for each element in the linked list.
     */
    public Node reverseList_bruteForce(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.next)) {
            return head;
        }
        Node currentNode = head;
        while (Objects.nonNull(currentNode)) {
            Node newNode = new Node(currentNode.data);
            if (Objects.isNull(newhead)) {
                newhead = newNode;
                tail = newNode;
            } else {
                newNode.next = newhead;
                newhead = newNode;
            }
            currentNode = currentNode.next;

        }
        return newhead;
    }

    /*
      Time Complexity: O(N) - due to the single pass through the linked list.
      Space Complexity: O(1) - constant space usage.
    */
    public Node reverseList(Node head) {
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


}
