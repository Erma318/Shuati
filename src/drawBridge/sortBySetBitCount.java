package drawBridge;

import java.util.Arrays;
import java.util.Comparator;

public class sortBySetBitCount {
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }

    public Integer[] sort(Integer[] input) {
        Arrays.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (countSetBits(a) > countSetBits(b)) return -1;
                else if (countSetBits(a) < countSetBits(b)) return 1;
                else return 0;
            }
        });
        return input;
    }

    public static void main(String[] args) {
        Integer[] input = {5, 2, 3, 9, 4, 6, 7, 15, 32};
        sortBySetBitCount here = new sortBySetBitCount();
        System.out.println(Arrays.toString(here.sort(input)));
    }


}
