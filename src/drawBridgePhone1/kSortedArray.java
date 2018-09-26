package drawBridgePhone1;

public class kSortedArray {
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int j = i - 1;
            while ( j >= 0 && nums[j] > t) {
                nums[i] = nums[j];
                nums[j] = t;
                j--;
                i--;
            }
        }
    }
}
