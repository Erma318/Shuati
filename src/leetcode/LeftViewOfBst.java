package leetcode;

import java.util.LinkedList;
import java.util.List;

public class LeftViewOfBst {
    public static class Node {
        Node left;
        Node right;
        int val;
        Node(int val) {
            this.val = val;
        }
    }

    public List<Integer> leftView(Node root) {
        List<Integer> res = new LinkedList<>();
        int[] maxLevel = {0};
        helper(root, maxLevel, 1, res);
        return res;
    }

    private void helper(Node root, int[] maxLevel, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (level > maxLevel[0]) {
            res.add(root.val);
            maxLevel[0] = level;
        }
        helper(root.left, maxLevel, level + 1, res);
        helper(root.right, maxLevel, level + 1, res);
    }
    public static void main(String[] args) {
        LeftViewOfBst here = new LeftViewOfBst();
        Node four = new Node(4);
        Node five = new Node(5);
        Node two = new Node(2);
        Node three= new Node(3);
        Node one = new Node(1);
        four.left = five;
        four.right = two;
        two.left = three;
        two.right = one;
        System.out.println(here.leftView(four));
    }

}
