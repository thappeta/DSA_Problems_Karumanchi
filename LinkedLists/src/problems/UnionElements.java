package problems;

import utils.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class UnionElements {
    public static Node findUnion(Node head1, Node head2) {
        Node node = new Node(0);
        Node resultNode = node;
        ArrayList<Integer> nodeData = new ArrayList<>();
        while (head1 != null) {
            if (!nodeData.contains(head1.data)) {
                nodeData.add(head1.data);
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            if (!nodeData.contains(head2.data)) {
                nodeData.add(head2.data);
            }
            head2 = head2.next;
        }
        Collections.sort(nodeData);
        for (Integer i : nodeData) {
            resultNode.next = new Node(i);
            resultNode = resultNode.next;
        }
        return node.next;
    }

}
