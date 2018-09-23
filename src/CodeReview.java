import com.sun.org.apache.bcel.internal.classfile.Code;
import sun.reflect.generics.tree.Tree;

import java.util.*;




public class CodeReview {
    public int strstr(String large, String small) {
        // Write your solution here
        if (small.length() == 0) return 0;
        for (int i = 0; i <= large.length() - small.length(); i++) {
            if (check(large.substring(i, i + small.length()), small)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("19780110".compareTo("20091001"));
        String s = "x.y.z";
        String[] o = s.split("\\.");
        System.out.println(Arrays.toString(o));

    }
}
