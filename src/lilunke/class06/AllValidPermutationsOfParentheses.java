package lilunke.class06;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParentheses {
    public List<String> validParentheses(int n) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        validParentheses(n, res, 0, 0, sb, 0);
        return res;
    }

    private void validParentheses(int n, List res, int l, int r, StringBuilder sb, int level) {
        if (level == 2 * n) {
            res.add(sb.toString());
            return;
        }

        // case1: we can add right
        if (r < l && r < n) {
            sb.append(")");
            validParentheses(n, res, l, r + 1, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        // case2: we can add left
        if (l < n) {
            sb.append("(");
            validParentheses(n, res, l + 1, r, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        AllValidPermutationsOfParentheses here = new AllValidPermutationsOfParentheses();
        List res = here.validParentheses(3);
        System.out.println(res);
    }
}
