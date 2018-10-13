package pastOA.visaOA;

import java.util.*;

public class DistinctPair {
//    public static List<List<Integer>> twoSum(int[] numbers, int target) {
////        List<List<Integer>>  res = new LinkedList<>();
////        HashSet<List<Integer>> set = new HashSet();
////        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
////        for (int i = 0; i < numbers.length; i++) {
////            if (map.containsKey(target - numbers[i])) {
////                List<Integer> temp = new LinkedList<>();
////                int a = Math.min(i, map.get(target - numbers[i]));
////                int b = Math.max(i, map.get(target - numbers[i]));
////                temp.add(numbers[a]);
////                temp.add(numbers[b]);
////                if (!set.contains(temp)) {
////                    set.add(temp);
////                    res.add(temp);
////                }
////            }
////            map.put(numbers[i], i);
////        }
////        return res;
////    }

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int i = 0;
        int j = nums.length - 1;
        int pi = 0;
        int pj = 0;
        while (j > i) {
            if (nums[i] == pi) {
                i++;
            }
            if (nums[j] == pj) {
                j--;
                continue;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] == target) {
                List<Integer> temp = new LinkedList<>();
                pi = nums[i];
                pj = nums[j];
                temp.add(nums[i]);
                temp.add(nums[j]);
                res.add(temp);
                i++;
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] twoSum = {1,2,3,6,2,7,8,9,9,9,1,1,1,2,2};
        System.out.println(twoSum(twoSum, 4));
    }
}
