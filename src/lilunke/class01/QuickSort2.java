package lilunke.class01;

import java.util.Arrays;

public class QuickSort2 {
    public static void main (String[] args) {
        int[] array = new int[0];
        QuickSort2 here = new QuickSort2();
        System.out.println(Arrays.toString(here.quickSort(array)));
    }
    public int[] quickSort(int[] array) {
        // Write your solution here
        if(array == null || array.length == 0) {
            return array;
        }
        int s = 0;
        int t = array.length - 1;
        quickHelper(array, s, t);
        return array;
    }

    private static void quickHelper(int[] array, int s, int t) {
        if (s >= t) {
            return;
        }
        int m = s + (t - s) / 2;
        int p = array[m];
        swap(array, t, m);
        int i = s;
        int j = t - 1;
        while (i <= j) {
            if (array[i] < p) {
                i++;
            } else if (array[j] >= p) {
                j--;
            } else {
                swap(array, i++, j--);
            }
//            if (array[i] > p) {
//                swap(array, i, j);
//                j--;
//            }  else {
//                i++;
//            }
        }
        swap(array, i, t);
        quickHelper(array, s, i - 1);
        quickHelper(array, i + 1, t);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
