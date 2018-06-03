package lilunke.class02;

import java.util.Arrays;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,5,6,7},{7,7,9,10}};
        SearchInSortedMatrix here = new SearchInSortedMatrix();
        System.out.println(Arrays.toString(here.search(matrix, 7)));
    }
    public int[] search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        // Write your solution here.
        int i = 0;
        int j = matrix[0].length - 1;
        while (j >= 0 && i <= matrix.length -1) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                return new int[] {i, j};
            }
        }
        return new int[] {-1, -1};
    }
}
