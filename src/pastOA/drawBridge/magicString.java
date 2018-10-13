package pastOA.drawBridge;

public class magicString {
    public int magic(int n) {
        int[] a = new int[n + 1];
        int[] e = new int[n + 1];
        int[] i = new int[n + 1];
        int[] o = new int[n + 1];
        int[] u = new int[n + 1];
        a[0] = 1; e[0] = 1; i[0] = 1; o[0] = 1; u[0] = 1;
        for (int k = 1; k <= n; k++) {
            a[k] = e[k - 1];
            e[k] = a[k - 1] + i[k  - 1];
            i[k] = a[k - 1] + e[k - 1] + o[k - 1] + u[k - 1];
            o[k] = i[k - 1] + u[k - 1];
            u[k] = a[k - 1];
        }
        return a[n] + e[n] + i[n] + o[n] + u[n];

    }
}
