package past.bloomberg;

import java.util.LinkedList;
import java.util.List;

public class deepParenthesesString {
    /*
    有若干个平衡的大中小括号（都是合法的），让输出最deep的某几个括号中的字符串，这里注意：1. 最深层可能不止一个。2. 字符串有可能是空字符，这个也要输出。例如{a[bs]c}(d) 输出bs， {a[bs]c}(d(d))输出bs,d。

     */
    public List<String> findDeep(String in) {
        List<String> res = new LinkedList<>();
        if (in == null || in.length() == 0) {
            return res;
        }
        int stack = 0;
        int s = 0;
        int e = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '{' || in.charAt(i) == '[' || in.charAt(i) == '(') {
                stack++;
                s = i + 1;
                e = i;
            } else if (in.charAt(i) == '}' || in.charAt(i) == ']' || in.charAt(i) == ')') {
                if (stack > max) {
                    res = new LinkedList<>();
                    res.add(in.substring(s, e + 1));
                    max = stack;
                } else if (stack == max) {
                    res.add(in.substring(s, e + 1));
                }
                stack--;
            } else {
                e++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        deepParenthesesString here = new deepParenthesesString();
        System.out.println(here.findDeep("{a[bs]c}(d)"));
    }
}
