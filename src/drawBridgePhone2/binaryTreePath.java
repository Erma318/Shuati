package drawBridgePhone2;

import java.util.LinkedList;
import java.util.List;

public class binaryTreePath {
    static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }
    }
    public List<Integer> find(Node root, Node node) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        if (root == null) {
            res.add(root.val);
            return res;
        }
        helper(res, root, node);
        return res;
    }

    private Node helper(List<Integer> res, Node root, Node node) {
        if (root == null) return null;
        if (root == node) {
            res.add(0, root.val);
            return root;
        }
        Node left = helper(res, root.left, node);
        Node right = helper(res, root.right, node);
        if (left == null && right == null) {
            return null;
        } else {
            res.add(0, root.val);
            return root;
        }
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        //Node node = new Node(5);
        binaryTreePath here = new binaryTreePath();
        for (Integer n : here.find(one, five)) {
            System.out.println(n);
        }
    }
}
