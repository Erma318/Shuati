package leetcode;

public class SumRoottoLeafNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int[] res = new int[1];
        StringBuilder sb = new StringBuilder();
        helper(root, res, sb);
        return res[0];
    }

    private void helper(TreeNode root, int[] res, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res[0] += Integer.valueOf( sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;

        }
        sb.append(root.val);
        helper(root.left, res, sb);
        helper(root.right, res, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        SumRoottoLeafNumbers here = new SumRoottoLeafNumbers();
        System.out.println(here.sumNumbers(one));
    }
}
