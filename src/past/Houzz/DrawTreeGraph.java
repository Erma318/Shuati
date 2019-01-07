package past.Houzz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DrawTreeGraph {
    static class Node {
        int val;
        int col;
        Node left;
        Node right;
        Node(int val, Node left, Node right) {
            this.val = val;
            col = -1;
            this.left = left;
            this.right = right;
        }

    }

    public void draw(Node root) {
        inorder(root, 0);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> temp = new ArrayList<Node>();
            for (int i = 0; i < size; i++) {
                Node cur = queue.pollFirst();
                temp.add(cur);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            int index = 0;
            for (Node x : temp) {
                for (int i = index; i < x.col; i++) {
                    System.out.print(" ");
                }
                System.out.print(x.val);
                index = x.col + 1;
            }
            System.out.println();
        }
    }

    private int inorder(Node root, int col) {
        if (root == null) {
            return col;
        }
        col = inorder(root.left, col);
        root.col = col++;
        return inorder(root.right, col);
    }

    public static void main(String[] args) {
        //       5
        //     /   \
        //   2      7
        //  /\    / \
        // 4 3      9

        // above tree (not a search tree)
        Node leaf1 = new Node(4, null, null);
        Node leaf2 = new Node(3, null, null);
        Node leaf3 = new Node(8, null, null);
        Node leaf4 = new Node(9, null, null);

        Node p1 = new Node(2, leaf1, leaf2);
        Node p2 = new Node(7, null, leaf4);

        Node root = new Node(5, p1, p2);
        DrawTreeGraph here = new DrawTreeGraph();
        here.draw(root);
    }
}
