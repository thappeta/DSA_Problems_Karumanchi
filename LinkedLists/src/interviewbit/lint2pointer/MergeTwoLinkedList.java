package interviewbit.lint2pointer;

import interviewbit.ListNode;

public class MergeTwoLinkedList {
    public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        ListNode newHead;
        ListNode newTail;
        if (headA.val < headB.val) {
            newHead = headA;
            newTail = headA;
            headA = headA.next;
        } else {
            newHead = headB;
            newTail = headB;
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                newTail.next = headA;
                newTail = headA;
                headA = headA.next;
            } else {
                newTail.next = headB;
                newTail = headB;
                headB = headB.next;
            }
        }
        if (headA != null) {
            newTail.next = headA;
        }
        if (headB != null) {
            newTail.next = headB;
        }
        return newHead;
    }

}
