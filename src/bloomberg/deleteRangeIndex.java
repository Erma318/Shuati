package bloomberg;

import java.util.Arrays;

public class deleteRangeIndex {
    static class range {
        int start;
        int end;
        range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
// assume there is no overlapping between the ranges
    public int[] delete(int[] array, range[] index) {
        int i = 0; // index smaller than i is keep
         // index start from j is what we will need to scan
        int t = 0;
        int start = index[t].start - 1;
        int end = index[t].end - 1;
        for (int j = 0; j < array.length; j++) {
            if (!(start <= j && j < end)) {
                array[i++] = array[j];
            }
            if (j == end) {
                if (t + 1< index.length) {
                    t++;
                }
                start = index[t].start - 1;
                end = index[t].end - 1;
            }
        }
        return Arrays.copyOfRange(array, 0, i);
    }

    public static void main(String[] args) {
        deleteRangeIndex here = new deleteRangeIndex();
        int[] array = {1,3, 4,69, -1, 2, 5,6};
        range[] index = {new range(2,4), new range(5,6)};
        System.out.println(Arrays.toString(here.delete(array, index)));

    }
}
