package problems;

import utils.Node;

import java.util.HashMap;

/*

Problems: 1:-Cycle Detection
          2:-Lenght of Cycle
          3:-Start of Cycle

*/

public class CycleDetectionProblems {

    /*
     Using Hash Technique

     Space Complexity:-O(n) To store whole linkedlist
     Time Complexity :-O(n) Iteration of whole linkedlist

    */
    public static boolean detectLoopWithHashing(Node head) {
        Node current = head;
        if (head == null) {
            return false;
        }
        HashMap<Node, Boolean> nodeMap = new HashMap<>();
        while (current != null) {
            if (nodeMap.containsKey(current)) {
                return nodeMap.get(current);
            } else {
                nodeMap.put(current, Boolean.TRUE);
            }
            current = current.next;
        }
        return false;
    }

    /*

     Floyd Principle
     Space Complexity:-O(1) No Space is needed
     Time Complexity :-O(n) Iteration of whole linkedlist

    */
    public static boolean detectLoop(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /*

     Floyd Principle
     Space Complexity:-O(1) No Space is needed
     Time Complexity :-O(n) Iteration of whole linkedlist

    */
    public static int countNodesinLoop(Node head) {
        int loopLength = 0;
        boolean isLoopExists = false;
        if (head == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isLoopExists = true;
                break;
            }
        }
        Node loopNode = fast;
        if (isLoopExists) {
            do {
                fast = fast.next;
                loopLength++;
            } while (fast != slow);
        }

        return loopLength;

    }
    /*

     Floyd Principle
     Space Complexity:-O(1) No Space is needed
     Time Complexity :-O(n) Iteration of whole linkedlist

    */
    public static int findFirstNode(Node head) {
        boolean isLoopExists = false;
        if (head == null) {
            return 0;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                isLoopExists = true;
                break;
            }
        }
        if (isLoopExists) {
            Node newStart = head;
            while (fast != newStart) {
                fast = fast.next;
                newStart = newStart.next;
            }
            return newStart.data;
        }
        return -1;
    }
    /*

     Floyd Principle
     Space Complexity:-O(1) No Space is needed
     Time Complexity :-O(n) Iteration of whole linkedlist

    */
    public static void removeLoop(Node head){
        if(head==null)
            return;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null || fast.next==null)
            return;
        slow=head;
        //Here we found the starting point
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        //Here we found the tail point
        while(slow!=fast.next){
            fast=fast.next;
        }
        fast.next=null;
    }
}

