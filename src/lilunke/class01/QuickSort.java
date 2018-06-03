package lilunke.class01;

import java.util.Arrays;

public class QuickSort {
    public static void main (String[] args) {
        int[] array = {1, 2, 3};
        QuickSort here = new QuickSort();
        here.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = random(left, right);
        int p = array[pivot];
        swap(array, pivot, right);
        int i = left;
        int j = right - 1;
        while (i <= j) {
            if (array[i] < p) {
                i++;
            } else  if (array[j] >= p) {
                j--;
            } else {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, i, right);
        return i;
    }

    private static void swap (int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int random(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }
}
