package lilunke.class15;

public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        // Write your removeCho2 here
        int row = matrix.length;
        int column = matrix[0].length;
        if (row == 0 || column == 0) {
            return 0;
        }

        int[][] top = new int[row][column];
        int[][] bottom = new int[row][column];
        int[][] left = new int[row][column];
        int[][] right = new int[row][column];
        // from top to bottom
        for (int j = 0; j < column; j++) {
            top[0][j] = matrix[0][j];
            for (int i = 1; i < row; i++) {
                if (matrix[i][j] == 1) {
                    top[i][j] = top[i - 1][j] + 1;
                } else {
                    top[i][j] = 0;
                }
            }
        }
        // from bottom to top
        for (int j = 0; j < column; j++) {
            bottom[row - 1][j] = matrix[row - 1][j];
            for (int i = row - 2; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    bottom[i][j] = bottom[i + 1][j] + 1;
                } else {
                    bottom[i][j] = 0;
                }
            }
        }
        //from left to right
        for (int i = 0; i <row; i++) {
            left[i][0] = matrix[i][0];
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                } else {
                    left[i][j] = 0;
                }
            }
        }
        //from right to left
        for (int i = 0; i < row; i++) {
            right[i][column - 1] = matrix[i][column - 1];
            for (int j = column - 2; j >= 0 ; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                } else {
                    right[i][j] = 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = Math.min(top[i][j], bottom[i][j]);
                temp = Math.min(temp, left[i][j]);
                temp = Math.min(temp, right[i][j]);
                res = Math.max(temp, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestCrossOf1s here = new LongestCrossOf1s();
        int[][] input = {
                {0,1,0,0},
                {1,1,1,1},
                {0,1,0,0},
                {0,1,0,0}
        };
        System.out.println(here.largest(input));
    }
}
