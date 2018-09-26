package drawBridgePhone2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jungleBook {
    class Node {
        int val;
        List<Node> child = new LinkedList<>();
        public Node(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> group(int[] p) {
        List<List<Integer>> res = new LinkedList<>();
        HashMap<Integer, Node> tree = new HashMap<>();
        Node root = new Node(-1);
        tree.put(-1, root);
        for (int i = 0; i < p.length; i++) {
            if (tree.containsKey(i)) {

            } else {
                tree.put(i, new Node(i));
            }
            if (tree.containsKey(p[i])) {
                tree.get(p[i]).child.add(tree.get(i));
            } else {
                tree.put(p[i], new Node(p[i]));
                tree.get(p[i]).child.add(tree.get(i));
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                temp.add(cur.val);
                for (Node k : cur.child) {
                    queue.add(k);
                }
            }
            res.add(temp);
        }
        res.remove(0);
        return res;

    }

    public static void main(String[] args) {
        jungleBook here = new jungleBook();
        int[] p = {1, -1, 3, -1, 1, 3, 2, 0};
        System.out.println(here.group(p));
    }
}
