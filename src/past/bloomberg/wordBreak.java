package past.bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class wordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        helper(s, wordDict, 0, sb, res);
        return res;
    }

    private void helper(String s, List<String> wordDict, int index, StringBuilder sb, List<String> res) {
        if (index == s.length()) {
            res.add(sb.toString().trim());
            sb.delete(0, sb.length());
            return;
        }
        for (String x : wordDict) {
            if (index + x.length() <= s.length()) {
                if (s.substring(index, index + x.length()).equals(x)) {
                    sb.append(" ");
                    sb.append(x);
                    helper(s, wordDict, index + x.length(), sb, res);
                }
            }

        }
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> word = new ArrayList<>(Arrays.asList("apple","pen","applepen","pine","pineapple"));
        wordBreak here = new wordBreak();
        System.out.println(here.wordBreak(s, word));
    }
}
