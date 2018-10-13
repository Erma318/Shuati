package lilunke.class01;

import java.util.Arrays;

public class ArrayShuffling{
    public static void main(String[] arags) {
        int[] array = {1, -1, 0, 0, 1, -1, 0, -1};
        ArrayShuffling here = new ArrayShuffling();
        System.out.println(Arrays.toString(here.moveZero(array)));
    }
    public int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <=right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap (array, left++, right--);
            }
        }
        return array;
    }
//    public int[] moveZero(int[] array) {
//        // Write your removeCho2 here.
//        int i = 0;
//        int j= array.length - 1;
//        while (i <= j) {
//            if (array[i] == 0) {
//                swap (array, i , j);
//                j--;
//            } else {
//                i++;
//            }
//        }
//        return array;
//    }

    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}