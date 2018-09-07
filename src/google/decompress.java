package google;

public class decompress {
    public String decom(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        StringBuilder res = helper(sb);
        return res.toString();
    }

    private StringBuilder helper(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) <= 57 && sb.charAt(i) >= 48) {
                int temp = i;
                while (sb.charAt(i + 1) <= 57 && sb.charAt(i + 1) >= 48) {
                    i = i + 1;
                }
                int times = Integer.parseInt(sb.substring(temp, i + 1));
                StringBuilder in = findIn(sb, i + 1);
                StringBuilder attach = helper(in);
                for (int j = 0; j < times; j++) {
                    res.append(attach);
                }
                i = i + in.length() + 2;

            } else {

                res.append(sb.charAt(i));
            }

        }
        return res;
    }

    private StringBuilder findIn(StringBuilder sb, int i) {
        int count = 0;
        String res = "";
        for (int k = i; k < sb.length(); k++) {

            if (sb.charAt(k) == '[') {
                count++;
            } else if (sb.charAt(k) == ']') {
                count--;
                if (count == 0) {
                    res = sb.substring(i + 1, k);
                    break;
                }
            }
        }

        StringBuilder re = new StringBuilder();
        re.append(res);
        return re;
    }

    public static void main(String[] args) {
        decompress here = new decompress();
        System.out.println(here.decom("a3[b2[c1[d]]]e"));

    }
}
