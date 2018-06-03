package leetcode;

import java.util.ArrayList;
import java.util.List;

public class test {
    // assumption: the output subSet will have the same order with the original one
    // every element in the given array be used once
    // elements in the given array is larger or equal to zero
    public List<List<Integer>> allSetSum(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(array, res, temp, 0, 0, target);
        return res;
    }

    private static void helper(int[] array, List<List<Integer>> res, List<Integer> temp, int index, int tempSum, int target) {
        // only add these subSet to the final result which is following our requirement which is the sum is equal to target
        if (index == array.length) {
            if (tempSum == target) {
                List<Integer> dest = new ArrayList<>();
                dest.addAll(temp);
                //res.add(clone(temp));
            }
            return;
        }
        if (tempSum <= target) { // when the tempSum smaller or equal to the target we need to check the case 1 and case 2
            // case 1 : adding the number at index of array
            temp.add(array[index]);
            helper(array, res, temp, index + 1, tempSum + array[index], target);
            temp.remove(temp.size() - 1);
            // case 2 : not adding the number at index of array
            helper(array, res, temp, index + 1, tempSum, target);
        } else { //when the tempSum larger than the target we only need to check the case 1
            helper(array, res, temp, index + 1, tempSum, target);
        }
    }

    private static List<Integer> clone(List<Integer> temp) {
        List<Integer> newList = new ArrayList<>();
        for (int n : temp){
            int x = n;
            newList.add(x);
        }
        return newList;
    }

    public static void main(String[] args) {
        test here = new test();
        int[] array = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int target = 7;
        System.out.println(here.allSetSum(array, target));
    }
}
