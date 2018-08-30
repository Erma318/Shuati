package drawBridge;

import java.util.Arrays;
import java.util.List;

public class stringValid {
    public String stringValid(String[] input) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            if (valid(input[i])) {
                res.append("Valid");
                if (i != input.length - 1) {
                    res.append("\n");
                }
            } else {
                res.append("Invalid");
                if (i != input.length - 1) {
                    res.append("\n");
                }
            }
        }
        return res.toString();
    }
    private boolean valid(String input) {
        String[] in = input.split(",");
        if (in.length != 2) return false;
        char[] left = in[0].toCharArray();
        char[] right = in[1].toCharArray();
        if (left[0] != '(' || right[right.length - 1] != ')') return false;
        if (left[1] == ' ' || left[left.length - 1] > 57 || left[left.length - 1] < 48|| right[0] != ' ' || right[right.length - 2] > 57 || right[right.length - 2] < 48) return false;
        StringBuilder sbl = new StringBuilder();
        StringBuilder sbr = new StringBuilder();
        for (int i = 1; i < left.length; i++) {
            if ( left[i] > 57 || left[i] < 48) {
                if (i == 1 && (left[i] == '+' || left[i] == '-')) {

                } else {
                    return false;
                }
            }
            sbl.append(left[i]);
        }
        double X = Double.parseDouble(sbl.toString());
        for (int i = 1; i < right.length - 1; i++) {
            if ( right[i] > 57 || right[i] < 48) {
                if (i == 1 && (right[i] == '+' || right[i] == '-')) {

                } else {
                    return false;
                }
            }
            sbr.append(right[i]);
        }
        double Y = Double.parseDouble(sbr.toString());
        if (X < -90 || X > 90 || Y < -180 || Y > 180) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        stringValid here = new stringValid();
        String[] input = {"(75, 180)",
                "(+90, +180.2)",
                "(90, 180)"};
        System.out.println(here.stringValid(input));
    }

}
