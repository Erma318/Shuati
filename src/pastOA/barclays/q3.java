package pastOA.barclays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class q3 {
    public static String find(String line) {
        String[] input = line.split(" ");
        int m = Integer.parseInt(input[1]);
        StringBuilder res = new StringBuilder();
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        List<Integer> mylist = new ArrayList<>();
        // assumption: the DNA string is longer than the segment string
        int slength = input[0].length();
        int dlength = input[2].length();
        int maxIndex = dlength - slength;
        for (int i = 0; i <= maxIndex; i++) {
            String string2 = input[2].substring(i, i + slength);
            int editNum = editDistance(input[0], string2);
            if (editNum <= m) {
                if (hashMap.containsKey(editNum)) {
                    hashMap.get(editNum).add(string2);
                } else {
                    hashMap.put(editNum, new ArrayList<>());
                    mylist.add(editNum);
                    hashMap.get(editNum).add(string2);
                }

            }
        }
        Collections.sort(mylist);
        for (int n : mylist) {
            Collections.sort(hashMap.get(n));
            for (String s : hashMap.get(n)) {
                res.append(s);
                res.append(" ");
            }
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private  static int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i][j - 1] + 1, distance[i - 1][j] + 1);
                    distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i][j]);
                }
            }
        }
        return distance[one.length()][two.length()];
    }
}
