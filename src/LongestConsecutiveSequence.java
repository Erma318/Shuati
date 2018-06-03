import java.security.acl.LastOwnerException;

public class LongestConsecutiveSequence {
    public static class Node {
        int val;
        Node left;
        Node right;
        public Node (int val) {
            this.val = val;
        }
    }
    public int longest(Node root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1];
        max[0] = max[0] + 1;
        helper(root, 1, max);
        return max[0];
    }

    private void helper(Node root, int cur, int[] max) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.val + 1 == root.left.val) {
            max[0] = Math.max(cur + 1, max[0]);
            helper(root.left, cur + 1, max);
        } else {
            helper(root.left, 1, max);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            max[0] = Math.max(cur + 1, max[0]);
            helper(root.right, cur + 1, max);
        } else {
            helper(root.right, 1, max);
        }
    }

    public static void main (String[] args) {
        LongestConsecutiveSequence here = new LongestConsecutiveSequence();
        Node two1 = new Node(2);
        Node one = new Node(1);
        Node three = new Node(3);
        Node four = new Node(4);
        Node two2 = new Node(2);
        Node five = new Node(5);
        two1.right = one;
        one.right = three;
        three.left = two2;
        three.right = five;
        five.right = four;

        System.out.println(here.longest(two1));
    }
}
