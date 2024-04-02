package problems;

import utils.Node;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public Node sort(Node head) {
        Node node = new Node(0);
        Node resultNode = node;
        ArrayList<Integer> nodeData = new ArrayList<>();
        while (head != null) {
            if (!nodeData.contains(head.data)) {
                nodeData.add(head.data);
            }
            head = head.next;
        }

        Collections.sort(nodeData);
        for (Integer i : nodeData) {
            resultNode.next = new Node(i);
            resultNode = resultNode.next;
        }
        return node.next;
    }
}
