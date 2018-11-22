package googleOA;

import java.util.HashMap;

public class email {
    public int solution(String[] L) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String e : L) {
            String[] email = e.split("@");
            String local = email[0];
            // count leading dots
            int start = 0;
            while (start < local.length()) {
                if (local.charAt(start) == '.') {
                    start++;
                } else {
                    break;
                }
            }
            //count ending dots
            int end = local.length() - 1;
            while (end >= 0) {
                if (local.charAt(end) == '.') {
                    end--;
                } else {
                    break;
                }
            }
            String[] localArray = local.substring(start, end + 1).split("\\+");
            char[] mychar = localArray[0].toCharArray();
            int i = 0;
            for (int j = 0; j < mychar.length; j++) {
                if (mychar[j] != '.' ) {
                    mychar[i++] = mychar[j];
                }
            }
            String ee = new String(mychar,0, i) + email[1];
            if (!map.containsKey(ee)) {
                map.put(ee, 0);
            }
            map.put(ee, map.get(ee) + 1);
        }
        int count = 0;
        for (int i : map.values()) {
            System.out.println(i);
            if (i >= 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        email here = new email();
        String[] L = {
                "..a.b@example.com",
                "x@example.com",
                "x@exa.mple.com",
                "...ab+1@example.com",
                "y@example.com",
                "y@example.com",
                "y@example.com"
        };
        System.out.println(here.solution(L));
    }
}
