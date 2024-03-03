package problems;

import utils.Node;

import java.util.Objects;

public class ReverseLinkedList {
    Node tail = null;
    Node newhead = null;

    /*

     Time Complexity: O(N) - due to the single pass through the linked list.
     Space Complexity: O(N) - due to the creation of new nodes for each element in the linked list.

     */
    public Node reverseList_bruteForce(Node head) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.next)) {
            return head;
        }
        Node currentNode = head;
        while (Objects.nonNull(currentNode)) {
            Node newNode = new Node(currentNode.data);
            if (Objects.isNull(newhead)) {
                newhead = newNode;
                tail = newNode;
            } else {
                newNode.next = newhead;
                newhead = newNode;
            }
            currentNode = currentNode.next;

        }
        return newhead;
    }

    /*

      Time Complexity: O(N) - due to the single pass through the linked list.
      Space Complexity: O(1) - constant space usage.

    */
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }


    /*

     Time Complexity: O(N) - due to the single pass through the linked list.
     Space Complexity: O(1) - constant space usage.

     Explanation:- First K nodes will be reversed stored in Node prev
     On first iteration head node will be last node in reversed list current.next=kGrpNode connection has establieshed
     for remanining linkedlist

     prev.next=currentNode results,both nodes will be concatenated together

   */
    public static Node reverseFirstKGrpNodes(Node head, int k) {
        Node currentNode = head;
        Node kGrpNode = currentNode;
        Node prevNode = null;

        int i = 0;
        while (i < k && kGrpNode != null) {
            Node nextNode = kGrpNode.next;
            kGrpNode.next = prevNode;
            prevNode = kGrpNode;
            kGrpNode = nextNode;
            i++;
        }
        currentNode.next = kGrpNode;
        prevNode.next = currentNode;
        head = prevNode;
        return head;
    }


     /*

		Time Complexity: O(N) - due to the single pass through the linked list.
		Space Complexity: O(1) - constant space usage.

		Input:- 9-->8-->7-->6-->5-->4-->3-->2-->1-->null

		Output:- 7-->8-->9-->4-->5-->6-->1-->2-->3-->null
		---------------------------------------------------------------------------


		Iteration:1
		prev contains 7-->8-->9--> null;
		if (resultHead==null){
		 Head position is changed ,ResultTailNode =currentNode//IntialHeadNode
		 }

		Iteration:2

		prev contains 4-->5-->6--> null;
		if (resultHead!=null){
		  resultTailNode.next=prev  //at line 99 we stored HeadNode, and now we will connect new reverse grp
		  }
		Head position is changed ,ResultTailNode =currentNode//IntialHeadNode

        */

    public static Node reverseNGrpNodes(Node node, int k) {
        if (node == null) {
            return null;
        }
        Node resultHead = null;
        Node resultTail = null;

        Node currentNode = node;

        while (currentNode != null) {
            Node kGrpNode = currentNode;
            Node prevNode = null;

            int i = 0;
            while (i < k && kGrpNode != null) {
                Node nextNode = kGrpNode.next;
                kGrpNode.next = prevNode;
                prevNode = kGrpNode;
                kGrpNode = nextNode;
                i++;
            }

            if (resultHead == null) {
                /*
                On First Iteration K nodes are reversed
                and assigned to result head
                */
                resultHead = prevNode;
            } else {
                /*
                previous tail connected to new reversedList
                */
                resultTail.next = prevNode;
            }
            // Update the tail for the next iteration
            resultTail = currentNode;
            currentNode = kGrpNode;
        }

        return resultHead;
    }

}
