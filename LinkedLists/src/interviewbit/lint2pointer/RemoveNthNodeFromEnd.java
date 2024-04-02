package interviewbit.lint2pointer;

import interviewbit.ListNode;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode curr = A;
        int count = 1;
        while (curr.next != null) {
            count++;
            curr = curr.next;
        }
        count = count - B;
        curr = A;
        if (count <= 0)
            return A.next;
        while (curr.next.next != null) {
            if (count == 1) {
                curr.next = curr.next.next;
                return A;
            }
            curr = curr.next;
            count--;
        }
        curr.next = null;
        return A;
    }
}
