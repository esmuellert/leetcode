package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private final HashMap<Node, Node> hashmap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node cloned = new Node(node.val);
        hashmap.put(node, cloned);
        for (Node n : node.neighbors) {
            Node clone;
            if (!hashmap.containsKey(n)) {
                clone = cloneGraph(n);
            } else {
                clone = hashmap.get(n);
            }
            cloned.neighbors.add(clone);
        }
        return cloned;
    }

    private void dfs(Node node, Node cloned) {
        hashmap.put(node, cloned);
        cloned.val = node.val;
        for (Node n : node.neighbors) {
            if (!hashmap.containsKey(n)) {
                Node clone = new Node();
                cloned.neighbors.add(clone);
                dfs(n, clone);
            } else {
                Node clone = hashmap.get(n);
                cloned.neighbors.add(clone);
            }
        }
    }

//    public static void main(String[] args) {
//        CloneGraph cg = new CloneGraph();
//        Node n1 = new Node(1);
//        Node n2 = new Node(2);
//        n1.neighbors.add(n2);
//        n2.neighbors.add(n1);
//        cg.cloneGraph(n1);
//    }
}
