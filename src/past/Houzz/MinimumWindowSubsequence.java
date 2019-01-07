package past.Houzz;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int[][] m = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++) {
            m[i][0] = i;
        }
        for (int i = 0; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                m[i][j] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= Math.min(i, T.length()); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j - 1];
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
            if (m[i][T.length()] != -1) {
                int len = i - m[i][T.length()];
                if (len < min) {
                    min = len;
                    start = m[i][T.length()];
                }
            }
        }
        if (start == -1) {
            return "";
        } else {
            return S.substring(start, start + min);
        }
    }

    public static void main(String[] args) {
        MinimumWindowSubsequence here = new MinimumWindowSubsequence();
        System.out.println(here.minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl","u"));
    }
}