package pastOA.goldman;

import java.util.LinkedList;
import java.util.List;

public class csvFormat {
    static String formatCSV(List<String> CSV) {
        StringBuilder res = new StringBuilder();
        int colnum = 0;
        for (String s : CSV) {
            String[] cur = s.split(",");
            if (s.charAt(s.length() - 1) == ',') {
                colnum = Math.max(colnum, cur.length + 1);
            } else {
                colnum = Math.max(colnum, cur.length);
            }
        }
        int[] maxlength = new int[colnum];
        for (String s : CSV) {
            String[] cur = s.split(",");
            int i = 0;
            for (String ss : cur) {
                maxlength[i] = Math.max(maxlength[i], ss.length());
                i++;
            }
        }
        int kt = 0;
        for (String s : CSV) {

            String[] cur = s.split(",");
            System.out.println(cur.length);
            if (cur.length == 0 && kt == 0) {
                int col = cur.length;
                for (int i =0; i < colnum; i++) {
                    int space = maxlength[i];
                    for (int k = 0; k < space; k++) {
                        res.append(" ");
                    }
                    if (i != colnum - 1) {
                        res.append(", ");
                    }
                }
                res.append("\n");
            } else {
                int col = cur.length;
                int i = 0;
                for (String ss : cur) {
                    int space = maxlength[i] - ss.length();
                    for (int n =0; n < space; n++) {
                        res.append(" ");
                    }
                    res.append(ss);
                    if (i != col - 1) {
                        res.append(", ");
                    }
                    i++;
                }
                res.append("\n");
            }
            kt ++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        List<String> file = new LinkedList<String>();
        file.add("a,b,b,b");
        file.add(",,,");
        file.add("Susan Smith,Mathematics,84,");
        System.out.println(formatCSV(file));
    }
}
