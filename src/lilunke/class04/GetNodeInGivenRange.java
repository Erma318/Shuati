package lilunke.class04;

import java.util.ArrayList;
import java.util.List;

public class GetNodeInGivenRange {
    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        getRange(root, min, max, res);
        return res;
    }
    private void getRange(TreeNode root, int min, int max, List res) {
        if (root.left.key >= min) {
            getRange(root.left, min, max, res);
        }
        if (root.key <= max && root.key >= min) {
            res.add(root.key);
        }
        if (root.right.key <= max) {
            getRange(root.right, min, max, res);
        }
    }
}
