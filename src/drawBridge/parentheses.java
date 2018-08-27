package drawBridge;

import java.util.LinkedList;

/*
就是一堆"<<>>><"这种字符串， 和一个最大的替代次数， 看能不能平衡。
如果有多的">"， 只能用"<>"替代， 而不是删掉。 多的"<"就没办法了， 返回不能平衡就行了。
 */
public class parentheses {
    public boolean isBalanced(String input, int k) {
        char[] myChar = input.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < myChar.length; i++) {
            if (!stack.isEmpty() && stack.peekFirst() == '<' && myChar[i] == '>' ) {
                stack.pollFirst();
            } else {
                stack.addFirst(myChar[i]);
            }
        }
        while(!stack.isEmpty()) {
            char temp = stack.pollFirst();
            if (temp == '<') return false;
            if (temp == '>') {
                if (k > 0) {
                    k--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        parentheses here = new parentheses();
        String input = "<<>><>><";
        System.out.println(here.isBalanced(input, 0));
    }
}
