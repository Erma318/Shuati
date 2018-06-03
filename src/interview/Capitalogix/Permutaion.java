package interview.Capitalogix;

import java.util.*;

public class Permutaion {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        helper(nums, res, 0);
        return res;
    }

    private static void helper(int[] nums, List<List<Integer>> res, int index){
        if (index == nums.length) {
            List<Integer> temp = array2List(nums);
            res.add(new ArrayList<>(temp));
            return;
        }
        Set<Integer> used = new HashSet<Integer>();
        for (int i = index  ; i < nums.length; i++) {
            if (used.add(nums[i])) {
                swap(nums, i , index);
                helper(nums, res, index + 1);
                swap(nums, i, index);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> array2List(int[] nums) {
        List<Integer> myList = new ArrayList<>();
        for (int n : nums) {
            myList.add(n);
        }
        return myList;
    }

    public static void main (String[] args) {
        int[] input = {1, 2, 3};
        Permutaion here = new Permutaion();
        System.out.println(here.permute(input));

    }
}
