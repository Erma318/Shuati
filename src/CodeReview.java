import java.util.*;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class CodeReview {
    public void sort(LinkedList<Integer> s1) {
        if (s1.isEmpty()) return;
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        int min = Integer.MAX_VALUE;
        int count = 1;
        while (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                int cur = s1.pollFirst();
                if (cur < min) {
                    min = cur;
                    count = 1;
                } else if (cur == min) {
                    count++;
                }
                s2.offerFirst(cur);
            }
            while (!s2.isEmpty() && s2.peekFirst() >= min) {
                int cur = s2.pollFirst();
                if (cur != min) {
                    s1.offerFirst(cur);
                }
            }
            for (int i = 0; i < count; i++) {
                s2.offerFirst(min);
            }
            if (s1.isEmpty()) {
                break;
            } else {
                min = Integer.MAX_VALUE;
            }
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.offerFirst(3);
        s1.offerFirst(1);
        s1.offerFirst(2);
        s1.offerFirst(4);
        CodeReview here = new CodeReview();
        here.sort(s1);
        System.out.println(s1);
    }
}
