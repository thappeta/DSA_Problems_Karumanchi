package interviewbit.listtrick;

import interviewbit.ListNode;

public class Reorder {
    public ListNode reorderList(ListNode A) {
        ListNode firsthalf = A;
        ListNode mid = getMid(A);
        ListNode secondHalf = reverseList(mid.next);
        mid.next = null;
        ListNode resultNode = resultNode(firsthalf, secondHalf);
        return resultNode;
    }

    public  ListNode  resultNode(ListNode firtstHalf,ListNode secondHalf){
        ListNode tempfirst=null;
        ListNode tempSecond=null;
        while (firtstHalf!=null && secondHalf!=null){
            tempfirst=firtstHalf.next;
            tempSecond=secondHalf.next;

            firtstHalf.next=secondHalf;
            secondHalf.next=tempfirst;

            firtstHalf=tempfirst;
            secondHalf=tempSecond;
        }
        return firtstHalf;
    }
    public ListNode getMid(ListNode current) {
        ListNode fast = current;
        ListNode slow = current;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }

    public ListNode reverseList(ListNode mid) {
        ListNode prev = null;
        while (mid != null) {
            ListNode nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }
        return prev;
    }
}
