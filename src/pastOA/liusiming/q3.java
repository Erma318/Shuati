package pastOA.liusiming;

import java.util.Arrays;

public class q3 {
    /*public int removeCho2(int[] A, int[] B) {
        // write your code in Java SE 8
        double[] C = new double[A.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i] + (double) B[i] / 1000000;
        }
        System.out.println(Arrays.toString(C));
        Arrays.sort(C);
        int res = 0;
        int length = C.length;
        if (length > 1) {
            int l = 0;
            int h = length - 1;
            for (; l < length; l++) {
                if (C[l] > 1) {
                    break;
                }

            }
            for (; h >= 0; h--) {
                if (h > l) {
                    while (l < h && C[h] < (C[l] / (C[l] - 1))) {
                        l++;
                    }
                    if (l == h) {
                        break;
                    }
                    res += (h - l);
                }
            }
        }
        return res;
    }*/

        public int solution(int[] A, int[] B) {
            // write your code in Java SE 8
            if (A.length <= 1 || B.length <= 1 || A.length != B.length) {
                return 0;
            }

            double[] C = new double[A.length];
            for (int i = 0; i < A.length; i++) {
                C[i] = A[i] + (double) B[i] / 1000000;
            }
            Arrays.sort(C);

            int res = 0;
            int length = C.length;

            int l = 0, h = length - 1;
            while (l < length && C[l] <= 1) {
                l++;
            }
            while (h > l) {
                while (l < h && C[h] < (C[l] / (C[l] - 1))) {
                    l++;
                }
                if (h > l) {
                    res += (h - l);
                }
                h--;
            }
            return res;
        }

    public static void main(String[] args) {
//        int[] input1= {0, 1, 2, 2, 3, 5};
//        int[] input2= {500000, 500000, 0, 0, 0, 20000};
        int[] input1= {20, 1, 5};
        int[] input2= {500000, 400000, 300000};
        q3 here = new q3();

        System.out.println(here.solution(input1, input2));
    }
}
