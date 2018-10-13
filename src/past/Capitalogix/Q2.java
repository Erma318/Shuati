package past.Capitalogix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q2 {

    public static Answer find(List<int[]> input) {
        int n = 10;
        Answer res = new Answer();
        int global = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            for (int j = i; j < input.size(); j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += input.get(i)[k] ^ input.get(j)[k];
                }
                if (sum > global) {
                    global = sum;
                    res.worker1 = input.get(i);
                    res.worker2 = input.get(j);
                }
            }
        }
        return res;
    }

    public static class Answer {
        int[] worker1;
        int[] worker2;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<int[]> in = new LinkedList<int[]>();
        int[] one = {1,0,1,0,1,0,1,0,1,0};
        int[] two = {1,1,1,1,1,1,1,1,1,1};
        int[] three = {0,1,0,1,0,1,0,1,0,1};
        int[] four = {1,0,0,1,0,0,1,0,0,1};
        in.add(one);
        in.add(two);
        in.add(three);
        in.add(four);
        System.out.print(Arrays.toString(find(in).worker1));
        System.out.print(Arrays.toString(find(in).worker2));
    }

}