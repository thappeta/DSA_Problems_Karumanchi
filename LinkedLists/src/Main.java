
import interviewbit.ListNode;
import interviewbit.ReverseLinkedList;
import interviewbit.reversetricks.ReverseLinkedLists;
import utils.LinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println(15%7);

        for (int i = 1; i <=10; i++) {
            LinkedList.insertAtEnd(i);
        }
        LinkedList.printData(LinkedList.head);
        System.out.println();
        ListNode reverseList = ReverseLinkedLists.reverseKGroupNodes(LinkedList.head,7);
        LinkedList.printData(reverseList);




    }


}

