package interviewbit.lint2pointer;

import interviewbit.ListNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicates2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        HashMap<Integer, Integer> linkedHashMap = new HashMap<Integer, Integer>();

        ListNode current = head;
        while (current != null) {
            if (linkedHashMap.containsKey(current.val)) {
                Integer k = linkedHashMap.get(current.val)+1;
                linkedHashMap.replace(current.val,k);
            } else {
                linkedHashMap.put(current.val, 1);
            }
            current = current.next;
        }


        ListNode newCurrentNode = head;
        ListNode newHead = null;
        ListNode newTail = null;
        while (newCurrentNode != null) {

            if (linkedHashMap.get(newCurrentNode.val) > 1) {
                newCurrentNode = newCurrentNode.next;
            } else {
                ListNode node = new ListNode(newCurrentNode.val);
                if (newHead == null) {
                    newHead = node;
                    newTail = node;
                } else {
                    newTail.next = node;
                    newTail = node;
                }
                newCurrentNode = newCurrentNode.next;
            }

        }
        return newHead;
    }
}
