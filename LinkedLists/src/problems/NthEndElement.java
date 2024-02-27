package problems;

import utils.Node;

import java.util.LinkedHashMap;
import java.util.Objects;

/*
 Problem Statement:-Nth node from end of linked list
 Approches:-Using Lenght
            Using HashMap Extra space
            Using Slow and Fast pointer

*/


public class NthEndElement {
    /*
    Time Complexity: O(N) - due to the two passes through the linked list.
    Space Complexity: O(1) - constant space usage.
    */
    public int usingLenghtOfLinkedList(Node head, int n) {
        if (Objects.isNull(head)) {
            return -1;
        }
        int lenght = getLengthofLinkedList(head);
        if (n > lenght) {
            return -1;
        }
        int start = lenght - n + 1;
        for (int i = 1; i < start; i++) {
            head = head.next;
        }
        return head.data;

    }

    /*
     Time Complexity: O(N) - one iteration of linked list
     Space Complexity: O(N) - HashMap of size linkedlist size
     */
    public int usingExtraSpace(Node head, int n) {
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();
        Node current = head;
        int index = 0;
        if (Objects.isNull(head)) {
            return -1;
        }
        while (Objects.nonNull(current)) {
            map.put(index, current);
            index++;
            current = current.next;
        }
        int mapSize = map.size();
        if (n > mapSize) {
            return -1;
        }
        int nthElement = mapSize - n + 1;
        Node nthNode = map.get(nthElement);
        return nthNode.data;


    }

    /*
   Time Complexity: O(N) - due to the two passes through the linked list.
   Space Complexity: O(1) - constant space usage.
   */
    public int getNthFromLast(Node head, int n) {
        LinkedHashMap<Integer, Node> map = new LinkedHashMap<>();
        Node current = head;
        Node fast = current;
        Node slow = current;
        if (Objects.isNull(head)) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (Objects.nonNull(fast)) {
            fast = fast.next;
            slow = slow.next;
        }
        if (Objects.nonNull(slow)) {
            return slow.data;
        }
        return -1;
    }

    public int getLengthofLinkedList(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }
}
