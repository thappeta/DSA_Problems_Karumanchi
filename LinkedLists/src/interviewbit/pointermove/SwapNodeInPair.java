package interviewbit.pointermove;

import interviewbit.ListNode;
import utils.LinkedList;
import utils.Node;

public class SwapNodeInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode currentNode = head;
        if(head==null ||head.next==null){
            return head;
        }
        while (currentNode != null) {
            ListNode fistNode = currentNode;
            ListNode secondNode = null;
            currentNode = currentNode.next;
            if (currentNode != null) {
                secondNode = currentNode;
            } else {
                secondNode = fistNode;
            }
            int temp = fistNode.val;
            fistNode.val = secondNode.val;
            secondNode.val = temp;
            if (currentNode != null) {
                currentNode = currentNode.next;
            }

        }
        return head;
    }
}
