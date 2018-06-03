package leetcode;

import java.util.HashMap;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        // dynamically maintain the map to keep the number of specific character to determine if the character match.
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        // use two pointer to record the current window, and minLeft and minLen to record the current result
        int left = 0, minLeft = 0, minLen = s.length() + 1, count = 0;
        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                map.put(r, map.get(r) - 1);
                if (map.get(r) >= 0) {
                    count++;
                }
            }
            while (count == t.length()) {
                // need to update
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        System.out.println(minLeft);
        System.out.println(minLen);
        System.out.println(left);
        return minLen == s.length() + 1 ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring76 here = new MinimumWindowSubstring76();
        System.out.println(here.minWindow("adobecodebancbbcaa", "abc"));
    }
}
