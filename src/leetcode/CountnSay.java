package leetcode;

public class CountnSay {
    public String countAndSay(int n) {
        //assume n >= 1
        int i = 1;
        StringBuilder prev;
        StringBuilder cur = new StringBuilder("1");
        while (i <= n) {
            prev = cur;
            cur = new StringBuilder();
            int count = 1;
            char c = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) == c) {
                    count += 1;
                } else {
                    cur.append(count);
                    cur.append(c);
                    c = prev.charAt(j);
                    count = 1;
                }
            }
            cur.append(count).append(c);
            i++;
        }
        return cur.toString();
    }
}
