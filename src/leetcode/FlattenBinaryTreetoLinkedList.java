package leetcode;

public class FlattenBinaryTreetoLinkedList {

     static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode (2);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.right = two;
        one.left = five;
        five.left = six;
        five.right = seven;
        FlattenBinaryTreetoLinkedList here = new FlattenBinaryTreetoLinkedList();
        here.flatten(one);
        TreeNode start = one;
        while(start != null) {
            System.out.print(start.val + ",");
            start = start.right;
        }


    }
}
