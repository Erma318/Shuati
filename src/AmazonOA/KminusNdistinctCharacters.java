package AmazonOA;

import java.util.*;

public class KminusNdistinctCharacters {
    public List<String> find(String input, int k, int n) {
        List<String> res = new ArrayList<>();
        Set<Character> notDistinct = new HashSet<>();
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < k; i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }
        if (map.size() == k - n) {
            res.add(input.substring(0, k));
        }
        for (int i = k; i < input.length(); i++) {
            // add i, remove i - k
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
            map.put(input.charAt(i - k), map.getOrDefault(input.charAt(i - k), 1) - 1);

            if (map.get(input.charAt(i - k)) == 0) {
                map.remove(input.charAt(i - k));
            }

            if (map.size() == k - n) {
                res.add(input.substring(i - k + 1, i + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KminusNdistinctCharacters here = new KminusNdistinctCharacters();
        System.out.println(here.find("abbccskuarfliwehfasef", 3, 1));

    }
}
