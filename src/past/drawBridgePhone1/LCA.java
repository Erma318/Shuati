package past.drawBridgePhone1;

public class LCA {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || p == root.val || q == root.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        LCA here = new LCA();
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode twogao = new TreeNode(2);
        TreeNode six = new TreeNode(6);
        TreeNode twodi = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode seven = new TreeNode(7);
        three.left = five;
        three.right = zero;
        twodi.left = six;
        twodi.right = seven;
        seven.right = twodi;
        zero.left = twogao;
        System.out.println(here.lowestCommonAncestor(three, 6, 2).val);

    }

}
