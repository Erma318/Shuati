package lilunke.class04;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalOfBinaryTree {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        inOrder(root, res);
        return res;
    }
    private static void inOrder(TreeNode root, List res) {
        if (root == null ) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.key);
        inOrder(root.right, res);
    }
}
