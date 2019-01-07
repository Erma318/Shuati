package pastOA.f5tech;

import java.util.HashMap;
import java.util.Map;

public class q4 {
    static boolean containsSameLetters(String word1, String word2) {
        //Stripe.Solution:
        //1. use a hashmap to count the times of each char occurs in word1
        //2. go through each character in word2, if it is not in word1, ignore it.
        //If it is, decrease the time of occurrence by 1 in map
        //count is the size of the hashmap
        //when the time of occurrence become 0, we find one letter in word1 that all appears in word2, count minus 1
        //If count is 0, it means we find all the letters in word1 is found word2 return true;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = map.size();
        for (char c : word2.toCharArray()) {
            if (!map.containsKey(c)) continue;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) count--;
        }
        return count == 0;
    }
    // time complexity is O(max(len of word1, lenof word2))
    // space complexity is O(length of word1)
}
