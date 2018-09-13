package f5tech;

import java.util.LinkedList;
import java.util.List;

public class q5 {
    static List<String> anagrams(String prefix, String word, List<String> returnVal) {
        if (word.length() == 2) {
            returnVal.add(prefix + word.substring(1) + word.substring(0, 1));
            returnVal.add(prefix + word);
            return returnVal;
        }
        for (int i = 0; i < word.length(); i++) {
            anagrams(prefix + word.substring(i, i + 1),
                    new StringBuilder(word).deleteCharAt(i).toString(), returnVal);
        }
        return returnVal;
    }
    public static void main(String[] args) {
        String prefix = "";
        String word = "abca";
        List<String> res  = new LinkedList<>();
        q5 here = new q5();
        here.anagrams(prefix, word, res);
        System.out.println(res);
    }
}
