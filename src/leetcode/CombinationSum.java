package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(candidates, 0, 0, temp, target, res);
        return res;
    }

    private void helper(int[] candidates, int index, int sum, List<Integer> temp, int target, List<List<Integer>> res) {
        if (index == candidates.length) {
            if (sum == target) {
                res.add(copyList(temp));
            }
            return;
        }
        temp.add(candidates[index]);
        helper(candidates, index + 1, sum + candidates[index], temp, target, res);
        temp.remove(temp.size() - 1);
        helper(candidates, index + 1, sum, temp, target, res);
    }

    private List<Integer> copyList(List<Integer> temp) {
        List<Integer> out = new ArrayList<>();
        for (int x : temp) {
            out.add(x);
        }
        return out;
    }
    public static void main(String[] args) {
        CombinationSum here = new CombinationSum();
        int[] candidates = {6, 7};
        int target = 7;
        System.out.println(here.combinationSum(candidates, target));
    }
}
