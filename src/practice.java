
import java.util.*;

public class practice{
    private String[] split(String s) {
        int i = 0;
        String[] res = new String[2];
        for (; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
        }
        for (; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                break;
            }
        }
        res[0] = s.substring(0, i);
        res[1] = s.substring(i, s.length());
        return res;
    }

    public String solution(int N, String S, String T) {
        //preprocess hit
        int[] res = {0,0}; // sunk hit
        String[] hit = T.split(" ", -1);
        Set<String> set = new HashSet<>();
        for (String h : hit) {
            set.add(h);
        }
        //preprocess ship locations
        String[] slocat = S.split(",",-1);
        List<String> tl = new ArrayList<>();
        List<String> br = new ArrayList<>();
        for (String str : slocat) {
            String[] temp = str.split(" ",-1);
            if (temp.length != 2) {
                String[] temp0 = split(str);
                tl.add(temp0[0]);
                br.add(temp0[1]);
            } else {
                tl.add(temp[0]);
                br.add(temp[1]);
            }

        }
        //iterate over all ships
        for (int i = 0; i < tl.size(); i++) {
            int tlnum = Integer.parseInt(tl.get(i).substring(0,tl.get(i).length()-1));
            int brnum = Integer.parseInt(br.get(i).substring(0,br.get(i).length()-1));
            char tlchar = tl.get(i).charAt(tl.get(i).length() - 1);
            char brchar = br.get(i).charAt(br.get(i).length() - 1);
            int area = (brchar - tlchar + 1)*(brnum - tlnum + 1);
            int temp = area;
            for (int num = tlnum; num <= brnum; num++){
                for (char word = tlchar; word <= brchar; word++) {
                    StringBuilder s = new StringBuilder();
                    if (num > 9){
                        char first = (char) (num/10 + 48);
                        char second = (char) (num%10 + 48);
                        s.append(first).append(second).append(word);
                    } else {
                        char numchar = (char)(num + 48);
                        s.append(numchar).append(word);
                    }
                    if (set.contains(s.toString())) {
                        area--;
                    }
                }
            }
            if (area == 0) {
                res[0]++;
            } else if (area != temp){
                res[1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (res[0] > 9) {
            while (res[0] != 0) {
                char cha = (char) (res[0]%10 + 48);
                res[0] = res[0]/10;
                sb.append(cha);
            }
            sb.reverse();
        } else {
            char numchar = (char) (res[0] + 48);
            sb.append(numchar);
        }
        sb.append(",");
        StringBuilder sd = new StringBuilder();
        if (res[1] > 9) {
            while (res[1] != 0) {
                char cha = (char) (res[1]%10 + 48);
                res[1] = res[1]/10;
                sd.append(cha);
            }
            sd.reverse();
        } else {
            char numchar = (char) (res[1] + 48);
            sd.append(numchar);
        }
        sb.append(sd);
        return sb.toString();
    }

    public static void main(String[] args) {
        practice machine = new practice();
        int N = 1;
        //String S = "1A 1A";
      String S = "1B2C,2D4D";
        String T = "1A";
        System.out.println(machine.solution(N,S,T));
    }
}
