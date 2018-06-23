package leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] post, int[] in) {
        return helper(post.length - 1, 0, in.length - 1, post, in);
    }

    private TreeNode helper(int postEnd, int inStart, int inEnd, int[] post, int[] in) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(postEnd - (inEnd - inIndex + 1), inStart, inIndex - 1, post, in);
        root.right = helper(postEnd - 1, inIndex + 1, inEnd, post, in);
        return root;
    }

    public void preTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        preTraverse(root.left);
        preTraverse(root.right);
    }

    public static void main(String[] args) {
        int[] post = {9, 15, 7, 20, 3};
        int[] in = {9,3,15,20,7};
        ConstructBinaryTreefromPreorderandInorderTraversal here = new ConstructBinaryTreefromPreorderandInorderTraversal();
        TreeNode root = here.buildTree(post, in);
        here.preTraverse(root);
    }
}
