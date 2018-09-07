package liusiming;

import java.util.Arrays;

public class q1 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int[] dp1 = new int[A.length];
        dp1[0] = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dp1[i]  = dp1[i - 1] + A[i - 1] - A[i];
            } else {
                dp1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(dp1));
        int[] dp2 = new int[A.length];
        dp2[A.length - 1] = 0;

        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] < A[i + 1]) {
                dp2[i] = dp2[i + 1] + A[i + 1] - A[i];
            } else {
                dp2[i] = 0;
            }
        }
        System.out.println(Arrays.toString(dp2));
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (dp1[i] > 0 && dp2[i] > 0) {
                res = Math.max(res, Math.min(dp1[i], dp2[i]));
            }
        }
        if (res == Integer.MIN_VALUE) return -1;
        return res;
    }

    public static void main(String[] args) {
        //int[] input= {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
        int[] input= {3 , -1, -2, 5};
        q1 here = new q1();

        System.out.println(here.solution(input));
    }
}
