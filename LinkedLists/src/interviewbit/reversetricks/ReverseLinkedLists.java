package interviewbit.reversetricks;

import interviewbit.ListNode;

public class ReverseLinkedLists {
    public static ListNode reverseLinkedList(ListNode node) {
        ListNode revNode = null;
        ListNode currentNode = node;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = revNode;
            revNode = currentNode;
            currentNode = nextNode;
        }
        return revNode;
    }

    public static ListNode reverseFirstKNodes(ListNode node, int kGrps) {
        ListNode prevNode = null;
        ListNode currentNode = node;
        ListNode oldHead = node;
        for (int i = 0; i < kGrps; i++) {
            ListNode nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        oldHead.next = currentNode;
        return prevNode;
    }

    public static ListNode reverseBetweenNode(ListNode node, int start, int end) {
        if (node == null || start >= end) {
            return node;
        }

        ListNode prevStart = null;
        ListNode startNode = node;
        for (int i = 0; i < start && startNode != null; i++) {
            prevStart = startNode;
            startNode = startNode.next;
        }

        ListNode prev = null;
        ListNode current = startNode;
        ListNode nextNode;
        for (int i = start; i <= end - 1 && current != null; i++) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        if (prevStart != null) {
            prevStart.next = prev;
        } else {
            node = prev;
        }
        startNode.next = current;

        return node;
    }

    public static ListNode reverseKNode(ListNode node, int kGrps) {
        ListNode currentNode = node;
        ListNode lengthNode=node;
        ListNode newTail=null;
        ListNode newHead=null;
        int length = getLength(lengthNode);

        while (length>=kGrps) {
            ListNode revNode = null;
            ListNode kGrpNode = currentNode;
            int j=0;
            while (j< kGrps&& kGrpNode != null) {
                ListNode nextNode = kGrpNode.next;
                kGrpNode.next = revNode;
                revNode = kGrpNode;
                kGrpNode = nextNode;
                j++;
            }
            length=length-kGrps;
            if(newHead==null){
                newHead=revNode;
            }else {
                newTail.next=revNode;
            }
            newTail=currentNode;
            currentNode = kGrpNode;
        }
        newTail.next=currentNode;
        return newHead;
    }
    public static ListNode reverseKGroupNodes(ListNode node, int kGrps) {
        ListNode currentNode = node;
        ListNode lengthNode=node;
        ListNode newTail=null;
        ListNode newHead=null;
        int length = getLength(lengthNode);

        while (currentNode!=null) {
            ListNode revNode = null;
            ListNode kGrpNode = currentNode;
            int j=0;
            while (j< kGrps&& kGrpNode != null) {
                ListNode nextNode = kGrpNode.next;
                kGrpNode.next = revNode;
                revNode = kGrpNode;
                kGrpNode = nextNode;
                j++;
            }
            length=length-kGrps;
            if(newHead==null){
                newHead=revNode;
            }else {
                newTail.next=revNode;
            }
            newTail=currentNode;
            currentNode = kGrpNode;
        }
        return newHead;
    }

    public static int getLength(ListNode node) {
        int cnt = 0;
        ListNode current = node;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }


}
