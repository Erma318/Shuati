package past.drawBridgePhone2;

import java.util.Arrays;

public class missingNum {
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) { //binary search
        Arrays.sort(nums);
        int left = 0, right = nums.length; // key point, use nums.length
        while(left<right){
            int mid = (left + right)/2;
            if(nums[mid]>mid) right = mid;
            else left = mid+1;
        }
        return left;
    }
}
