package pastOA.drawBridge;

import java.util.*;

public class minAbsList {
    public int minAbs(List<Integer> input, int k) {
        Collections.sort(input);
        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < input.size() - 1; i++) {
            minGap = Math.min(minGap, input.get(i + 1) - input.get(i));
        }
        int[] res = new int[6]; // prev, cur, res, minGapInSub, length, index
                                //    0    1    2       3          4       5
        res[3] = Integer.MAX_VALUE;
        subMinGap(input, k, res, minGap);
        return res[2];
    }

    private static void subMinGap(List<Integer> input, int k, int[] res, int minGap) {
//        if (res[3] == minGap) {
//            return;
//        }
        if (res[5] == input.size()) {
            if (res[4] == k) {
                res[2] = Math.max(res[2], res[3]);
            }
            return;
        }
        // update minGapInSub
        if (res[4] > 1) {
            res[3] = Math.min((res[1] - res[0]), res[3]);
        }
        // add
        int temp = res[0];
        res[0] = res[1];
        res[1] = input.get(res[5]);
        res[4]++;
        res[5]++;
        int temp2= res[3];
        // update minGapInSub
        if (res[4] > 1) {
            res[3] = Math.min((res[1] - res[0]), res[3]);
        }
        subMinGap(input, k, res, minGap);
        res[3] = temp2;
        res[4]--;
        res[5]--;
        res[1] = res[0];
        res[0] = temp;

        // not add
        res[5]++;
        subMinGap(input, k, res, minGap);
        res[5]--;
    }

    public List<List<Integer>> subSet(List<Integer> input, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        subSet(input, k, temp, res, 0);
        return res;
    }

    private static void subSet(List<Integer> input, int k, List<Integer> temp, List<List<Integer>> res, int index) {
        if (index == input.size()) {
            if (temp.size() == k) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        // add
        temp.add(input.get(index));
        subSet(input, k, temp, res, index+1);
        temp.remove(temp.size() - 1);
        // not add
        subSet(input,k, temp, res, index+1);
    }

    public static void main(String[] args) {
        minAbsList here = new minAbsList();
        List<Integer> input = Arrays.asList(1, 2, 3, 5, 7);
        System.out.println(here.subSet(input, 4));
        long start = System.currentTimeMillis( );
        System.out.println(here.minAbs(input, 4));
        long end = System.currentTimeMillis( );
        long diff = end - start;
        System.out.println("Difference is : " + diff);
    }
}
