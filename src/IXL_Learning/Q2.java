package IXL_Learning;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Q2 {

    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. STRING_ARRAY a
     * 2. STRING_ARRAY b
     */

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
    // Write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            res.add(helper(a.get(i),b.get(i)));
        }
        return res;
    }

    private static int helper(String a, String b) {
        if (a.length() != b.length()) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    count++;
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return b.length() - count;
    }

    public static void main(String x) {

    }
}