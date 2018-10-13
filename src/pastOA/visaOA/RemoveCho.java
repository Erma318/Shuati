package pastOA.visaOA;

public class RemoveCho {
    public static int numberOfWays(int n) {
        if (n < 3) {
            return 1;
        }
        int[] m = new int[n + 1];
        m[0] = 1;
        m[1] = 1;
        m[2] = 1;
        for (int i = 3; i <= n; i++) {
            m[i] = m[i - 1] + m[i - 3];
        }
        return m[n] % (1000000007);
    }

//    public static int climbStairs(int target){
//        if(target < 1){
//            return 0;
//        }
//        if (target == 1 || target == 2){
//            return target;
//        }
//        int[][] matrix = {{1, 1},{1, 0}};
//        int[][] res = matrixPow(matrix, target - 2);
//        //别忘记乘以最开始的f(2) 与 f(1)
//        return res[0][0] * 2 + res[1][0] * 1;
//    }
//
//    //计算矩阵 n 次方
//    public static int[][] matrixPow(int[][] matrix, int n){
//        int r = matrix.length;
//        int c = matrix[0].length;
//        int[][] res = new int[r][c];
//        //单位矩阵
//        for (int i = 0; i < r; i++){
//            res[i][i] = 1;
//        }
//        int[][] placeHolder = matrix;
//        for(; n > 0; n >>>= 1){
//            if ((n & 1)  == 1){
//                res = matrixMulti(res, placeHolder);
//            }
//            placeHolder = matrixMulti(placeHolder, placeHolder);
//        }
//        return res;
//    }
//
//    //计算两矩阵相乘
//    public static int[][] matrixMulti(int[][] m1, int[][] m2){
//        int m1Row = m1.length;
//        int m1Col = m1[0].length;
//        int m2Col = m2[0].length;
//        int[][] res = new int[m1Row][m2Col];
//        for (int i = 0; i < m1Row; i++){
//            for (int k = 0; k < m1Col; k++){
//                if (m1[i][k] != 0){
//                    for (int j = 0; j < m2Col; j++){
//                        if(m2[k][j] != 0){
//                            res[i][j] += m1[i][k] + m2[k][j];
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }



    public static void main(String[] args) {
        System.out.println(numberOfWays(9));
    }
}
