package pastOA.barclays;

import java.util.*;

public class q4 {
    public static String find(String line) {
        String[] input = line.split(",");
        Integer l = Integer.parseInt(input[0]);
        List<Character> s = parse(input[1]);
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        DFS(s, res, temp, 0, l);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private static List<Character> parse(String input) {
        char[] mychar = input.toCharArray();
        List<Character> res = new ArrayList<>();
        HashSet contains = new HashSet();
        for (char c : mychar) {
            contains.add(c);
        }
        Iterator<Character> it = contains.iterator();
        while(it.hasNext()) {
            Character cur = it.next();
            res.add(cur);
        }
        Collections.sort(res);
        return res;
    }

    private static void DFS(List<Character> s, StringBuilder res, StringBuilder temp, int index, int l) {
        if (index == l) {
            res.append(temp);
            res.append(",");
            return;
        }
        for (char c : s) {
            temp.append(c);
            DFS(s, res, temp, index + 1, l);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
