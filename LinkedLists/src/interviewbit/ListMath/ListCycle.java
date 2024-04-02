package interviewbit.ListMath;

import interviewbit.ListNode;

public class ListCycle {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        boolean isLoopExist=false;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                isLoopExist=true;
                break;
            }
        }
        ListNode newStart=head;
        if(isLoopExist){
            while (newStart!=fast){
                fast=fast.next;
                newStart=newStart.next;
            }
            return newStart;
        }
        return null;
    }
}
