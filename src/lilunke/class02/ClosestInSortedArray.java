package lilunke.class02;

public class ClosestInSortedArray {
    public int closest(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        if (target - array[left] <= array[right] - target) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        ClosestInSortedArray here = new ClosestInSortedArray();
        int[] array = {1, 4, 4, 5, 6, 7, 8, 11, 11};
        System.out.println(here.closest(array, 9));
    }
}
