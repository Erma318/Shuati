package past.bloomberg;

public class matrixGoSumMax {
    public int findMax(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        int[][] m = new int[r][c];
        for (int j = 0; j < c; j++) {
            m[r - 1][j] = M[r - 1][j];
        }
        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                int x = Integer.MIN_VALUE;
                int y = m[i + 1][j];
                int z = Integer.MIN_VALUE;
                if (j - 1 >= 0) {
                    x = m[i + 1][j - 1];
                }
                if (j + 1 < c) {
                    z = m[i + 1][j + 1];
                }
                m[i][j] = M[i][j] + Math.max(Math.max(x, y), z);
            }
        }
        int res = Integer.MIN_VALUE;
        for (int j = 0;j < c; j++) {
            res = Math.max(res, m[0][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        matrixGoSumMax here = new matrixGoSumMax();
        int[][] M = {
                {2,3,4,5},
                {5,4,3,2},
                {1,6,5,3},
                {2,6,7,8}
        };
        System.out.println(here.findMax(M));
    }
}
