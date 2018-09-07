package liusiming;

import java.util.Arrays;

public class q2 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            sum[i] = sum[i - 1] + A[i];
        }

        Arrays.sort(sum);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length - 1; i++) {
            res = Math.min(Math.abs(sum[i + 1] - sum[i]), res);
        }
        for (int i = 0; i < A.length; i++) {
            res = Math.min(A[i], res);
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] input= {2, -4, 6, -3, 1, 9};
        int[] input= {2, 3};
        q2 here = new q2();

        System.out.println(here.solution(input));
    }
}
