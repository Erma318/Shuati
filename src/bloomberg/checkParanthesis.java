package bloomberg;

import java.util.Deque;
import java.util.LinkedList;

public class checkParanthesis {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        char[] mychar = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (char x : mychar) {
            if (stack.isEmpty()) {
                stack.offerFirst(x);
            } else if (x == ')') {
                if (stack.peekFirst() == '(')
                    stack.pollFirst();
            } else if (x == '}') {
                if (stack.peekFirst() == '{')
                    stack.pollFirst();
            } else if (x == ']') {
                if (stack.peekFirst() == '[')
                    stack.pollFirst();
                else stack.offerFirst(x);
            } else {
                stack.offerFirst(x);
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        checkParanthesis here = new checkParanthesis();
        System.out.print(here.isValid("(])"));
    }
}
