package drawBridgePhone1;

public class largestSmallerBST {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public int lsbst(TreeNode root, int t) {
        if (root == null) return -1;
        if (root.val > t) {
            if (root.left == null && root.right == null) return -1;
            return lsbst(root.left, t);
        } else if (root.val == t) {
            return root.val;
        } else {
            if (root.right == null || root.right.val > t)
                return root.val;
            return lsbst(root.right, t);
        }


//        if (root == null) return -1;
//        int res = root.val;
//        while (root != null) {
//            if (root.val > t) {
//                root = root.left;
//            } else {
//                res = root.val;
//                root = root.right;
//            }
//        }
//        return res <= t ? res : -1;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(12);
        TreeNode four = new TreeNode(1);
        TreeNode five = new TreeNode(3);
        TreeNode six = new TreeNode(9);
        TreeNode seven = new TreeNode(21);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        largestSmallerBST here = new largestSmallerBST();
        System.out.println(here.lsbst(one, 3));
    }

}
