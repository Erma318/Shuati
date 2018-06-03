package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            List<Integer> temp = new ArrayList<>();
            helper(nums, 0, res, temp);
            return res;
        }

        private void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> temp) {
            if (index == nums.length) {
                res.add(new ArrayList<>(temp));
                return;
            }
            // add
            temp.add(nums[index]);
            helper(nums, index + 1, res, temp);
            temp.remove(new Integer(nums[index]));
            //not add
            helper(nums, index + 1, res, temp);
        }

    public static void main(String[] args) {
        Subsets here = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(here.subsets(nums));
    }
}
