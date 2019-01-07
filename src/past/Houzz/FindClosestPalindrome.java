package past.Houzz;

import java.util.Arrays;

public class FindClosestPalindrome {

    public Long findHigherPalindrome(Long limit) {
        String n = String.valueOf(limit);
        char[] s = n.toCharArray();
        char[] t = n.toCharArray();
        for (int i = (t.length - 1) / 2; i >= 0; i--) {
            t[t.length - 1 - i] = t[i];
        } // create the standard palindrom
        for (int i = 0; i < s.length; i++) {
            if (t[i] > s[i]) {
                return Long.valueOf(new String(t));
            } else if (t[i] < s[i]){
                for (int j = (t.length - 1) / 2; j >= 0; j--) {
                    if (++t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                for (int m = (t.length - 1) / 2; m >= 0; m--) {
                    t[t.length - 1 - m] = t[m];
                }
                return Long.valueOf(new String(t));
            }
        }
        return Long.valueOf(new String(t));
    }
    public Long findLowerPalindrome(Long limit) {
        String n = String.valueOf(limit);
        char[] s = n.toCharArray();
        char[] t = n.toCharArray();
        for (int i = (t.length - 1) / 2; i >= 0; i--) {
            t[t.length - 1 - i] = t[i];
        }
        for (int i = 0; i < s.length; i++) {
            if (t[i] < s[i]) {
                return Long.valueOf(new String(t));
            } else if (t[i] > s[i]){
                for (int j = (t.length - 1) / 2; j >= 0; j--) {
                    if (--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                if (t[0] == '0') {
                    char[] newt= new char[t.length - 1];
                    Arrays.fill(newt, '9');
                    return Long.valueOf(new String(newt));
                }
                for (int m = (t.length - 1) / 2; m >= 0; m--) {
                    t[t.length - 1 - m] = t[m];
                }
                return Long.valueOf(new String(t));
            }
        }
        return Long.valueOf(new String(t));
    }

    public String nearestPalindromic(String n) {
        Long number = Long.parseLong(n);
        Long big = findHigherPalindrome(number + 1);
        Long small = findLowerPalindrome(number - 1);
        return Math.abs(number - small) > Math.abs(big - number) ? String.valueOf(big) : String.valueOf(small);
    }
    public static void main(String[] args) {
        FindClosestPalindrome here = new FindClosestPalindrome();
        String input = "1";
        System.out.println(here.nearestPalindromic(input));
    }
}
