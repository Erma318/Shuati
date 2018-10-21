package bnyOA;

public class NumOfPathsinMatrix {
    public int find(String[] in) {
        int r = in.length;
        int c = in[0].length();
        int[][] m = new int[r][c];
        m[0][0] = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (in[i].charAt(j) == '1') {
                    if (i - 1 >= 0) {
                        m[i][j] += m[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        m[i][j] += m[i][j - 1];
                    }
                    m[i][j] %= (1000000000 + 7);
                }
            }
        }
        return m[r - 1][c - 1];
    }

    public static void main(String[] args){
        NumOfPathsinMatrix here = new NumOfPathsinMatrix();
        String[] in = {
                "1111",
                "1111",
                "1111"
        };
        System.out.println(here.find(in));
    }
}
