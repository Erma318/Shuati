package past.Capitalogix;

import java.util.Arrays;

public class maxSub {
    public int[] lSub(int[] nums){
        if (nums == null || nums.length == 0) {
            return null;
        }
        int maxSub = 0;
        int maxNum = nums[0];
        int tempSub = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                res[i] = maxSub;
            } else {
                tempSub = maxNum - nums[i];
                maxSub = Math.max(maxSub, tempSub);
                res[i] = maxSub;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        int[] input= {1, 2, 3, 2, -1, 1, 3, -1};
        maxSub here = new maxSub();
        int[] res = here.lSub(input);
        System.out.println(Arrays.toString(res));

    }

}
