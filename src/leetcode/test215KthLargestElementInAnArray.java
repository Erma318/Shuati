package leetcode;

public class test215KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
//		if(nums == null || nums.length == 0) return null;
		int m =nums.length-k;//kth smallest index
		int p = quickSort(nums,0, nums.length - 1, m);
		return nums[p];
    }

	private int quickSort(int[] nums, int lb, int ub, int m) {//mth smallest
		int pivotIndex = lb + (int)(Math.random()*(ub - lb + 1));//randomly picked index
		int leftBound = lb;
		int rightBound = ub-1;
		swap(nums, pivotIndex, ub);
		while(leftBound <= rightBound){
			if(nums[leftBound] < nums[ub]){
				leftBound++;
			}else if(nums[rightBound] >= nums[ub]){
				rightBound--;
			}else{
				swap(nums, leftBound++, rightBound--);
			}
		}
		swap(nums, leftBound, ub);

		//int z = leftBound-lb+1;//how many numbers on the left part of leftBound including leftBound
		if(m == leftBound){
			return leftBound;
		}else if(m < leftBound){
			return quickSort(nums, lb, leftBound-1, m);
		}else{
			return quickSort(nums, leftBound+1, ub, m);
		}
	}

	private void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		test215KthLargestElementInAnArray machine = new test215KthLargestElementInAnArray();
		int[] a = {2,1,3,4};
		System.out.println(machine.findKthLargest(a,2));
	}
}
