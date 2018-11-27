package pastOA.Cohesity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindTreeBottom {
    class Node {
        int val;
        Node left = null;
        Node right = null;
        Node (int val) {
            this.val = val;
        }
    }
    private int[] index = new int[1];
    public List<Integer> treeBottom(String tree) {
        Node root = helper(tree, index);
        return findBottom(root);
    }

    public Node helper(String tree, int[] index) {
        if (tree.charAt(index[0] + 1) == ')') {
            index[0] += 1;
            return null;
        }
        int start = index[0] + 1;
        while (Character.isDigit(tree.charAt(index[0] + 1))) {
            index[0]++;
        }
        int val = Integer.valueOf(tree.substring(start, index[0] + 1));
        Node root = new Node(val);
        index[0] += 2;
        root.left = helper(tree, index);
        index[0] += 2;
        root.right = helper(tree, index);
        index[0] += 1;
        return root;
    }
//    ArrayList <Integer> list = new ArrayList <>();
//    public void helper (Node root) {
//        if (root != null) {
//            list.add(root.val);
//            helper(root.left);
//            helper(root.right);
//        }
//    }
//    public List<Integer> preorderTraversal(Node root) {
//        helper(root);
//        return list;
//    }

    public List<Integer> findBottom(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        List<List<Integer>> wrapList = new ArrayList<List<Integer>>();

        if(root == null) return new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.add(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList.get(wrapList.size() - 1);
    }
    public static void main(String[] args) {
        String input = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))";
        FindTreeBottom here = new FindTreeBottom();
        System.out.println(here.treeBottom(input));
        //System.out.println(here.preorderTraversal(here.treeBottom(input)));
    }
}
