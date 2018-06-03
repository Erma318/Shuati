package lilunke.class07;

import java.util.HashSet;

public class MissingNumber {
    public int missing(int[] array) {
        HashSet<Integer> dict = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            dict.add(array[i]);
        }
        for (int i = 1; i <= array.length + 1; i++) {
            if (!dict.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MissingNumber here = new MissingNumber();
        int[] array = {1, 2, 4};
        System.out.println(here.missing(array));
    }
}
