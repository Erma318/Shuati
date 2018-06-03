package lilunke.class06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllSubsets {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        int level = 0;
        StringBuilder sb = new StringBuilder();
        char[] charSet = set.toCharArray();
        subSets(charSet, res, level, sb);
        return res;
    }

    private void subSets(char[] set, List res, int level, StringBuilder sb) {
        if (level == set.length) {
            res.add(sb.toString());
            return;
        }

        //case1: add the letter
//        sb.append(set[level]);
//        level++;
//        subSets(set, res, level, sb);
//        sb.deleteCharAt(sb.length() - 1);
//        level--;
        subSets(set, res, level + 1, sb.append(set[level]));
        sb.deleteCharAt(sb.length() - 1);

        //case2: done't add the letter
//        level++;
//        subSets(set, res, level, sb);
//        level--;
        subSets(set, res, level + 1, sb);
    }

    public static void main(String[] args) {
        String set = "abc";
        AllSubsets here = new AllSubsets();
        List<String> res = here.subSets(set);
        System.out.println(res);
    }
}
