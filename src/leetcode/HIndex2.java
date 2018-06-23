package leetcode;

public class HIndex2 {
    public int hIndex(int[] c) {
        int n = c.length;
        int s = 0, e = n - 1;
        while(s < e){
            int m = (s + e) / 2;
            if(c[m] < n - m){
                s = m + 1;
            } else {
                e = m;
            }
        }

        if(s < n && c[s] >= n - s) return n - s;
        else return 0;
    }

    public static void main(String[] args) {
        HIndex2 here = new HIndex2();
        int[] citations = {};
        System.out.println(here.hIndex(citations));
    }

}
