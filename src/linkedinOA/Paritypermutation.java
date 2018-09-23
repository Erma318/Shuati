package linkedinOA;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Paritypermutation {
    public List<List<Integer>> pp(int[] in) {
        List<List<Integer>> rest = permutations(in);
        List<List<Integer>> res = new LinkedList<>();
        for (List<Integer> i : rest) {
            if (check(i)) {
                res.add(i);
            }
        }
        return res;
    }


    private List<List<Integer>> permutations(int[] in) {
        List<List<Integer>> res = new LinkedList<>();
        int[] clone = in.clone();
        while (true) {
            List<Integer> temp = copy(in);
            res.add(temp);
            nextPermutation(in);
            if (Arrays.equals(in, clone)) break;
        }
        return res;
    }



    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int len = nums.length;
        int i = len - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1])
                break;
        }
        int j = len - 1;
        for (; j >= 0 && i >= 0; j--) {
            if (nums[i] < nums[j]) {
                swap(nums, i, j);
                break;
            }
        }
        i = i + 1;
        j = len - 1;
        while (i <= j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



//    public List<List<Integer>> permutations(int[] in) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (in == null)
//            return result;
//        helper(in, 0, result);
//        return result;
//    }
//
//    private void helper(int[] array, int index, List<List<Integer>> result) {
//        if (index == array.length){
//            List<Integer> temp = new LinkedList<Integer>();
//            temp = copy(array);
//            result.add(temp);  //array.toString?
//            return ;
//        }
//        for (int i = index; i < array.length; i++) {
//            swap(array, index, i);
//            helper(array, index + 1, result);
//            swap(array, index, i);
//        }
//    }
//
    private List<Integer> copy(int [] array) {
        List<Integer> res = new LinkedList<>();
        for (int i : array) {
            res.add(i);
        }
        return res;
    }
//
//    private void swap(int[] array, int index, int i) {
//        int temp = array[index];
//        array[index] = array[i];
//        array[i] = temp;
//
//    }


    private boolean check(List<Integer> in) {
        int f = 0; // 0 for even, 1 for odd
        if (in.get(0) % 2 == (Integer)0) {
            f = 1;
        } else {
            f = 0;
        }
        for (int i = 1; i < in.size(); i++) {
            int t = in.get(i);
            if (t % 2 == f) {
                if (t % 2 == 0) {
                    f = 1;
                } else {
                    f = 0;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Paritypermutation here = new Paritypermutation();
        int[] in = {1,2,3,4,5};
        System.out.println(here.pp(in));
    }

}
