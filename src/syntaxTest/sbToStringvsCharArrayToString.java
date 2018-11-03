package syntaxTest;

import java.util.LinkedList;
import java.util.List;

public class sbToStringvsCharArrayToString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();
        sb.append("abcd");
        res.add(sb.toString());
        sb.deleteCharAt(3);
        System.out.println(res);
        char[] mychar = {'a','b','c','d'};
        res.add(mychar.toString());
        mychar[3] = 'e';
        System.out.println(res);

    }
}
