package lilunke.class07;

public class DetermineIfOneStringIsAnothersSubstring {
    public int strstr(String large, String small) {
        // write your solution here
        if (small.length() == 0) {
            return 0;
        }
        if (small.length() > large.length()) {
            return -1;
        }
        char[] lc = large.toCharArray();
        char[] sc = small.toCharArray();

        int s = 0;
        for (int i = 0; i < sc.length; i++) {
            s = s + (int)((sc[i] - 'a') * Math.pow(26, sc.length - 1 -i));
        }
        int l = 0;
        for (int i = 0; i < sc.length; i++) {
            l = l + (int)((lc[i] - 'a') * Math.pow(26, sc.length - 1 -i));
        }
        if (l == s) {
            if (doubleCheck(lc, 0, sc)) {
                return 0;
            }
        }
        for(int i = 1; i < lc.length - sc.length + 1; i++) {
            l = 26 * (l - (int)((lc[i - 1] - 'a') * Math.pow(26, sc.length - 1))) + (int)((lc[i + sc.length - 1] - 'a'));
            if (l == s) {
                if (doubleCheck(lc, i, sc)) {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean doubleCheck(char[] lc, int i, char[] sc) {
        for (int j = 0; j < sc.length; j++) {
            if (sc[j] != lc[j + i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineIfOneStringIsAnothersSubstring here = new DetermineIfOneStringIsAnothersSubstring();
        int res= here.strstr("abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu", "qrstuvwxyzzabcdefghijklmnopqrstu");
        System.out.println(res);
    }
}
