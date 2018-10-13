package pastOA.pureStorage;

import java.util.HashSet;
import java.util.LinkedList;

public class LockAnalyzer {
    public int ana(String[] in) {
        if (in == null || in.length == 0) {
            return 0;
        }
        LinkedList<String> stack =  new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (String s : in) {
            count++;
            String num = s.split(" ")[1];
            if (s.startsWith("R")) {
                if (stack.isEmpty() || !stack.peekFirst().startsWith("A") || !num.equals(stack.peekFirst().split(" ")[1])) {
                    return count;
                } else {
                    set.remove(Integer.valueOf(num));
                    stack.pollFirst();
                }
            } else {
                if (set.add(Integer.valueOf(num))) {
                    stack.addFirst(s);
                } else {
                    return count;
                }
            }
        }
        if (stack.isEmpty()) {
            return 0;
        } else {
            return in.length + 1;
        }
    }

    public static void main(String[] args) {
        LockAnalyzer here = new LockAnalyzer();
        String[] in1 = {"AC 364", "AC 84", "RE 84", "AC 1337", "RE 1337", "RE 364"};
        System.out.println(here.ana(in1));
        String[] in2 = {"AC 364", "AC 84", "RE 364", "RE 84"};
        System.out.println(here.ana(in2));
        String[] in3 = {"AC 364", "AC 84", "RE 84"};
        System.out.println(here.ana(in3));
        String[] in4 = {"AC 364", "RE 84", "RE 364"};
        System.out.println(here.ana(in4));
        String[] in5 = {"AC 364", "AC 84", "AC 84", "RE 364"};
        System.out.println(here.ana(in5));
    }
}
