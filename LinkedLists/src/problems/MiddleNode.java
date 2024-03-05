package problems;

import utils.Node;

public class MiddleNode {


    /*
   Time Complexity: O(N+M) -  to the  passes through the linked list.
   Space Complexity: O(1) - constant space usage.
   */
    public int getMiddleNodeBruteForce(Node head){
        int total=0;
        Node currentNode=head;
        while (currentNode!=null){
            total++;
            currentNode=currentNode.next;
        }
        for(int i=0;i<total/2;i++){
            head=head.next;
        }
        return head.data;
    }

    /*
    Time Complexity: O(N) -  to the  passes through the linked list.
    Space Complexity: O(1) - constant space usage.
    */
    int getMiddle(Node head)
    {
        Node fastNode=head;
        Node slowNode=head;
        while (fastNode!=null && fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        return slowNode.data;
    }
}
