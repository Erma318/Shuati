package lilunke.Final;

public class Q2 {
     static class TreeNode{
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean cousins(TreeNode root, TreeNode a, TreeNode b) {
        int levela = findLevel(a, root, 0);
        int levelb = findLevel(b, root, 0);
        return (levela == levelb) && !sameParent(root, a, b);
    }

    private int findLevel(TreeNode node, TreeNode root, int level) {
        if (root == null) {
            return 0;
        }
        if (root == node) {
            return level;
        }
        int left = findLevel(node, root.left, level + 1);
        if (left != 0) {
            return left;
        }
        return findLevel(node, root.right, level + 1);
    }

    private boolean sameParent(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return false;
        }
        return root.left == a && root.right == b || root.right == a && root.left == b || sameParent(root.left, a, b) || sameParent(root.right, a, b);
    }
    public static void main(String[] args) {
        Q2 here = new Q2();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        three.left = four;
        one.left = two;
        one.right = three;
        System.out.println(here.cousins(one, two, three));
        System.out.println(here.findLevel(four, one, 0));

    }

}
