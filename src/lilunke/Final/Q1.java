package lilunke.Final;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public List<String> permutation(String input) {
        char[] mychar = input.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(mychar[0]);
        helper(mychar, 0, sb, res);
        return res;
    }

    private void helper(char[] mychar, int index, StringBuilder sb, List<String> res) {
        if (index == mychar.length - 1) {
            res.add(sb.toString());
            return;
        }
        // no space
        sb.append(mychar[index + 1]);
        helper(mychar, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        // have the space
        sb.append(" ");
        sb.append(mychar[index + 1]);
        helper(mychar, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main (String[] args) {
        Q1 here = new Q1();
        System.out.println(here.permutation("ABC"));

    }

}
