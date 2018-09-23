package GuideWire;

import leetcode.GraphValidTree;

public class GuideWireOA {
    public static String solution(String S) {
        // write your code in Java SE 8
        String[] rows = S.split("\\n");
        String result = "";
        for (String row : rows) {
            String[] items = row.trim().split(" ");
            long size = Long.valueOf(items[0]);
            if (size >= 81920) {
                continue;
            }
            String[] name = items[2].split("\\.");
            String ext = name[name.length - 1].toLowerCase();
            if (ext.equals("txt") || ext.equals("html") || ext.equals("xml")) {
                String[] time = items[1].split("\\.");
                String timeTrans = time[2] + time[1] + time[0];
                if (result == "") {
                    result = timeTrans;
                } else {
                    if (timeTrans.compareTo(result) < 0) {
                        result = timeTrans;
                    }
                }
            }
        }
        if (result == "") return "NO FILES";
        return result.substring(6, 8) + "." + result.substring(4, 6) + "." + result.substring(0, 4);
    }
    public static void main(String[] args) {
        String s = "       81920 10.01.2000 SYSTEM.TXT\n      81920 23.04.1983 notes.xml\n       81920 28.08.1978 file.xml\n       81920 05.02.1966 TEMPORARY.FLV\n 468713472 17.02.1986 important.html\n    457728 11.06.1990 BUG-REPORT.PDF\n     81920 29.10.1975 TO-DO-LIST.HTML";
        System.out.println(solution(s));
    }
}
