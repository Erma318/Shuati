import java.util.*;




public class CodeReview {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        helper(nums, target, res, temp);
        return res.size();
    }

    private void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int x : nums) {
            temp.add(x);
            helper(nums, target - x, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    static class GraphNode {
        int key;
        List<GraphNode> neighbors;
        GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<GraphNode>();
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        CodeReview here = new CodeReview();
        System.out.println(here.combinationSum4(nums, target));
    }
}
