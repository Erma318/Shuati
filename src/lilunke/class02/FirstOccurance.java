package lilunke.class02;

public class FirstOccurance {
    public int firstOccur(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }

        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }
//    public int firstOccur(int[] array, int target) {
//        if (array == null || array.length == 0) {
//            return -1;
//        }
//        int left = 0;
//        int right = array.length - 1;
//        while(left < right - 1) {
//            int mid = left + (right - left) / 2;
//            if (array[mid] >= target) {
//                right = mid;
//            } else {
//                left = mid;
//            }
//        }
//        if (array[left] == target) {
//            return left;
//        } else if (array[right] == target) {
//            return right;
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        FirstOccurance here = new FirstOccurance();
        int[] array = {1, 4, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(here.firstOccur(array, 10));
    }
}
