package interviewbit.lint2pointer;

import interviewbit.ListNode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        LinkedHashSet<Integer> linkedListData = new LinkedHashSet<>();
        ListNode newHead=null;
        ListNode newTail=null;
        ListNode current=head;
        while (current!=null){
            linkedListData.add(current.val);
            current=current.next;
        }

        Iterator<Integer> iterator = linkedListData.iterator();
        while (iterator.hasNext())
        {
            Integer val = iterator.next();
            ListNode node = new ListNode(val);
            if(newHead==null){
                newHead=node;
                newTail=node;
            }else {
                newTail.next=node;
                newTail=node;
            }
        }
        return newHead;
    }
}
