package pastOA.twitter;

import java.util.*;

public class q2 {
    // Complete the electionWinner function below.
    static String electionWinner(String[] votes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String v : votes) {
            if (map.containsKey(v)) {
                map.put(v, map.get(v) + 1);
            } else {
                map.put(v, 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer i : map.values()) {
            max = Math.max(i , max);
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                res.add(s);
            }
        }
        Collections.sort(res);
        return res.get(res.size() - 1);
    }
}
