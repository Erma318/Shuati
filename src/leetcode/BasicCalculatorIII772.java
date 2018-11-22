package leetcode;

import java.util.Stack;

/**
 * Created by effyfeng 11:14 AM 8/26/18
 **/
public class BasicCalculatorIII772 {
    public static void main(String[] Ags) {
        BasicCalculatorIII772 sol = new BasicCalculatorIII772();
        int result = sol.calculateIII2Stack("2-(12-(5*2-3))/2");
        System.out.println(result);
    }

    public static int calculateIII2Stack(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>(); // the stack that stores numbers
        Stack<Character> ops = new Stack<>(); // the stack that stores operators (including parentheses)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                nums.push(num);
                i--;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                /***到这里括号内保证是同一级的 用while都算完
                 * 比如 （** / / - - +）用下面的if算完优先符号 再来括号里面 算 - - + + ***/
                while (ops.peek() != '(')
                /***如果当前优先级高可以暂时不算的原因是 上线在)计算时候是从右边优先级到左边的
                 * 所以右边优先级高无所谓**/
                /****前面都不是 那么久是走在一个括号内容的中间
                 * 把一个括号内 高于我的优先级的先算掉 比如一些列****- -之前要把*都算掉
                 * 后把自己push进去****/
                    nums.push(evaluateTop(ops.pop(), nums.pop(), nums.pop()));

                ops.pop(); // get rid of '(' in the ops stack

            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek()))
                    nums.push(evaluateTop(ops.pop(), nums.pop(), nums.pop()));
                /**(5*2-3) -号的优先级低于* 会先算出10再把-push进去
                 * 左右括号的case 在上面解决了
                 * 如果当前符号优先级低于上一个（stacktop）符号的优先级 先把上一个符号的算了
                 * 到了这里 assume是同一个括号
                 * 就是说括号的优先级最低  没有符号比括号还要低 其他的都比括号高都不能算
                 * 谁优先级高算谁
                 * 为什么优先级低trigger算:用优先级规定和模仿recursion的层级
                 * 为什么括号优先级低 **/
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(evaluateTop(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private static int evaluateTop(char op, int b, int a) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else if (op == '/') {//else if (op == '/'&& b!=0) {这么写比较好
            return a / b; // assume b is not 0
        }
        return 0;
    }

    private static boolean precedence(char cur, char prev) {
        if (prev == '(' || prev == ')')
            return false;
        /**不管当前是 +-* / 现在肯定不算 到括号的时候算 比较只是+-和 * /法的比较
         * 括号要遇到右边括号才算 ***/
        //当前优先级高就不算
        if ((cur == '*' || cur == '/') && (prev == '+' || prev == '-'))
            return false;
        // 乘除优先于加减，左优先于右
        /**prev 的高包括：
         1. 如果是cur = -+ prev= * / 先算prev
         2. 如果是cur= +- prev= +- 先算prev */
        return true;
    }
}

    /**
     * 1.当前符号比上一个符号优先级高，比如* 高于+，那么直接进栈
     * 2.当前符号低于上一个，那么就要把所有已经在stack里面优先于当前符号的全算完，再推进当前符号
     * 3.当前符号是“（ ”，直接push
     * 4.当前符号是“ ）”，就要把所有“（”以前的符号全部算完
     **/
//    public int calculateIII772(String s) {
//        /**遇见number结账 还可以遇见sign的符号结账
//         * STACK存历史结果**/
//        Deque<Integer> stack = new ArrayDeque<>();
//        char preSign = '+';
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            //1
//            if (c == ' ') continue;
//
//            int curDigit = c - '0';
//            //2
//            if ((curDigit <= 9 && curDigit >= 0) || c == '(') {
//                int curNum = 0;
//                if (c == '(') {
//                    int count = countValid(s.substring(i));
//                    curNum = calculateIII772(s.substring(i + 1, i + count));
//                    i += (count - 1);
//                } else {
//                    while (i < s.length() && s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
//                        curNum = curNum * 10 + s.charAt(i) - '0';
//                        i++;
//                    }
//                    i--;
//                }
//                // curDigit >9 || <0 go to else next round
//                if (preSign == '+') {
//                    stack.push(curNum);
//                } else if (preSign == '-') {
//                    stack.push(curNum * (-1));
//                } else if (preSign == '*') {
//                    stack.push(stack.poll() * curNum);
//                } else if (preSign == '/') {
//                    stack.push(stack.poll() / curNum);
//                }
//            } else {//3
//                preSign = c;
//            }
//        }
//        int res = 0;
//        while (!stack.isEmpty()) {
//            res += stack.poll();
//        }
//        return res;
//    }
//
//    //return （）包含左（ 右）在内的字符串长度
//    int countValid(String s) {
//        int counter = 0;
//        int i = 0;
//        while (i < s.length()) {
//            if (s.charAt(i) == '(') counter++;
//            else if (s.charAt(i) == ')') counter--;
//            if (counter == 0) break;
//            i++;
//        }
//        return i;
//    }
