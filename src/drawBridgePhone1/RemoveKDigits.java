package drawBridgePhone1;

import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len)
            return "0";
        LinkedList<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peekFirst() > num.charAt(i)) {
                stack.pollFirst();
                k--;
            }
            stack.offerFirst(num.charAt(i));
            i++;
        }
        while (k > 0) {
            stack.pollFirst();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        RemoveKDigits here = new RemoveKDigits();
        System.out.println(here.removeKdigits("1432219", 3));

    }
}