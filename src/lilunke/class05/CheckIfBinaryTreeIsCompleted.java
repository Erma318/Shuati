package lilunke.class05;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here.
        if(root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> NodeQueue = new LinkedList<>();
        NodeQueue.offer(root);
        while(!NodeQueue.isEmpty()) {
            TreeNode temp = NodeQueue.poll();
            if (temp.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                NodeQueue.offer(temp.left);
            }
            if (temp.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                NodeQueue.offer(temp.right);
            }
        }
        return true;
    }
    public static class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        three.left = two;
        three.right = one;
        //two.left = one;
        CheckIfBinaryTreeIsCompleted here = new CheckIfBinaryTreeIsCompleted();
        System.out.println(here.isCompleted(three));

    }
}
