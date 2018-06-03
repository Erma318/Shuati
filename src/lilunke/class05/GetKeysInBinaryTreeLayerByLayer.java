package lilunke.class05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetKeysInBinaryTreeLayerByLayer {

    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> myqueue = new LinkedList<>();
        myqueue.offer(root);
        while (!myqueue.isEmpty()) {
            int size = myqueue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = myqueue.poll();
                layer.add(temp.key);
                if (temp.left != null) {
                    myqueue.offer(temp.left);
                }
                if (temp.right != null) {
                    myqueue.offer(temp.right);
                }
            }
        }
        return res;
    }

    class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }
}
