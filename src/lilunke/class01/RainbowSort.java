package lilunke.class01;

import java.util.Arrays;

public class RainbowSort {
    public static void main(String[] arags) {
        int[] array = {1, -1, 0, 0, 1, -1, 0, -1};
        RainbowSort here = new RainbowSort();
        System.out.println(Arrays.toString(here.rainbowSort(array)));
    }

    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        int i = 0;
        int j = 0;
        int k = array.length - 1;

        while (j <= k) {
            if (array[j] == -1) {
                swap (array, i, j);
                i++;
                j++;
            } else if (array[j] == 0) {
                j++;
            } else {
                swap (array, j, k);
                k--;
            }
        }
        return array;
    }

    private static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
