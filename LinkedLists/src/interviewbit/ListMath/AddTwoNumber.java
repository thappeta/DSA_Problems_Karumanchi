package interviewbit.ListMath;

import interviewbit.ListNode;

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        int advance = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += advance;
            advance = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (newHead == null) {
                newHead = node;
                newTail = node;
            } else {
                newTail.next = node;
                newTail = node;
            }

        }
        if(advance==1){
            ListNode node = new ListNode(1);
            newTail.next=node;
            newTail=node;
        }
        return newHead;



    }
}
