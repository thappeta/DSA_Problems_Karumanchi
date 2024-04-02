package interviewbit;

import utils.Node;

import java.util.List;
import java.util.Objects;

public class ReverseLinkedList {


    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode node = current.next;
            current.next = prev;
            prev = current;
            current = node;
        }
        return prev;
    }

    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode currentHead1 = head1;
        boolean isLoopExist = false;
        if (head1 == null || head2 == null) {
            return null;
        }

        while (currentHead1.next != null) {
            currentHead1 = currentHead1.next;
        }
        currentHead1.next = head2;

        ListNode slowNode = head1;
        ListNode fastNode = head1;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (slowNode == fastNode) {
                isLoopExist = true;
                break;
            }
        }
        if (isLoopExist) {
            ListNode newStart = head1;
            while (newStart != fastNode) {
                newStart = newStart.next;
                fastNode = fastNode.next;
            }
            return newStart;
        }
        return null;
    }
    public int solve(ListNode head, int b) {
        if(head==null){
            return -1;
        }
        if(head.next==null && 1<b){
            return -1;
        }
        int count=1;
        ListNode current=head;
        while (current!=null){
            count++;
            current=current.next;
        }
        int mid=(count/2)+1;
        if(mid<b){
            return -1;
        }
        ListNode newStart=head;
        for(int i=1;i<=mid;i++){
            newStart=newStart.next;
        }
        return newStart.val;
    }
}
