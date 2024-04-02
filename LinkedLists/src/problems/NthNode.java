package problems;

import utils.Node;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class NthNode {
    public static int getNthUsingExtraSpace(Node node, int ind)
    {
        LinkedHashMap<Integer, Node> nodeMap = new LinkedHashMap<>();
        int count=0;
        while (node!=null){
            nodeMap.put(count,node);
            node=node.next;
            count++;
        }
        return nodeMap.get(ind).data;
    }
    public static int getNth(Node node, int ind)
    {
        int count=1;
        while (node!=null && ind>count){
            node=node.next;
            count++;
        }
        return node.data;
    }

}
