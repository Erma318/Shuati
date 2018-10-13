package lilunke.class02;

public class LastOccurance {
    public int lastOccur(int[] array, int target) {
        // Write your removeCho2 here
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if ( array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        LastOccurance here = new LastOccurance();
        int[] array = {1, 4, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(here.lastOccur(array, 4));
    }
}
