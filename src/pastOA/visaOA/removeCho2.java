package pastOA.visaOA;

public class removeCho2 {    public static int numberOfWays(int n) {
    long[][] q = {{1,1, 0},{0,0,1}, {1, 0,0}};
    long[][] res = pow(q, n);
    return (int) (res[0][0] % 1000000007);
}
    public static long[][] pow(long[][] a, int n) {
        long[][] ret = {{1, 0,0}, {0, 1,0},{0,0,1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c[i][j] = (a[i][0] * b[0][j]) % 1000000007 + (a[i][1] * b[1][j])% 1000000007 + (a[i][2]*b[2][j])  % 1000000007;
            }
        }
        return c;
    }
}
