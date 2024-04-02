package interviewbit.lint2pointer;

import interviewbit.ListNode;

public class PalindromeList {
    public boolean lPalin(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode newHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            if (newHead == null) {
                newHead = newNode;
            } else {
                newNode.next = newHead;
                newHead = newNode;
            }
            current=current.next;
        }
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }
}
