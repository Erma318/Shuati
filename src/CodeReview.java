import java.sql.Timestamp;
import java.util.*;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CodeReview {
    public class B {

    }
    public boolean check(int[] input) {
        if (input == null || input.length == 0) return true;
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            set.add(index);
            if (index + input[index] < 0) {
                index = input.length + (index + input[index]) % input.length;
            } else {
                index = Math.abs(index + input[index]) % input.length;
            }
        }
        if (index == 0 && set.size() == input.length) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CodeReview here = new CodeReview();
        int[] input = {1,3,1,-5,-2,1};
        int[] input2 = {1,2,1,3,-2,2};
        int[] input3 = {1,3,1,2,-2,2};
        System.out.println(here.check(input));
        System.out.println(here.check(input2));
        System.out.println(here.check(input3));
    }

}

