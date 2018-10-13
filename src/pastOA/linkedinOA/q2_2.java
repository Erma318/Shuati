package pastOA.linkedinOA;

import java.util.Arrays;

public class q2_2 {
    public static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        int[] res = new int[maxes.length];
        int idx = 0;
        while (idx < maxes.length) {
            int index = search(nums, maxes[idx]);
            res[idx++] = index + 1;
        }
        return res;
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target){
                return mid;
            } else {
                left = mid;
            }
        }
        if (nums[right] <= target) {
            return right;
        } else if (nums[left] <= target){
            return left;
        }
        return -1;
    }
    public static void main(String[] args) {
        q2_2 here = new q2_2();
        int[] n = {2
                ,10
                ,5
                ,4
                ,8};
        int[] m = {3,1,7,8};
        System.out.println(Arrays.toString(here.counts(n, m)));
    }
}
