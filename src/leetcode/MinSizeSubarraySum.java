package leetcode;

public class MinSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //[i, j]
        int i = 0; int j = 0;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (sum >= s && i <= j) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
            } else {
                j++;
                if (j == nums.length)
                    break;
                sum += nums[j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinSizeSubarraySum here = new MinSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(here.minSubArrayLen(7, nums));

    }
}
