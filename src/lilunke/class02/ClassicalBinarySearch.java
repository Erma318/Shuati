package lilunke.class02;

public class ClassicalBinarySearch {
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

//    public int binarySearch(int[] array, int target) {
//        // Write your removeCho2 here.
//        if (array == null || array.length == 0) {
//            return -1;
//        }
//        return helper(array, target, 0, array.length - 1);
//    }
//
//    private static int helper(int[] array, int target, int l, int r) {
//        if (l > r) {
//            return -1;
//        }
//        int mid = l + (r - l) / 2;
//        if (array[mid] == target) {
//            return mid;
//        } else if (array[mid] > target) {
//            return helper(array, target, l, mid - 1);
//        } else {
//            return helper(array, target, mid + 1, r);
//        }
//    }

    public static void main(String[] args) {
        ClassicalBinarySearch here = new ClassicalBinarySearch();
        int[] array = {1, 4, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(here.binarySearch(array, 4));
    }
}
