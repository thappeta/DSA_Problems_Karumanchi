package problems;

import utils.Node;

import java.util.HashMap;
import java.util.HashSet;

public class YIntersectionPoint {

    /*

    Using HashMap
    Time Complexity: O(N+M) - due to the passes through the linkedlists.
    Space Complexity: O(N+M) - constant space usage.

    */

   public int intersectPointUsingHashMap(Node head1, Node head2) {
       HashMap<Node, Integer> nodes = new HashMap<>();
       if(head1==null || head2==null){
            return -1;
        }
        Node currentHead1=head1;
        Node currentHead2=head2;
        while (currentHead1!=null){
            nodes.put(currentHead1,currentHead1.data);
            currentHead1= head2.next;
        }
        while (currentHead2 !=null){
            if(nodes.containsKey(currentHead2)){
                return currentHead2.data;
            }
            currentHead2=currentHead2.next;
        }
        return -1;
    }

    /*
     Floyd Principle
     Space Complexity:-O(1) No Space is needed
     Time Complexity :-O(n) Iteration of whole linkedlist
    */
    public int intersectPointUsingCycle(Node head1, Node head2) {
        Node currentHead1=head1;
        boolean isLoopExist=false;

        while (currentHead1.next!=null){
            currentHead1=currentHead1.next;
        }
        currentHead1.next=head2;

        Node slowNode=head1;
        Node fastNode=head1;

        while (fastNode!=null && fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(slowNode==fastNode){
                isLoopExist=true;
                break;
            }
        }
        if(isLoopExist){
            Node newStart=head1;
            while (newStart!=fastNode){
                newStart=newStart.next;
                fastNode=fastNode.next;
            }
            return newStart.data;
        }
        return -1;
    }
    /*
    Time Complexity: O(N+M) - due to the two passes through the linkedlists.
    Space Complexity: O(1) - constant space usage.
    */

    public int intersectPoint(Node head1, Node head2) {

        Node curHead1;
        Node curHead2;
        Node currentHead1=head1;
        int dif=0;
        int headCount1=0;

        while (currentHead1!=null){
            headCount1++;
            currentHead1=currentHead1.next;
        }

        Node currentHead2=head2;
        int headCount2=0;

        while (currentHead2!=null){
            headCount2++;
            currentHead2=currentHead2.next;
        }
        if(headCount1<headCount2){
            curHead1=head2;
            curHead2=head1;
            dif=headCount2-headCount1;

        }else {
            curHead1=head1;
            curHead2=head2;
            dif=headCount1-headCount2;
        }
        for(int i=0;i<dif;i++){
            curHead1=curHead1.next;
        }
        while (curHead1!=null && curHead2!=null){
            if(curHead1==curHead2){
                return curHead1.data;
            }
            curHead1=curHead1.next;
            curHead2=curHead2.next;
        }
        return -1;
    }
    /*
      Time Complexity: O(N+M) - due to the two passes through the linkedlists.
      Space Complexity: O(1) - constant space usage.
    */
    int intersectPointPoint(Node head1, Node head2)
    {
        Node currentHead1=head1;
        while (currentHead1.next!=null){
            currentHead1=currentHead1.next;
        }
        currentHead1.next=head2;
        boolean isloopExists=false;
        Node fastNode=head1;
        Node slowNode=head1;
        Node newSlowNode=head1;
        while (fastNode!=null){
            fastNode=fastNode.next;
            if(fastNode!=null){
                fastNode=fastNode.next;
                slowNode=slowNode.next;
            }
            if(fastNode==slowNode){
                isloopExists=true;
                break;
            }
        }
        if(isloopExists){
           while (fastNode!=newSlowNode){
               fastNode=fastNode.next;
               newSlowNode=newSlowNode.next;
           }
        }
        return newSlowNode.data;
    }

}
