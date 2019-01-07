package past.Houzz;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        reverse(nums, i - 1);
                        return;
                    }
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i) { // reserve all the element after i (not include i)
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        NextPermutation here = new NextPermutation();
        here.nextPermutation(nums);
        System.out.println(nums);
    }
}
