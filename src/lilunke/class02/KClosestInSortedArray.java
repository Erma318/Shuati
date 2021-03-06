package lilunke.class02;

import java.util.Arrays;

public class KClosestInSortedArray {
    public static void main(String[] args) {
        int[] array = {1, 4, 4, 5, 6, 7, 8, 9, 10};
        KClosestInSortedArray here = new KClosestInSortedArray();
        System.out.println(Arrays.toString(here.kClosest(array, 7, 3)));
    }
    public int[] kClosest(int[] array, int target, int k) {
        if (array.length == 0) {
            return new int[0];
        }
        if (k == 0) {
            return new int[0];
        }
        // Write your removeCho2 here
        int[] res = new int[k];
        int left = largestSmallerOrEqual(array, target);
        int right = left + 1;
        for (int i = 0; i < k; i++) {
            if (right >= array.length || left >=0 && target - array[left] <= array[right] - target) {
                res[i] = array[left];
                left--;
            } else {
                res[i] = array[right];
                right++;
            }
        }
        return res;
    }

    private int largestSmallerOrEqual(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        if (array[right] <= target) {
            return right;
        }
        if (array[left] <= target) {
            return left;
        }
        return -1;
    }
}
