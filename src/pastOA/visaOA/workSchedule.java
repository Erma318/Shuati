package pastOA.visaOA;

import java.util.ArrayList;
import java.util.List;

public class workSchedule {
    public List<String> timeSchedule(String pattern, int work_hours, int day_hours) {
        int hour = 0;
        for(int i = 0; i < pattern.length(); i++) {
            if(Character.isDigit(pattern.charAt(i))) {
                hour += pattern.charAt(i) - '0';
            }
        }
        int rest = work_hours - hour;
        List<String> res = new ArrayList<>();
        backtracking(day_hours, rest, res, pattern, 0, "");
        return res;
    }

    public void backtracking(int day_hours, int rest, List<String> res, String pattern, int idx, String buffer) {
        if(idx == pattern.length()) {
            if(rest == 0) {
                res.add(buffer);
            }
            return;
        }
        if(pattern.charAt(idx) == '?') {
            for(int i = 0; i <= Math.min(day_hours, rest); i++) {
                backtracking(day_hours, rest - i, res, pattern, idx + 1, buffer + i);
            }
        } else {
            backtracking(day_hours, rest, res, pattern, idx + 1, buffer + pattern.substring(idx, idx + 1));
        }
    }

    public static void main(String[] args) {
        String pattern = "???8???";
        int work_hours = 56;
        int day_hours = 8;

        System.out.println();
    }
}

