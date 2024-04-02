package utils;

import interviewbit.ListNode;

import java.util.Objects;

public class LinkedList {

    public static ListNode head = null;
    public static ListNode tail = null;

    public static void insertAtStart(int data) {
        ListNode newNode = new ListNode(data);
        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (Objects.isNull(head)) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    public static void printData(ListNode current) {
        if (Objects.nonNull(current)) {
            ListNode currentNode = current;
            while (Objects.nonNull(currentNode)) {
                System.out.print(currentNode.val + "-->");
                currentNode = currentNode.next;
            }
        }
    }

    public static int getLinkedListLength(ListNode node) {
        int length = 0;
        ListNode currentNode = node;
        while (Objects.nonNull(currentNode)) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

}
